import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main{
	
	static class Point{
		private int y;
		private int x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int n;
	static final int MAX_N = 987654321;
	static int[][] a;
	static int[][] visited;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int cnt = 0;
		while(true) {
			cnt++;
			n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			a = new int[n][n];
			visited = new int[n][n];
			for(int i=0; i<n; i++) {
				st =  new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					visited[i][j] = MAX_N;
				}
			}
			visited[0][0] = a[0][0];
			go(0,0);
			sb.append("Problem " + cnt + ": "+ visited[n-1][n-1] + "\n");
		}
		System.out.println(sb);
	}

	static void go(int y, int x){
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(y,x));
		
		while(!q.isEmpty()) {
			Point front = q.poll();
			y = front.y;
			x = front.x;
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
				if(visited[ny][nx] > (visited[y][x] + a[ny][nx])) {
					visited[ny][nx] = visited[y][x] + a[ny][nx];
					q.add(new Point(ny,nx));
				}
			}
		}
	}
}