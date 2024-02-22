import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제 : 게리맨더링
 *
 */
public class Main{

    static int[] person, area;
    static ArrayList<Integer>[] nodes;

    static int n, m, ans;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ans = Integer.MAX_VALUE;
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        nodes = new ArrayList[n+1];
        area = new int[n+1];
        person = new int[n+1];
        for(int i=0; i<=n; i++){
            nodes[i] = new ArrayList<>();
        }

        for(int i=1; i<=n; i++){
            person[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            for(int j=0; j<m; j++){
                nodes[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        dfs(1); // 1번부터 n번까지 탐색한다.

        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }


    static void dfs(int idx){
        if(idx == n+1){

            int area1 = 0;
            int area2 = 0;
            for(int i=1; i<=n; i++){
                if(area[i] == 1) area1 += person[i];
                else area2 += person[i];
            }

            // 같이 붙어있는지 확인해야한다.
            visited = new boolean[n+1];
            int link = 0;
            for(int i=1; i<=n; i++){
                if(!visited[i]){
                    bfs(i,area[i]);
                    link++;
                }
            }
            if(link == 2) {
                ans = Math.min(ans, Math.abs(area1 - area2));
            }
            return;
        }

        area[idx] = 1;
        dfs(idx+1);
        area[idx] = 2;
        dfs(idx+1);
    }

    static void bfs(int idx, int flag){
        Queue<Integer> q = new LinkedList<>();

        q.add(idx);
        visited[idx] = true;

        while(q.size() > 0){
            int now = q.poll();
            for(int next : nodes[now]){
                if(!visited[next] && area[next] == flag){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}