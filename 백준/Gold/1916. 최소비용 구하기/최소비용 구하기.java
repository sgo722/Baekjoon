import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

    static class Node{
        int v;
        int value;

        public Node(int v, int value){
            this.v = v;
            this.value = value;
        }
    }

    static ArrayList<ArrayList<Node>> arr = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<=n; i++){
            arr.add(new ArrayList<>());
        }

        dist = new int[n+1];
        visited = new boolean[n+1];


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.get(a).add(new Node(b,c));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        dijkstra(a);

        System.out.println(dist[b]);
    }

    static void dijkstra(int start){

        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> o1.value - o2.value);
        pq.add(new Node(start,0));
        dist[start] = 0;

        while(pq.size() > 0){
            Node now = pq.poll();
            if(!visited[now.v]) {
                visited[now.v] = true;
                for (Node next : arr.get(now.v)) {
                    if (dist[next.v] > dist[now.v] + next.value) {
                        dist[next.v] = dist[now.v] + next.value;
                        pq.add(new Node(next.v, dist[next.v]));
                    }
                }
            }
        }
    }
}