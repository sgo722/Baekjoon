import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 시작 - 21:35
 * 아이디어
 * 시간이 적게 걸리는 순서대로 나열한 후, 다른 배열에 1~n번째의 합을 저장한다.
 */
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		int[] sum = new int[n];
		int ans = 0;
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = 0;
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++){
				sum[i] += arr[j];
			}
		}
		
		for(int i=0; i<n; i++) {
			ans += sum[i];
		}
		
		System.out.println(ans);
	}
}