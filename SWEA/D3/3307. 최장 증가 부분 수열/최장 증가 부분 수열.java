import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
    static int[] arr, lis;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i=1; i<=t; i++){
            int ans = 0;
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            lis = new int[n+1];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }


            for(int idx=1; idx<=n; idx++){
                lis[idx] = 1;
                for(int j=1; j<idx; j++){
                    // 현재 값이 더 큰 경우에는 lis  + 1
                    if(arr[idx] > arr[j] && lis[idx] < lis[j] + 1){
                        lis[idx] = lis[j] + 1;
                    }
                }
                ans = Math.max(ans, lis[idx]);
            }

            System.out.println("#"+i + " " + ans);
        }

    }
}