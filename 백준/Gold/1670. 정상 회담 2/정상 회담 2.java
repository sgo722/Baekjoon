import java.io.*;
import java.util.*;

/**
 * 문제 - 정상 회담2
 * dp를 이용하여 문제를 해결 할 수 있을 것 같다.
 * 2명이서 인사를 하는 경우는 1가지
 * 4명이서 인사를 하는 경우는 2가지 2명인사 * 2
 * 6명이서 인사를 하는 경우 = 4명 인사 * 2 + 2명 인사 * 2명인사 = (dp[4] * 2) + (dp[2] * dp[2])
 * 8명이서 인사를 하는 경우는?  8명인사 = 6명 인사 * 2 + 4명 * 2명 인사 * 2 = dp[6] * 2 + dp[4] * 2;
 * 10명이서 인사를 하는 경우는? 10명 인사 = (8명 * 2) + (6명 * 2명* 2) + (4명 *2)
 * 12명 인사하는 경우? 12명 인사 = 10명 * 2 + 8명인사 * 2명인사 * 2 + 6명 *4명 * 2
 *
 * i/2 가 짝수인 경우 = 나를 제외하면 홀수개그룹이 나올 수 잇다는 말이므로,
 * i/2 가 홀수인 경우 = 나를 제외하면 짝수개 그룹이 나올 수 있다는 말이므로,
 * dp[i] = dp[i-2] * 2 + dp[i-4] *
 * = 8명인사 * 2 + 6명인사 * 3 = 8명인사 * 3가 된다. 뭐지 일단 점화식은 나오긴했는데 뭐어쩌라고 이게 왜이렇게 되는건데..
 *
 */
public class Main {

    static long[] dp = new long[10004];
    static final long MOD = 987654321;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp[2] = 1;
        dp[4] = 2;
        dp[6] = 5;
        for(int i=8; i<=10000; i+=2){
            if(i % 4 == 0) {
                dp[i] = (dp[i-2] % MOD * 2 % MOD);
                for(int j=2; j<= i-2; j+=2){
                    dp[i] = dp[i] % MOD + (dp[j] * dp[i-2-j] % MOD) % MOD;
                }
            }else{
                dp[i] += (dp[i-2] * 2 % MOD) % MOD;
                for(int j=2; j<= i-2; j+=2) dp[i] = dp[i] % MOD + (dp[j] % MOD * dp[i-2-j] % MOD) % MOD;
            }

//            System.out.println(i-8 + " 일 때 : " + dp[i-8]);
//            if(i == 90) break;
        }

        System.out.println(dp[n]);
    }
}