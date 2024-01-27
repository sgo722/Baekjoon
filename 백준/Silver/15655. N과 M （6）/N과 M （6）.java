import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


/**
 * 문제 : N과 M(6)
 * 아이디어 : 주어진 배열을 정렬하고, 조합을 구현하는 재귀로 풀어보자.
 */


public class Main {
	static int n,m;
	static int[] arr, visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		arr = new int[n];
		visited = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		combi(-1,0);
		System.out.print(sb);
	}
	
	static void combi(int here, int count) {
		if(here == n) return;
		if(count == m) {
			for(int i=0; i<n; i++) {
				if(visited[i] == 1) {
					sb.append(arr[i] +  " ");
				}
			}
			sb.append("\n");
			return;
		}
		
		for(int there=here+1; there<n; there++) {
			visited[there] = 1;
			combi(there,count+1);
			visited[there] = 0;
		}
	}
}