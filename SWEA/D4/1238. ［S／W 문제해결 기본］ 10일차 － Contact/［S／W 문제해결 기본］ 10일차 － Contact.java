import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{

    static ArrayList<Integer> arr[];
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new ArrayList[101];


        for(int tc=1; tc<=10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            visited = new int[101];
            
            for (int i = 0; i < 101; i++) {
                arr[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                arr[from].add(to);
            }

            System.out.println("#" + tc + " " + bfs(m));
        }

    }

    static int bfs(int m){
        Queue<Integer> q = new LinkedList<>();
        q.add(m);
        visited[m] = 1;
        int ret = Integer.MIN_VALUE;
        while(q.size() > 0){
            ret = Integer.MIN_VALUE;
            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                int front = q.poll();
                ret = Math.max(ret, front);
                for(int it : arr[front]){
                    if(visited[it] == 0){
                        visited[it] = 1;
                        q.add(it);
                    }
                }
            }
        }
        return ret;
    }
}