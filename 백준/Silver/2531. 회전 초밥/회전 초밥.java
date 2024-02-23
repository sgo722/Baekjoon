import java.io.*;
import java.util.*;


/**
 * 문제 - 회전초밥
 */
public class Main{

    static int[] arr;
    static int[] visited;
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new int[N + k];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=N; i<N+k; i++){
            arr[i] = arr[i-N];
        }

        for(int i=0; i<N; i++){
            boolean flag = true;
            int ret = 0;
            visited = new int[d+1];
            for(int j=i; j<i+k; j++){
                if(visited[arr[j]] == 0){
                    visited[arr[j]] = 1;
                    if(arr[j] == c){
                        flag = false;
                    }
                    ret++;
                }
            }
            if(flag) ret++;

//            if(ans < ret){
//                ans = ret;
//            System.out.println(arr[i] + " " + ret);
//            }
            ans = Math.max(ret, ans);
        }

        System.out.println(ans);
    }
}