import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int n, ans;
    static int[][] arr;
    static int[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new int[n];
        ans = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<n; i++){
            if(arr[0][i] == 0) continue;
            visited[i] = 1;
            go(i,1,arr[0][i]);
            visited[i] = 0;
        }

        System.out.println(ans);
    }

    static void go(int here, int count, int value){
        if(count == n-1){
            if(arr[here][0] == 0) return;
            value += arr[here][0];
            ans = Math.min(ans, value);
            return;
        }

//        System.out.println(here + " " + count + " " + value);
        for(int i=1; i<n; i++){
            if(visited[i] == 1 || arr[here][i] == 0) continue;
            visited[i] = 1;
            go(i,count+1, value+arr[here][i]);
            visited[i] = 0;
        }
    }

}