import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] v;
    static int ans, n;
    static int max_num = Integer.MAX_VALUE;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        v = new ArrayList[n+1];
        visited = new int[n+1];
        for(int i=0; i<=n; i++){
            v[i] = new ArrayList<>();
        }


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            v[a].add(b);
            v[b].add(a);
        }

        for(int i=1; i<=n; i++){
            visitedClear();
            int count = bfs(i);

//            System.out.println(count);
            if(count < max_num){
                max_num = count;
                ans = i;

//                System.out.println(i + " " + count);
            }
        }

        System.out.println(ans);
    }

    static int bfs(int here){
        Queue<Integer> q = new LinkedList<>();
        q.add(here);
        visited[here] = 1;
        int count = 0;
        while(q.size() > 0){
            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                int hereA = q.poll();
                for(int j=0; j<v[hereA].size(); j++) {
                    if (visited[v[hereA].get(j)] == 0) {
                        visited[v[hereA].get(j)] = visited[hereA] + 1;
                        q.add(v[hereA].get(j));
                    }
                }
            }
        }

        for(int i=1; i<=n; i++){
            count += visited[i];
        }
        return count;

    }

    static void visitedClear(){
        for(int i=1; i<=n; i++){
            visited[i] = 0;
        }
    }
}
