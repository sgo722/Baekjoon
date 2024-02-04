import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 - 반복하지 않는 수
 * 문제 이해)
 * 한신이는 1부터 각 자릿수가 중복되지 않는 수를 순서대로 나열하는데, 그 중 n번째를 물어보면 대답해주면 되는 것이다.
 * 일반적으로 11번째 수를 말하라하면 11을 말하는데, 한신이는 12를 말하게 된다.
 * 아이디어)
 * 1. 중복되는 수를 구분해내면 문제가 해결될 것 같다.
 */

public class Main {
    static int[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        visited = new int[10];
        arr = new int[1000004];
        int count = 0;

        for (int i = 1; count != 1000001; i++) {
            boolean flag = true;
            visitedClear();
            int temp = i;
            while (temp > 0) {
                visited[temp % 10]++;
                if (visited[temp % 10] != 1) {
                    flag = false;
                    break;
                }
                temp /= 10;
            }
            if (flag) arr[count++] = i;
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            System.out.println(arr[n-1]);
        }
    }

    static void visitedClear(){
        for(int i=0; i<10; i++){
            visited[i] = 0;
        }
    }
}