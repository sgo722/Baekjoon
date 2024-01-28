import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 문제 : N과 M(8)
 * 시작 - 14:07
 * 아이디어 :
 * 재귀의 매개변수로 넘어가는 인자부터 탐색해서 해결해보자
 */


public class Main {
	
	static int n,m;
	static int[] arr, ans;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		
		arr = new int[n];
		ans = new int[m];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		go(0,0);
		
		System.out.println(sb);
	}
	
	static void go(int here, int count) {
		if(count == m) {
			for(int i=0; i<m; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int there = here; there<n; there++) {
			ans[count] = arr[there];
			go(there,count+1);
		}
	}
}
