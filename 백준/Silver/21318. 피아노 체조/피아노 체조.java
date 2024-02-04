import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 -
 * 현재 실수 횟수 = 전 실수 + 1 or 전 실수
 * 라는 dp배열을 해결할 수 있을 것 같다.
 */

public class Main {
    static int[] arr, dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        arr = new int[n+1];
        dp = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=2; i<=n; i++){
            if(arr[i] < arr[i-1]) dp[i] = dp[i-1] + 1;
            else if(arr[i] >= arr[i]) dp[i] = dp[i-1];
        }

        int q = Integer.parseInt(br.readLine());

        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dp[b] - dp[a]).append("\n");
        }

        System.out.println(sb);
    }
}