import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        dp[0] = 2;
        for(int i=1; i<=n; i++){
            dp[i] = dp[i-1] * 2 - 1;
        }

        System.out.println(dp[n]*dp[n]);
    }
}