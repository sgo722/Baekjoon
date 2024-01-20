import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
/**
 * 문제시작 - 22:25
 * 아이디어
 * 구간합 배열을 만들어서 빼주면 될것같다.
 * BufferedReader + StringBuilder 시간단축
 * 구현완료 - 22:39
 */

public class Main{
	static int n,m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n+1];
		int prev = 0;
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) + prev;
			prev = arr[i];
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			a--;
			sb.append(arr[b]-arr[a]).append('\n');
		}
		
		System.out.println(sb);
	}
}