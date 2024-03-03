
import java.io.*;
import java.util.*;

public class Solution{


    static int[] dy = {0,-1,0,1,0};
    static int[] dx = {0,0,1,0,-1};

    static class Point{
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public void move(int dir){
            this.y += dy[dir];
            this.x += dx[dir];
        }
    }

    static class Node{
        int y;
        int x;
        int c;
        int p;

        public Node(int y, int x, int c, int p) {
            this.y = y;
            this.x = x;
            this.c = c;
            this.p = p;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    ", c=" + c +
                    ", p=" + p +
                    '}';
        }
    }


    static BufferedReader br;
    static StringTokenizer st;
    static int M,A, tc;
    static int[][] step;

    static Point p1,p2;

    static ArrayList<Node> charges;


    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(tc=1; tc<=t; tc++) {
            input();
//            debugStep();
//            debugChargeSpot();
            // 무선충전기가 적용되는 영역 확인하기
            // 맨해튼 거리로, 영역 안에 들어오는 것을 나열한다음에
            // 카르테시안 곱을 통해서 확인한다.
            goStep(0,0); // 다음 스탭으로 이동한다.
            // 이동하기

            // 이동 동선대로 이동하기
            // - 같은 충전스팟이면?
            // - 다른 충전스팟이면?

            // 이렇게 끝까지 도달하는 경우를 계산하기
        }
    }

    static void goStep(int idx, int sum){
        if(idx == M+1){ // 두명 다 마지막까지 이동했을 때
            System.out.println("#" + tc + " " + sum);
            return;
        }


        p1.move(step[0][idx]);
        p2.move(step[1][idx]);

        // 어떤 충전스팟을 이용할지에 대해서 고려해야한다.
        PriorityQueue<Node> pq1 = findSpot(p1.y,p1.x); // 1번이 사용할 수 있는 스팟
        PriorityQueue<Node> pq2 = findSpot(p2.y,p2.x); // 2번이 사용할 수 있는 스팟

//        for(Node it : pq1){
//            System.out.println(it);
//        }
//
//        for(Node it : pq2){
//            System.out.println(it);
//        }

//        System.out.println();

        if(!pq1.isEmpty() && pq2.isEmpty()){
            sum += pq1.poll().p;
        }else if(pq1.isEmpty() && !pq2.isEmpty()){
            sum += pq2.poll().p;
        }else if(!pq1.isEmpty() && !pq2.isEmpty()){
            Node pq1Top = pq1.poll();
            Node pq2Top = pq2.poll();
            if(pq1Top == pq2Top){
                sum += pq1Top.p;
                if(!pq1.isEmpty() && pq2.isEmpty()){
                    sum += pq1.poll().p;
                }else if(pq1.isEmpty() && !pq2.isEmpty()){
                    sum += pq2.poll().p;
                }else if(!pq1.isEmpty() && !pq2.isEmpty()){
                    Node pq1Second = pq1.poll();
                    Node pq2Second = pq2.poll();
                    if(pq1Second == pq2Second) {
                        sum += pq1Second.p;
                    }else if(pq1Second.p > pq2Second.p){
                        sum += pq1Second.p;
                    }else{
                        sum += pq2Second.p;
                    }
                }
            }else{
                sum = sum + pq1Top.p + pq2Top.p;
            }
        }
        goStep(idx+1, sum);
    }

    static PriorityQueue<Node> findSpot(int y, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.p-o1.p);

        for(int i=0; i<charges.size(); i++){
            int dist = Math.abs(y-charges.get(i).y) + Math.abs(x-charges.get(i).x);
            if(dist <= charges.get(i).c){
                pq.add(charges.get(i));
            }
        }

        return pq;
    }



    static void input() throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        step = new int[2][M+1];
        charges = new ArrayList<>();

        for(int i=0; i<2; i++) { // 이동 동선 입력
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                step[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<A; i++){ // 충전기 입력
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            charges.add(new Node(x,y,c,p));
        }

        p1 = new Point(0,0);
        p2 = new Point(9,9);
    }


    static void debugChargeSpot(){
        for(Node it : charges){
            System.out.println(it);
        }
    }

    static void debugStep(){
        for(int i=0; i<2; i++){
            for(int it : step[i]){
                System.out.print(it + " ");
            }
            System.out.println();

        }
    }


}