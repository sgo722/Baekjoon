import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 * 문제시작 - 14:30
 * 아이디어 - 8번쨰 사각형 이후로, 규칙이 만들어진다.
 * 8번째 삼각형 이후로 dp[i] = dp[i-1]+dp[i-5]식이 성립한다.
 * 1초인데 N이 100이라 시간초과는 없음
 * 문제점 : 이 로직대로면 79에서 int범위를 넘어가는 문제가 있었음.
 */

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] dp = new long[104];
		
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		dp[6] = 3;
		dp[7] = 4;
		dp[8] = 5;
		for(int i=9; i<=100; i++) {
			dp[i] = dp[i-1] + dp[i-5];
		}
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=0; tc<t; tc++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(dp[num]);
		}
		
	}
}

