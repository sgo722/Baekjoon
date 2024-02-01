import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{

    static int[][] arr;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc=1; tc<=t; tc++){
            ans = 0;
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr = new int[n][n+1];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=1; j<=n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i][j-1];
                }
            }

//            for(int i=0; i<n; i++){
//                int prev = 0;
//                for(int j=0; j<=n; j++){
//                    System.out.print(arr[i][j] + " ");
//                }
//                System.out.println();
//            }

            for(int j=0; j<=n-m; j++) {
                for(int r=0; r<=n-m; r++) {
                    int sum = 0;
                    for (int i = 0; i < m; i++) {
                        sum += arr[r + i][j + m] - arr[r + i][j];
                    }
                    ans = Math.max(ans,sum);
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}