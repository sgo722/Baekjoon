
import java.io.*;
import java.util.*;

/**
 * 문제 - 톱니바퀴
 * 톱니의 극이 다르다면 회전방향 반대로 회전한다.
 * 극이 같으면 회전하지 않는다.
 *
 * 톱니바퀴의 상황을 저장
 * n번째 톱니바퀴의 3시 와 n+1번쨰 톱니바퀴 9시 상황 비교
 * 같다면 n번 톱니바퀴만 회전
 * 다르다면{
 *  n번째 톱니바퀴 회전하고
 * }
 *
 * n번째 톱니바퀴의 9시 와 n-1번째 톱니바퀴 3시 상황 비교
 *
 * n번 - (n-1 호출, n+1호출)
 * 유형은 재귀, 시뮬레이션?
 */
public class Main{

    static class Order{
        int idx;
        int turn;

        public Order(int idx, int turn){
            this.idx = idx;
            this.turn = turn;
        }
    }

    static class Node{
        int idx;

        int start;

        ArrayList<Integer> state;

        public Node(int idx, int start){
            this.idx = idx;
            this.start = start;
            state = new ArrayList<>();
        }

        int getLeft() {
            return (this.start + 6) % 8;
        }

        int getRight() {
            return (this.start + 2) % 8;
        }

        public void playTurn(int dir){
            if(dir == -1) { // 반시계방향 회전
                this.start = (this.start+1)%8;
            }else if(dir == 1){ // 시계 방향 회전
                this.start = (this.start+8-1)%8;
            }
        }
    }

    static BufferedReader br;
    static StringTokenizer st;

    static ArrayList<Order> orders;
    static ArrayList<Node> tobs;

    static int n;

    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        input();
//        debug();
        turn();
    }


    static void turn(){

        for(int i=0; i<n; i++){
            visited = new boolean[4];
            int idx = orders.get(i).idx;
            int dir = orders.get(i).turn;
            turning(idx, dir);
//            debug();
        }
        System.out.println(calScore());
    }

    static int calScore(){
        int score = 0;
        for(int idx=0; idx<4; idx++) {
            if(tobs.get(idx).state.get(tobs.get(idx).start) == 1){
                score |= (1<<idx);
            }
        }
        return score;
    }

    static void turning(int idx, int dir){
//      System.out.println(idx + " " + dir);
        Node tob = tobs.get(idx);
        visited[idx] = true;
        if(dir == 1){ // 현재 시계방향회전
          if(idx+1 < 4 && !visited[idx+1] &&
                  tob.state.get(tob.getRight()) != tobs.get(idx+1).state.get(tobs.get(idx+1).getLeft())){
//              System.out.println(tob.state.get(tob.getRight()) + " " + tobs.get(idx+1).state.get(tobs.get(idx+1).getLeft()));
                turning(idx+1, -1);
          }
          if(idx - 1 >= 0 && !visited[idx-1] &&
                  tobs.get(idx-1).state.get(tobs.get(idx-1).getRight()) != tob.state.get(tob.getLeft())) {
              turning(idx - 1, -1);
          }
//          System.out.println((idx+1)+ "번쨰 " + "시계방향 회전합니다");
        } else if(dir == -1){ // 현재 반시계회전
            if(idx+1 < 4 && !visited[idx+1] &&
                    tob.state.get(tob.getRight()) != tobs.get(idx+1).state.get(tobs.get(idx+1).getLeft())){
                turning(idx+1, 1);
            }
            if(idx - 1 >= 0 && !visited[idx-1] &&
                    tobs.get(idx-1).state.get(tobs.get(idx-1).getRight()) != tob.state.get(tob.getLeft())) {
                turning(idx-1, 1);
            }
//            System.out.println((idx+1)+ "번쨰 " + "반시계방향 회전합니다");
        }
        tob.playTurn(dir);

    }


//    static void debug(){
//        for(int i=0; i<4; i++) {
//            System.out.print(tobs.get(i).state.get(tobs.get(i).start) + " ");
//            int cnt = 0;
//            for(int j = tobs.get(i).start; cnt != 8; j = (j+1)%8) {
//                cnt++;
//                System.out.print(tobs.get(i).state.get(j) + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//    }

    static void input() throws IOException{


        tobs = new ArrayList<>();
        br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<4; i++){
            tobs.add(new Node(i, 0));
            String s = br.readLine();
            for(int j=0; j<8; j++) {
                tobs.get(i).state.add(s.charAt(j) - '0');
            }
        }
        n = Integer.parseInt(br.readLine());
        orders = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken())-1;
            int turn = Integer.parseInt(st.nextToken());

            orders.add(new Order(idx, turn));
        }
    }
}