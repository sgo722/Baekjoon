import java.io.*;
import java.util.*;

public class Main{

    static int n,m;
    static int[] sum,arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+2];
        sum = new int[n+2];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            sum[a] += k;
            sum[b+1]-= k;
        }

        for(int i=1; i<=n; i++){
            sum[i] += sum[i-1];
        }

        for(int i=1; i<=n; i++){
            arr[i] = arr[i] + sum[i];
            System.out.print(arr[i] + " ");
        }


    }
}