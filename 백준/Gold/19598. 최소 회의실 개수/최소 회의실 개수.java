import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static class Node{
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        ArrayList<Node> list = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.end - o2.end);

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end));
        }

        Collections.sort(list, (o1, o2) -> o1.start - o2.start);


        pq.add(list.get(0));
        for(int i=1; i<list.size(); i++){
            Node node = list.get(i);
            int start = node.start;

            if(pq.peek().end <= start){
                pq.poll();
            }
            pq.add(node);
        }

        System.out.println(pq.size());
    }
}