import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 - 11729_하노이탑 이동순서
 * 문제 이해 -
 * 하노이탑은 3개의 장대로 이루어져있고, 첫번째 장대에 있는 원판들을 세번째 장대로 이동시키는 문제이다.
 * 이동시킬떄는 1가지 규칙이 있다. 작은 원판이 큰 원판보다 아래로 이동할 수 없다는 규칙이다.
 * 아이디어)
 * 재귀를 이용한 방식으로 문제를 풀어볼건데, N개가 이동하려면
 * N-1개가 N개가 이동하려는 방향과 다른방향으로 이동해야한다.
 * 그렇게 되면 1개가 이제 원하는 방향으로 이동할 수 있게 된다.
 */


public class Main{
    static StringBuilder sb = new StringBuilder();
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        go(n,1,2,3);
        System.out.println((1<<n)-1);
        System.out.println(sb);
    }

    static void go(int count, int from, int temp, int to){
        if(count == 0) {
            return;
        }

        go(count-1, from, to, temp);
        sb.append(from).append(" ").append(to).append("\n");
        go(count-1, temp, from, to);
    }
}