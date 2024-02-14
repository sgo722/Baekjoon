
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 - 빵집
 * 문제이해
 * 1열로부터 n열까
 * @author 양준영
 *
 */
public class Main{

    static int[] dy = {-1,0,1};
    static int[] dx = {1,1,1};
    static BufferedReader br;
    static StringTokenizer st;
    static char[][] arr;

    static int[][] visited;
    static int r,c, ans;
    public static void main(String[] args) throws IOException {
//        long start = System.currentTimeMillis();
        br = new BufferedReader(new InputStreamReader(System.in));
        init();

        for(int i=0; i<r; i++) {
            if(solution(i, 0) == true){
                ans++;
            }
        }
        System.out.println(ans);
//        long end = System.currentTimeMillis();
//        System.out.println("수행시간: " + (end - start) /1000.0 + " sec");
    }

    private static boolean solution(int y, int x){
        if(x == c-1) return true;

        boolean flag = false;
        for(int i=0; i<3; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
            if(visited[ny][nx] == 1 || arr[ny][nx] == 'x') continue;
            visited[ny][nx] = 1;
            flag = solution(ny,nx);
            if(flag) return true;
        }
        return false;
    }

    private static void init() throws IOException{ // 입력받기

        st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        visited = new int[r][c];

        for(int i=0; i<r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
    }

    static void printArr(){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(visited[i][j]);
            }
            System.out.println();
        }
    System.out.println();
    System.out.println();
    }

}
