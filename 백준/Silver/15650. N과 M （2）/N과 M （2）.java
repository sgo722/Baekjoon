import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
/**
 * 문제시작 - 09:25
 * 아이디어 -
 * N과 M문제에서 정렬하고 중복제
 * 
 */

public class Main{
	
	public static HashSet<String> set;
	public static int[] arr;
	public static int n,m;
	public static int[] visited;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		set = new LinkedHashSet<String>();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		visited = new int[n+1];
		combi(0);
		
		for(String here : set) {
			sb.append(here+"\n");
		}
		System.out.println(sb);
	}
	
	public static void combi(int depth) {
		if(depth == m) {
			StringBuilder nsb = new StringBuilder();
			int[] temp = Arrays.copyOf(arr,m);
			Arrays.sort(temp);
			for(int num : temp) {
				nsb.append(num).append(' ');
			}
			set.add(nsb.toString());
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				arr[depth] = i;
				combi(depth+1);
				visited[i] = 0;
			}
		}
	}
}

