import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer> students = new ArrayList<>();
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            students.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=1; i<=n; i++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j=i; j>=1; j--){
                max = Math.max(max,students.get(j-1));
                min = Math.min(min,students.get(j-1));
                dp[i] = Math.max(dp[i], max-min+dp[j-1]);
            }
        }

        System.out.println(dp[n]);
    }
}