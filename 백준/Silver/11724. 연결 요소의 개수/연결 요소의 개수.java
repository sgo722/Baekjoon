import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
/**
 * 문제시작 - 23:30
 * 아이디어
 * bfs문제로 해결할 수 있을 것 같다.
 * 인접리스트로 문제를 풀어보자
 * 2차원 배열을 선언하는 방법을 잘 몰랐음.
 * 구현완료 - 23:51
 */

public class Main{
	static int n;
	static ArrayList<Integer>[] arr;
	static int[] visited;
	static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		visited = new int[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}
		
		for(int i=1; i<=n; i++) {
			if(visited[i] == 0) {
				count++;
				go(i);
			}
		}
		System.out.println(count);
	}
	
	public static void go(int here) {
		visited[here] = 1;
		for(int there : arr[here]) {
			if(visited[there] == 0) {
				go(there);
			}
		}
	}
}