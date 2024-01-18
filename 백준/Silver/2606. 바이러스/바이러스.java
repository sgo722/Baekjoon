import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

/**
 * 문제 시작 - 01:18
 * 아이디어 - 그래프탐색문제여서 그냥 bfs 구현하면 풀릴 것 같다
 * 다만 C++을 사용하면 vector를 사용하면 금방 맞출수있는 문제라 생각하는데, 자바에서는 어떻게 코드를 짜야할지 잘 모르겠다.
 * 2. 인접리스트 사용하는법을 몰라서 구글링하고 코드고쳐보기
 */
public class Main{
	static ArrayList<Integer>[] a;
	static int t, count = 0;
	static int[][] v;
	static int[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());
		
		a = new ArrayList[t+1];
		visited = new int[t+1];
		int cnt = 0;
		
		int n = Integer.parseInt(br.readLine());
		for(int i=1; i<=t; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			a[u].add(v);
			a[v].add(u);
		}
		
		go(1);
		System.out.println(count);
	}
	
	public static void go(int here) {
		visited[here] = 1;
		for(int there : a[here]) {
			if(visited[there] == 1) continue;
			go(there);
			count++;
		}
	}
}