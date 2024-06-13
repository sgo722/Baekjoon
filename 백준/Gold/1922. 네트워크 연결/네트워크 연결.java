import java.io.*;
import java.util.*;

public class Main{
    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", cost=" + cost +
                    '}';
        }
    }

    static int[] root;
    static int n,m;
    static ArrayList<Edge> edges;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        edges = new ArrayList<>();
        root = new int[n+1];


        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from,to,cost));
        }

        Collections.sort(edges);
        // 초기화
        init();

        int sum = 0;
        for(Edge edge : edges){
            int from = edge.from;
            int to = edge.to;

            if(find(from) != find(to)){
                union(from,to);
                sum += edge.cost;
            }
        }

        System.out.println(sum);

    }

    static void init(){
        for(int i=1; i<=n; i++){
            root[i] = i;
        }
    }

    static int find(int idx){
        if(root[idx] == idx){
            return idx;
        }
        return find(root[idx]);
    }

    static void union(int a, int b){
        root[find(a)] = find(b);
    }
}