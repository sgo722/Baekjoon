import java.io.*;
import java.util.*;

public class Main {

    static int[] temp, arr, ans, visited;
    static int n, m, size;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ans = new int[m];
        temp = new int[n];
        visited = new int[10004];
        size = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (visited[num] == 0) {
                visited[num] = 1;
                temp[size++] = num;
            }
        }

        arr = Arrays.copyOf(temp, size);

        Arrays.sort(arr);

//        for(int i=0; i<size; i++){
//            System.out.print(arr[i] + " ");
//        }
        go(0, 0);

        System.out.print(sb);
    }

    static void go(int idx, int start) {
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                sb.append(ans[i] + " ");
            }
            sb.append("\n");
            return;
        }

        if (idx == 0) {
            for (int i = 0; i < size; i++) {
                ans[idx] = arr[i];
                go(idx + 1, start);
            }
        } else {
            for (int i = start; i < size; i++) {
                if (ans[idx - 1] <= arr[i]) {
                    ans[idx] = arr[i];
                    go(idx + 1, i);
                }
            }
        }
    }
}