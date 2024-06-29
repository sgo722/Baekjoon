import java.io.*;
import java.util.*;


public class Main{

    static class Node{
        int number;
        int save;
        int time;

        public Node(int number, int save, int time) {
            this.number = number;
            this.save = save;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "number=" + number +
                    ", save=" + save +
                    ", time=" + time +
                    '}';
        }
    }
    static int n;
    static int t[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        t = new int[n+1][n+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                t[i][j] = Integer.MAX_VALUE;
            }
        }
        int count = bfs();

        System.out.println(count);
    }

    static int bfs(){

        Queue<Node> q = new LinkedList<>();

        q.add(new Node(1,0, 0));

        while(!q.isEmpty()) {
            Node now = q.poll();
            int number = now.number;
            int save = now.save;
            int time = now.time;
            if (t[save][number] <= time) continue;
            if (number == n) {
                return time;
            }
            t[save][number] = time;

            if (save > 0 && save + number < n+1) {
                q.add(new Node(number + save, save, time + 1));
            }
            if (number >= 1) {
                q.add(new Node(number - 1, save, time + 1));
            }
            if (number > 0) {
                q.add(new Node(number, number, time + 1));
            }
        }
        return -1;
    }
}