import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

    static int[] dp;
    static ArrayList<Integer> arr;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            arr = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(br.readLine());
            dp = new int[m+1];
            for(int j=0; j<n; j++) {
                int num = Integer.parseInt(st.nextToken());
                dp[num]++;
                for (int k = num; k <= m; k++) {
                    dp[k] = dp[k] + dp[k - num];
                }
            }
            sb.append(dp[m]).append("\n");
        }
        System.out.println(sb);
    }
}