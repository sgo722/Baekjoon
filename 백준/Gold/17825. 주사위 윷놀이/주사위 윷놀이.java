
import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] v;
    static int[] mal, jumsu, game;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = new ArrayList[33];
        jumsu = new int[33]; // 맵에 점수를 부여할 점수배열
        game = new int[10]; // 주사위 배열
        mal = new int[4]; // 말의 현재 위치를 저장할 배열

        // 2차원 배열 초기화
        for (int i = 0; i < 33; i++) {
            v[i] = new ArrayList<>();
        }

        // 맵그리기
        makeMap();

        // 맵 번호판 부여하기
        mapGetJumsu();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 10; i++) {
            game[i] = Integer.parseInt(st.nextToken());
        }

        // 주사위 재귀 메서드
        go(0,0);

        System.out.println(ans);
    }

    static void makeMap() {// 다음 방향 정의
        for (int i = 0; i < 20; i++) {
            v[i].add(i + 1);
        }

        v[5].add(21);
        v[21].add(22);
        v[22].add(23);
        v[23].add(24);
        v[24].add(25);
        v[25].add(26);
        v[26].add(20);

        v[10].add(27);
        v[27].add(28);
        v[28].add(24);

        v[15].add(29);
        v[29].add(30);
        v[30].add(31);
        v[31].add(24);

        v[20].add(32);
    }

    // 점수를 부여한다.
    static void mapGetJumsu() {
        for (int i = 0; i <= 20; i++) {
            jumsu[i] = i * 2;
        }

        jumsu[21] = 13;
        jumsu[22] = 16;
        jumsu[23] = 19;
        jumsu[24] = 25;
        jumsu[25] = 30;
        jumsu[26] = 35;
        jumsu[27] = 22;
        jumsu[28] = 24;
        jumsu[29] = 28;
        jumsu[30] = 27;
        jumsu[31] = 26;
    }


    // 다음 주사위를 확인한다.
    static void go(int idx, int sum) {
        if (idx == 10) { // 주사위배열을 다 훑었을때
            if (ans < sum) ans = sum;
            return;
        }

        // 각 말에 대하여 이동가능 여부 판단 및 이동
        for (int i = 0; i < 4; i++) {
            int here = mal[i];
            if (here == 32) continue; // 말이 이미 도착지점에 있는 경우
            int there = move(i, game[idx]); // 말이 이동한다면 어디로 이동하는가?
            if (isMal(there)) continue; // 그 위치로 이동할 수 있는가?
            mal[i] = there;
            go(idx + 1, sum + jumsu[there]); // 현재 말을 이동 시키고 다음 번째 주사위를 확인한다.
            mal[i] = here;
        }
    }

    // 이동할 다음 위치에 말이 있는가?
    static boolean isMal(int there) { // 말이 이동하는 위치에 대한 값을 매개변수 입력받았다.
        if(there == 32) return false; // 다음 위치는 도착점이므로 이동할 수 있습니다.
        for(int i=0; i<4; i++) {//
            if(mal[i] == there) return true;
        }
        return false;
    }

    // 말을 이동시켜라
    static int move(int me, int count) {
        if (mal[me] == 32)
            return 32;
        int here = mal[me];
        if (v[here].size() == 2) {
            here = v[here].get(1);
            count--;
        }
        while (count != 0) {
            here = v[here].get(0);
            count--;
            if (here == 32)
                break;
        }
        return here;
    }
}