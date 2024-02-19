import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제 : Coins
 * 문제이해)
 * t개의 테스트케이스가 주어지고, n개의 동전이 주어진다.
 * m원을 만들 수 있는 경우의 수를 구하라.
 *
 */
public class Main{

    static int[] arr;

    static int start, end, n;

    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        visited = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        if(start == end){
            System.out.println(0);
            return;
        }

        System.out.println(bfs());
    }

    static int bfs(){
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        visited[start] = 1;
        q.add(start);
        while(q.size() > 0){
            int qSize = q.size();
            for(int j=0; j<qSize; j++) {
                Integer now = q.poll();
                if ((end-now) % arr[now] == 0) return cnt;
                for (int next = now; next <= n; next += arr[now]) {
                    if (visited[next] == 1) continue;
//                    System.out.print(next + " ");
                    visited[next] = 1;
                    q.add(next);
                }

                for (int next = now; next > 0; next -= arr[now]) {
                    if (visited[next] == 1) continue;
//                    System.out.print(next + " ");
                    visited[next] = 1;
                    q.add(next);
                }
            }
            cnt++;
        }

        return -1;
    }
}