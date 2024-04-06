import java.io.*;
import java.util.*;

public class Main{
    static class Edge implements Comparable<Edge>{
        int s;
        int e;
        int value;

        public Edge(int s, int e, int value){
            this.s = s;
            this.e = e;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o){
            return this.value - o.value;
        }
    }

    static int v,e, ans;
    static int[] vertex;

    static int[] root;

    static PriorityQueue<Edge> edges;
    public static void main(String[] args) throws Exception{
        input();
        solution();
    }

    static void solution(){
        init();
        while(edges.size() > 0){
            Edge now = edges.poll();
            int s = now.s;
            int e = now.e;
            int value = now.value;
            if(union(s,e)) {
                ans += value;
            }
        }

        System.out.println(ans);

    }

    static void init(){
        for(int i=0; i<=v; i++) {
            root[i] = i;
        }
    }

    static int find(int idx){
        if(root[idx] == idx) return idx;
        return root[idx] = find(root[idx]);
    }

    static boolean union(int a, int b){
        if(find(a) == find(b)) return false;
        root[find(a)] = find(b);
        return true;
    }

    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine(), " ");
        edges = new PriorityQueue<>();
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        vertex = new int[v+1];
        root = new int[v+1];

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges.add(new Edge(s, e, value));
        }
    }
}