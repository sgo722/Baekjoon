import java.io.*;
import java.util.*;

public class Main{

    static int n,k,cnt;
    static long t, ans;
    static int[] visited;
    static long[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new long[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        Stack<Long> stk = new Stack<>();

        for(int i=0; i<n && k>0; i++){
            while(t <= arr[i] && k > 0){
                if(stk.size() == 0){
                    System.out.println(t);
                    return;
                }
                else if(stk.size() > 0) {
                    t += stk.pop();
                    k--;
                }
            }
            stk.push(arr[i]);
        }

        while(stk.size() > 0 && k > 0) {
            t += stk.pop();
            k--;
        }

        System.out.println(t);
    }
}