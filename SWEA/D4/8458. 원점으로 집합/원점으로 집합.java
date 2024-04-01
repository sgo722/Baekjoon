import java.io.*;
import java.util.*;
 
public class Solution{
     
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] dist = new int[n];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int absR = Math.abs(Integer.parseInt(st.nextToken()));
                int absC = Math.abs(Integer.parseInt(st.nextToken()));
                dist[i] = absR + absC;
            }
             
            int max = 0;
            for(int i=0; i<n; i++) {
                if(i >= 1 && dist[i] % 2 != dist[i-1] % 2) {
                     
                    max = -1;
                    break;
                }else {
                    max = Math.max(max, dist[i]);
                }
            }
             
            int idx = 0;
             
            if(max != -1) {
                long sum = 0;
                while(true) {
                    sum += idx;
                    if(max <= sum && (sum-max) % 2 == 0) {
                        break;
                    }
                    idx++;
                }
            }else {
                idx = -1;
            }
             
            System.out.println("#"+tc+ " " + idx);
        }
    }
}