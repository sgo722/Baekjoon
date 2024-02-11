import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * 문제 - 레벨 햄버거
 * N레벨의 햄버거가 주어졌을 때, X개의 햄버거를 먹을 것이다
 * 그러면 패티를 몇장 먹었는지 구하라.
 * 우리가 햄버거를 생각해보면 B + (N-1)레벨 햄버거 + P + (N-1)레벨 햄버거 + B 이다.
 *
 * 0레벨의 1개의 패티를 먹은 경우는 +1
 * N>=1이상인 경우,
 * 1. 인덱스가 1인 경우는 0을 리턴한다.
 * 2. 인덱스가 2이상 P미만인 경우는 N-1햄버거의 패티를 다 먹은 것이다.
 * 3. 인덱스가 P와 같은 경우 N-1햄버거의 패티를 다 먹고 0번쨰에서 1개의 패티를 먹은 것이다.
 * 4.
 *
 *
 */
public class Main {

    static long[] patty, burger;
    static int n;
    static long x;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        x = Long.parseLong(st.nextToken());

        burger = new long[51];
        patty = new long[51];
        burger[0] = 1;
        burger[1] = 5;
        patty[0] = 1;
        patty[1] = 3;
        for(int i=2; i<=n; i++){
            burger[i] = burger[i-1] * 2 + 3;
            patty[i] = patty[i-1] * 2 + 1;
        }

        System.out.println(go(n,x));
    }

    static long go(int level, long target){

//        System.out.println("level : " + level + ", target : " + target);
        if(level == 0){
            return 1;
        }
        long ret = 0;
        if(target == 1){
            return 0;
        }else if(target < burger[level]/2+1){
            ret += go(level-1, target-1);
        }else if(target == burger[level]/2+1){
            ret += patty[level-1]+patty[0];
        }else if(target < burger[level]){
            ret += go(level-1, target-burger[level-1]-2) + patty[level-1] + patty[0];
        }else if(target == burger[level]){
            ret += patty[level];
        }
        return ret;
    }
}