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
    static long[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int h = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        if(h > n){
            int tmp = h;
            h = n;
            n = tmp;
        }
        arr = new long[31][31];
        for (int i = h; i <= 30; i++) {
            arr[i][h] = 1;
        }

        for (int i=h+1; i<=n; i++){
            for(int j=h+1; j<=n; j++){
                if(i < j) arr[i][j] = 0;
                else arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }

        System.out.println(arr[n][n]);
    }
}