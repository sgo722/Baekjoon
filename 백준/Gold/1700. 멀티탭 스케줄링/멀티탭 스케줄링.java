
import java.io.*;
import java.util.*;

public class Main{

    static class Node{
        int num;
        int nextIdx;

        public Node(int num, int nextIdx) {
            this.num = num;
            this.nextIdx = nextIdx;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", nextIdx=" + nextIdx +
                    '}';
        }
    }
    static int n, k;
    static int[] list;
    static int[] next;

    static boolean[] now;

    public static void main(String[] args) throws Exception{
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o2.nextIdx - o1.nextIdx);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new int[k+1];
        next = new int[k+1];
        now = new boolean[k+1];
        HashMap<Integer, Integer> map = new HashMap<>();

        Arrays.fill(next,Integer.MAX_VALUE);

        for(int i=1; i<=k; i++){
            map.put(i,-1);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=k; i++){
            int num = Integer.parseInt(st.nextToken());
            list[i] = num;
            int idx = map.get(num);
            if(idx == -1){
                map.put(num, i);
                continue;
            }
            next[idx] = i;
            map.put(num,i);
            // map.get(숫자) = 숫자의 이전 인덱스
            // next[숫자의 이전 인덱스] = 현재 인덱스
        }
//        for(int i=1; i<=k; i++){
//            System.out.print(next[i] + " ");
//        }
//        System.out.println();
        int count = 0;
        ArrayList<Node> connection = new ArrayList<>();
        for(int i=1; i<=k; i++){

            Node change = null;
            if(connection.size() < n){
                if(now[list[i]]){
                    for(Node removeNode : connection){
                        if(list[i] == removeNode.num){
                            change = removeNode;
                        }
                    }
                    connection.remove(change);
                }
                connection.add(new Node(list[i],next[i]));
                now[list[i]] = true;
                continue;
            }
            int maxNext = 0;

            boolean flag = false;
            for(int j=0; j<n; j++){
                Node node = connection.get(j);
                if(list[i] == node.num){
                    change = node;
                    flag = true;
                    break;
                }
                int nodeNext = node.nextIdx;
                if(maxNext < nodeNext){
                    change = node;
                    maxNext = nodeNext;
                }
            }
            if(!flag){
                count++;
            }
            connection.remove(change);
            connection.add(new Node(list[i], next[i]));
        }
        System.out.println(count);

//        while(pq.size() > 0){
//            System.out.println(pq.poll());
//        }


    }
}