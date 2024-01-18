import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 문제 시작 - 01:18
 * 아이디어 - 그래프탐색문제여서 그냥 bfs 구현하면 풀릴 것 같다
 * 다만 C++을 사용하면 vector를 사용하면 금방 맞출수있는 문제라 생각하는데, 자바에서는 어떻게 코드를 짜야할지 잘 모르겠다.
 */
public class Main{
	static int t;
	static int[][] v;
	static int[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());
		
		v = new int[t+1][t+1];
		visited = new int[t+1];
		int cnt = 0;
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			v[a][b] = 1;
			v[b][a] = 1;
		}
		
		go(1);
		
		for(int i=1; i<=t; i++) {
			if(visited[i] == 1) {
				cnt++;
			}
		}
		cnt--; // 1번 컴퓨터를 제외해야한다.
		System.out.println(cnt);
	}
	
	public static void go(int here) {
		if(visited[here] == 1) return;
		visited[here] = 1;
		for(int i=1; i<=t; i++) {
			if(visited[i] == 1) continue;
			if(v[here][i] == 1) go(i);
		}
	}
}