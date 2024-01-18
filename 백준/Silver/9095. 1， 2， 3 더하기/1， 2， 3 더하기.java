import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 문제 시작 - 00:50
 * 아이디어 -
 * 1을 만들수 있는 방법 1 - 1가지
 * 2를 만들 수 있는 방법 11 , 2 - 2가지
 * 3을 만들 수 있는 방법 111, 12, 21, 3 - 4가지
 * dp를 이용하면 풀리는것같다.. 근데 왜지?
 */
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] dp = new int[15];
		
		dp[1] = 1;
		// 1,2,3을 가지고 1을 만들수 있는 경우
		dp[2] = 2;
		// 1,2,3을 가지고 2를 만들수 있는 경우
		dp[3] = 4;
		// 1,2,3 각 숫자를 가지고 3을 만들 수 있는 경우
		
		//dp[i] 는 i라는 숫자를 1,2,3으로 만들 수 있는 경우를 가진 수다.
		// 그러면 왜 여기서는 더해주는 것일까?
        // i-1에 1만 더해주면 i가 되고,
        // i-2에 2만 더해주면 i가 되고,
        // i-3에 3만 더해주면 i가 되기때문에
        // 내가 가진 수는 1,2,3이라는 수가 있는데 그런 케이스때 만들 수 있는 수의 조합이라해야하나... -> 확실하게 설명못하겠음.
		for(int i=4; i<=11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            
		}
		
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
		
	}
}