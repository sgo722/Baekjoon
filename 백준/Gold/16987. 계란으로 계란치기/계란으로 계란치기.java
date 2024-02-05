import java.io.*;
import java.util.*;

/**
 * 문제 - 계란으로 계란치기
 * 0번 계란으로 랜덤으로 깬다.
 * n-1개의 경우의 수가 파생된다.
 * 깨려고하는 계란에 대해서 알고있어야한다.
 * 깨져있으면 다른 계란을 깨야한다.
 *
 */
public class Main {

    static class Egg{
        int guard;
        int attack;

        public Egg(int guard, int attack) {
            this.guard = guard;
            this.attack = attack;
        }
    }

    static ArrayList<Egg> eggs;
    static int n, ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        eggs = new ArrayList<>();
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            eggs.add(new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        go(0);

        System.out.println(ans);
    }


    static void go(int curEgg) {
        if(curEgg == n) {
            int cnt = 0;
//            printEgg();
            for(int i=0; i<n; i++) {
                if(eggs.get(i).guard <= 0) {
                    cnt++;
                }
            }
            ans = Math.max(ans,cnt);
            return;
        }
        if(eggs.get(curEgg).guard <= 0) { // 계란 깨져있으면 다음으로 넘긴다.
//            System.out.print(curEgg + " "); printEgg();
            go(curEgg+1);
        }
        else { // 계란이 깨져있지 않으면 든다.
            int flag = 0;
            for(int i=0; i<n; i++) {
                if(eggs.get(i).guard <= 0){
                    flag++;
                    continue;
                }
                if(curEgg == i) continue;
//                printEgg();
                eggs.get(curEgg).guard -= eggs.get(i).attack;
                eggs.get(i).guard -= eggs.get(curEgg).attack;
//                System.out.print(curEgg + " "); printEgg();
                go(curEgg+1);
                eggs.get(curEgg).guard += eggs.get(i).attack;
                eggs.get(i).guard += eggs.get(curEgg).attack;
            }
            if(flag == n-1) go(curEgg+1);
        }
    }

    static void printEgg() {
        for(Egg egg : eggs) {
            System.out.print(egg.guard + " ");
        }
        System.out.println();
    }
}