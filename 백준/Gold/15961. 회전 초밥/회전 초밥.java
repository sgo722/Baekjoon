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
        visited = new int[d+1];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=N; i<N+k; i++){
            arr[i] = arr[i-N];
        }


        boolean flag = true;
        int ret = 0;
        for(int i=0; i<k; i++) {
            if(visited[arr[i]] == 0) {
                ret++;
            }
            visited[arr[i]]++;
            if(visited[c] == 0){
                ans = Math.max(ret+1,ans);
            }
            else {
                ans = Math.max(ret, ans);
            }
        }

        int l = 0;
        int r = k-1;
        while(true){
            visited[arr[l]]--;
            if(visited[arr[l]] == 0){
                ret--;
            }
            l++;
            r++;
            if(r == N+k) break;
            if(visited[arr[r]] == 0) {
                ret++;
            }
            visited[arr[r]]++;

            if(visited[c] == 0){
                ans = Math.max(ret+1,ans);
            }
            else {
                ans = Math.max(ret, ans);
            }
        }

        System.out.println(ans);
    }
}