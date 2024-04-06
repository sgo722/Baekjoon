import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * LIS 문제같다.
 */
public class Main{
    static int[] arr;
    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++){
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a] = b;
            }

            int x = arr[1];
            ans = 1;
            for(int i=2; i<=n; i++){
                if(arr[i] < x){
                    x = arr[i];
                    ans++;
                }
            }

            System.out.println(ans);
        }
    }
}