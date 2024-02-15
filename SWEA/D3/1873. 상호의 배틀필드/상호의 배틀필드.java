
/**
 * 문제 이해 - 1873. 상호의 배틀필드
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{

    static BufferedReader br;

    static StringTokenizer st;

    static int r,c;

    static char[][] arr;

    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};

    static Tank tank;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            arr = new char[r][c];
            for (int i = 0; i < r; i++) {
                String s = br.readLine();
                for (int j = 0; j < c; j++) {
                    arr[i][j] = s.charAt(j);
                    if (arr[i][j] == '<' || arr[i][j] == '>' || arr[i][j] == '^' || arr[i][j] == 'v') {
                        if (arr[i][j] == '<') {
                            tank = new Tank(i, j, 3);
                        }
                        if (arr[i][j] == '>') {
                            tank = new Tank(i, j, 1);
                        }
                        if (arr[i][j] == '^') {
                            tank = new Tank(i, j, 0);
                        }
                        if (arr[i][j] == 'v') {
                            tank = new Tank(i, j, 2);
                        }
                    }
                }
            }

            int p = Integer.parseInt(br.readLine());
            String s = br.readLine();
            for (int i = 0; i < p; i++) {
                char op = s.charAt(i);
                go(op, tank.y, tank.x);
            }

            System.out.print("#" + tc + " ");
            for(int j=0; j<r; j++){
                for(int k=0; k<c; k++){
                    System.out.print(arr[j][k]);
                }
                System.out.println();
            }
        }
    }

    static void go(char op, int y, int x) {
        if(op == 'S') {
            while(true) {
                int ny = y + dy[tank.dir];
                int nx = x + dx[tank.dir];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c || arr[ny][nx] == '#') return;
                if(arr[ny][nx] == '*'){
                    arr[ny][nx] = '.';
                    return;
                }
                y = ny;
                x = nx;
            }

        }else if(op == 'U') {
            arr[tank.y][tank.x] = '^';
            int ny = y + dy[0];
            int nx = x + dx[0];
            tank.dir = 0;
            if(ny < 0 || nx < 0 || ny >= r || nx >= c || arr[ny][nx] == '-' || arr[ny][nx] == '*' || arr[ny][nx] == '#') return;
            arr[tank.y][tank.x] = '.';
            tank.y = ny;
            tank.x = nx;
            arr[ny][nx] = '^';
        }else if(op == 'R') {
            arr[tank.y][tank.x] = '>';
            int ny = y + dy[1];
            int nx = x + dx[1];
            tank.dir = 1;
            if(ny < 0 || nx < 0 || ny >= r || nx >= c || arr[ny][nx] == '-' || arr[ny][nx] == '*' || arr[ny][nx] == '#') return;
            arr[tank.y][tank.x] = '.';
            tank.y = ny;
            tank.x = nx;
            arr[ny][nx] = '>';
        }else if(op == 'D') {
            arr[tank.y][tank.x] = 'v';
            int ny = y + dy[2];
            int nx = x + dx[2];
            tank.dir = 2;
            if(ny < 0 || nx < 0 || ny >= r || nx >= c || arr[ny][nx] == '-' || arr[ny][nx] == '*' || arr[ny][nx] == '#') return;
            arr[tank.y][tank.x] = '.';
            tank.y = ny;
            tank.x = nx;
            arr[ny][nx] = 'v';
        }else if(op == 'L') {
            arr[tank.y][tank.x] = '<';
            int ny = y + dy[3];
            int nx = x + dx[3];
            tank.dir = 3;
            if(ny < 0 || nx < 0 || ny >= r || nx >= c || arr[ny][nx] == '-' || arr[ny][nx] == '*' || arr[ny][nx] == '#') return;
            arr[tank.y][tank.x] = '.';
            tank.y = ny;
            tank.x = nx;
            arr[ny][nx] = '<';
        }
    }

    static class Tank{
        int y;
        int x;
        int dir;

        public Tank(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }
}