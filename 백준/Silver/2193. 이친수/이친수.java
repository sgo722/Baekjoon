import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 문제시작 - 22:42
 * 아이디어 -
 * 사이즈가 n이거나 11을 포함하면 반환한다.
 * String을 넘기면서 그 스트링 객체에 "11"이 포함되지않으면 이친수기때문에 전역변수 count수를 증가시킨다.
 * 
 * 틀린이유 1.
 * n이 90이라서 시간초과가 날 수도 있겠다 싶었는데 메모리초과가 나네?
 * 여튼간에 2^90이라서 메모리초과가 아니였어도 시간초과가 났을것같다.
 * String 객체를 생성하는 과정에서 메모리초과가 발생한 것 같다.
 * dp[i] = dp[i-1] + dp[i-2];
 * i-1은 0만 넣어야 하는 경우
 * i-2는 01을 넣어야 하는 경우로 나뉘는것같다.
 * 
 * 틀린이유 2.
 * 범위문 
 */

public class Main{
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		long[] dp = new long[94];
		
		dp[1] = 1;
		dp[2] = 1;
		for(int i=3; i<=n; i++) { // 90으로 해도되지만, 조금이라도 시간줄이기 위해 n까지
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[n]);
	}
}