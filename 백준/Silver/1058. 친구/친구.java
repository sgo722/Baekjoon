import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
	static int n;
	static int[][] friend;
	static boolean[] visited;
	static int maxCount = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		friend = new int[n][n];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				if(str.charAt(j) == 'Y') { // Y이면 동적배열에 추가한다.
					friend[i][j] = 1;
				}else {
					friend[i][j] = 0;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			visited = new boolean[n];
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			visited[i] = true;
			int count = 0;
			
			for(int depth=0; depth<2; depth++) {
				int qSize = q.size();
				for(int j=0; j<qSize; j++) {
					int num = q.poll();
					for(int k=0; k<n; k++) {
						if(i != k && !visited[k] && friend[num][k] == 1) {
							visited[k] = true;
							q.add(k);
							count++;
						}
					}
				}
			}
			if(maxCount < count) {
				maxCount = count;
			}
		}
		System.out.println(maxCount);
	}
}