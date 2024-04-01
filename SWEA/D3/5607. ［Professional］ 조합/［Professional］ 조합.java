import java.io.*;
import java.util.*;
 
 
public class Solution{
    static final int MOD = 1234567891;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long tc = Integer.parseInt(br.readLine());
        long[] arr = new long[1000001];
        arr[0] = 1;
        for(int i=1; i<=1000000; i++) {
            arr[i] = (i * arr[i-1]) % MOD;
        }
         
        for(int t=1; t<=tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
             
            long aFactorial = arr[n];
            long bFactorial = arr[(int) (n-r)] * arr[r] % MOD;
            System.out.println("#" + t + " " + aFactorial* go(bFactorial, 1234567889)%MOD);
        }
    }
     
    static long go(long a, long num) {
        if(num <= 1){
            return a % MOD;
        }
        long ret = go(a, num/2) % MOD;
        if(num % 2 == 1) {
            return (((ret * ret) % MOD) * a) % MOD;
        }else {
            return (ret * ret) % MOD;
        }
         
    }
}