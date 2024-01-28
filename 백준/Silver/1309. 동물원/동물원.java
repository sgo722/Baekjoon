import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 * 문제 : 동물원
 * 시작 - 17:05
 * 문제 이해)
 * 세로의 길이 n을 입력받고, 2xn 배열에 사자들가 배치되는 경우의 수를 구한다
 * 사자가 없는 경우도 하나의 경우로 간주할 수 있다.
 * N의 범위가 10만이고, 경우의 수를 9901로 나눈 결과값을 출력하라는 것을 보니
 * dp와 mod연산을 사용해야할 것 같다.
 * 아이디어)
 * dp를 생각하고 접근해보면
 * n이 1인 경우는 2x1에 비어있는 경우(1가지) + 1마리만 채워지는 경우(2가지) = 3가지 경우의 수가 존재할 수 있다.
 * 1 + 2 = 3
 * n이 2인 경우는 2x2에 비어있는 경우(1가지) + 1마리만 채워지는 경우(4가지) + 2마리가 채워지는 경우(2가지) = 7가지의 경우의 수
 * 1 + 4 + 2 = 7
 * n이 3인 경우는 어떻게 될까
 * 2x3에 비어있는 경우 비어있는 경우(1가지) + 1마리만 채워지는 경우(2x3가지) + 2마리가 채워지는 경우(맨 위에서 1마리가 채워지는 경우에 각 3가지 경우 존재) + 3마리가 채워지는 경우(2가지)
 * 1 + 6 + 6 + 2 = 15
 * 빈칸인경우, 왼쪽인 경우 == 오른쪽인 경우
 * 
 * 3*3을 2by2로 채우는 방법은 3x3을 다 이용하고 2x2를 이용하는 경우
 * 3 3를 2x2로 채우는 경우 6가지 
 * 2가지
 * 
 * 
 * 
 * 그냥 점화식은 구한것같은데 왜 그런건지 모르겠다. 
 * 1번째 , 2번째 구하고
 * 3~n번째는 (n-1) * 2 + (n-2)
 * 이렇게 짜면 풀리긴할듯?
 * 틀려서 답봄 -> 2차원 배열로 3가지로 나눠야하나 생각만하고, 감이 안잡혀서 안했는데 그게 맞았네
 * 19:09 답봄
 */


public class Main {
	static final int MOD = 9901;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][3];
		
		dp[1][0] = dp[1][1] = dp[1][2] = 1;
		
		for(int i=2; i<=n; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
			
		}
		
		
		int ans = (dp[n][0] + dp[n][1] + dp[n][2]) % MOD;
		System.out.println(ans);
	}
}