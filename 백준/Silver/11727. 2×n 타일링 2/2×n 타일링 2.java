import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 * 문제시작 - 14:55
 * 아이디어 - 못풀겠어서 답봄
 */

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1004];
		dp[1] = 1;
		dp[2] = 3;
		for(int i=3; i<=1000; i++) {
			dp[i] = (dp[i-2] * 2 + dp[i-1]) % 10007;
		}
		System.out.println(dp[n]);
	}
}