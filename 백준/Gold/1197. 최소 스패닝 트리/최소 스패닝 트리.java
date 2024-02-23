import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main{

    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight){
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int[] parents;


    static PriorityQueue<Edge> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();

        makeSet(v);
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.add(new Edge(from, to ,weight));
        }

        // 최소 스패닝 트리의 가중치를 구하라?
        long ans = 0;
        while(!pq.isEmpty()){
            Edge poll = pq.poll();
            if(union(poll.from, poll.to)){
                ans += poll.weight;
            }
        }

        System.out.println(ans);
    }

    static void makeSet(int size){
        parents = new int[size+1];
        for(int i=1; i<=size; i++){
            parents[i] = i;
        }
    }

    static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static boolean union(int from, int to){
        if(find(from) == find(to)) return false;
        parents[find(from)] = find(to);
        return true;
    }
}