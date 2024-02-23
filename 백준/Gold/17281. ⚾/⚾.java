import java.io.*;
import java.util.*;

public class Main{
    static int[][] jumsu;
    static int[] base;
    static int[] player, visited;

    static int n, ans;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        jumsu = new int[10][n];
        player = new int[10];
        visited = new int[10];
        base = new int[5];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=9; j++){
                jumsu[j][i] = Integer.parseInt(st.nextToken()); // j번쨰 선수가 i번째 이닝에서 낼 수 있는 성적
            }
        }

        visited[1] = 1;
        player[3] = 1;
        ans = -1;
        // 각 선수들의 타순을 정한다. (순열)
        for(int i=2; i<=9; i++){
            visited[i] = 1;
            player[0] = i;
            go(1);
            visited[i] = 0;
        }

        System.out.println(ans);

    }

    static void go(int idx){
        if(idx == 9){ // 게임을 진행한다.
//            for(int i=0; i<9; i++){
//                System.out.print(player[i] + " ");
//            }
//            System.out.println();

            // 게임을 시작합니다.
            ans = Math.max(ans, playGame());
//            System.out.println(ans);
            return;
        }
        if(idx == 3){
            go(idx+1);
            return;
        }

        for(int i=2; i<=9; i++){
            if(visited[i] == 1) continue;
            visited[i] = 1;
            player[idx] = i;
            go(idx+1);
            visited[i] = 0;
        }
    }

    // 가장 많은 득점을 할 수 있는 경우의 득점을 출력하라.

    static int playGame(){
        int ret = 0;
        int ining = 0;
        int taza = 0;
        int out = 0;
        for(int i=0; i<=4; i++){
            base[i] = 0;
        }
        while(ining != n){
            out = 0;
            for(int i=0; i<=3; i++){
                base[i] = 0;
            }
            while(true){
//                System.out.println("taza : " + taza + " player[" + taza + "] : " + player[taza]);
                if(jumsu[player[taza]][ining] == 0){
                    out++;
                    taza = (taza + 1) % 9;
                    if(out == 3){
                        break;
                    }
                    continue;
                }

                // 1루타를 치고, 홈런을 쳤다? 2점이 들어간다.
                // 1루타를 치고, 2루타를 쳤다? 2루와 3루에 있다.

                for(int i=3; i>=1; i--){
                    if(base[i] != 0){
                        base[i] = 0;
                        if(i+jumsu[player[taza]][ining] >= 4){
                            base[4]++;
                        }else {
                            base[i + jumsu[player[taza]][ining]]++;
                        }
                    }
                }
                base[jumsu[player[taza]][ining]]++;

//                for(int i=1; i<=4; i++){
//                    System.out.print(base[i] + " ");
//                }
//                System.out.println();


                taza = (taza+1) % 9;
            }
            ining++;
//            System.out.println(ining);
        }
        ret += base[4];

        return ret;
    }

}