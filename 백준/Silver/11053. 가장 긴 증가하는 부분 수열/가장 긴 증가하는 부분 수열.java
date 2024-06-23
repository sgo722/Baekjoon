import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[] arr, lis;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        lis = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            lis[i] = 1;
        }


        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[j] > arr[i]) {
                    lis[j] = Math.max(lis[j], lis[i]+1);
                }
            }
        }

        int ans = 0;
        for(int it : lis){
            ans = Math.max(ans, it);
        }

        System.out.println(ans);

    }
}