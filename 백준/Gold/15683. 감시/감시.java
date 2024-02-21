import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제 : 감시
 * 아이디어) 백트래킹
 * @author SSAFY
 *
 */
public class Main{


    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};


    // ^ > v <
    // 1개를 킨다. 2개를 킨다. 3개를 킨다. 4개를 킨다.
    // 위아래를 킨다 // 아래 위를 킨다.

    // 0,2 // 1,3

    static class Cctv{
        int y;
        int x;
        int state;
        public Cctv(int y, int x, int state) {
            this.y = y;
            this.x = x;
            this.state = state;
        }
    }
    static int[][] map, temp;
    static ArrayList<Cctv> cctvs;

    static int direction[];
    static int n,m;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        map = new int[n][m];
        temp = new int[n][m];
        cctvs = new ArrayList<>();

        // 입력
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvs.add(new Cctv(i,j,map[i][j]));
                }
            }
        }

//        System.out.println(cctvs.size());


        direction = new int[cctvs.size()];
        dfs(0);

        System.out.println(ans);
    }

    static void dfs(int idx) {

        if(idx == cctvs.size()) {

            // 카메라 켜기
            copyRoom();
            for(int i=0; i<cctvs.size(); i++) {
                turn(cctvs.get(i), direction[i], 7);
            }
            // 사각지대의 크기 계산
            int cnt = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(temp[i][j] == 0) {
                        cnt++;
                    }
                }
            }

//            for(int i=0; i<n; i++){
//                for(int j=0; j<m; j++){
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            ans = Math.min(ans,cnt);
            return;
        }

//        System.out.println(idx + " ");

        // 시시티비를 킨다.
        for(int dir=0; dir<4; dir++) {
            direction[idx] = dir;
            dfs(idx+1);
        }

    }

//    static void debug() {
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<m; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }



    static void turn(Cctv cctv, int dir, int onOff) {

        int y = cctv.y;
        int x = cctv.x;
        if(cctv.state == 1) { // 1번카메라면 지금방향만 키면된다.
            int ny = y;
            int nx = x;
            while(true) {
                ny += dy[dir];
                nx += dx[dir];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || temp[ny][nx] == 6 ) break;
                temp[ny][nx] = onOff;
            }
        }else if(cctv.state == 2) {
            int cnt = 0;
            while(cnt != 2) {
                int ny = y;
                int nx = x;
                while(true) {
                    ny += dy[dir];
                    nx += dx[dir];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= m || temp[ny][nx] == 6) break;
                    temp[ny][nx] = onOff;
                }

                dir = (dir+2) % 4;
                cnt++;
            }
        }else if(cctv.state == 3) { // 직각 방향 탐색
            int cnt = 0;
            while(cnt != 2) {
                int ny = y;
                int nx = x;
                while(true) {
                    ny += dy[dir];
                    nx += dx[dir];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= m || temp[ny][nx] == 6 ) break;
                    temp[ny][nx] = onOff;
                }

                dir = (dir+1) % 4;
                cnt++;
            }
        }else if(cctv.state == 4) { // 3방향 탐색
            int cnt = 0;
            while(cnt != 3) {
                int ny = y;
                int nx = x;
                while(true) {
                    ny += dy[dir];
                    nx += dx[dir];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= m || temp[ny][nx] == 6 ) break;
                    temp[ny][nx] = onOff;
                }

                dir = (dir+1) % 4;
                cnt++;
            }
        }else if(cctv.state == 5) { // 4방향 탐색
            int cnt = 0;
            while(cnt != 4) {
                int ny = y;
                int nx = x;
                while(true) {
                    ny += dy[dir];
                    nx += dx[dir];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= m || temp[ny][nx] == 6) break;
                    temp[ny][nx] = onOff;
                }

                dir = (dir+1) % 4;
                cnt++;
            }
        }
        temp[cctv.y][cctv.x] = cctv.state;
    }

    static void copyRoom(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                temp[i][j] = map[i][j];
            }
        }
    }
}