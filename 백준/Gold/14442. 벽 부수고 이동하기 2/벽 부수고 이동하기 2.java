
import java.io.*;
import java.util.*;

public class Main {

	static class Point {
		int y;
		int x;
		int count;

		public Point(int count, int y, int x) {
			this.count = count;
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Point [y=" + y + ", x=" + x + ", count=" + count + "]";
		}
		
		
	}

	static int[][] map;
	static int[][][] visited;

	static int[] dy = { -1, 0, 1, 0,};
	static int[] dx = { 0, 1, 0, -1 };

	static int n, m, k;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new int[k + 1][n][m];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		bfs();

		for(int i=0; i<=k; i++) {
			if(visited[i][n-1][m-1] > 0) {
				ans = Math.min(visited[i][n-1][m-1], ans);
			}
		}
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

	static void bfs() {
		
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0,0));
		visited[0][0][0] = 1;
		
		while(q.size() > 0) {
			Point p = q.poll();
			int y = p.y;
			int x = p.x;
			int count = p.count;
	
		
			if(y == n-1 && x == m-1) break;
//			System.out.println(p);
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || nx < 0 || ny >= n || nx >= m || count > k) continue;
				if(visited[count][ny][nx] > 0) continue;
				if(map[ny][nx] == 1 && count < k  && visited[count+1][ny][nx] == 0) { // 벽이면?
					visited[count+1][ny][nx] = visited[count][y][x] + 1;
					q.add(new Point(count+1,ny,nx));
				}else if(map[ny][nx] == 0 && count <= k){ // 벽이 아니면?
					visited[count][ny][nx] = visited[count][y][x] + 1;
					q.add(new Point(count,ny,nx));
				}
			}
		}
		
//		printDebug();
	}
	
	static void printDebug() {
		for(int i=0; i<=k; i++) {
			for(int y=0; y<n; y++) {
				for(int x =0; x<m; x++) {
					System.out.print(visited[i][y][x] + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}
	}
}