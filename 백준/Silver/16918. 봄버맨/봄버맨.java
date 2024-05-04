import java.io.*;
import java.util.*;

public class Main{

    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};

    static int[][] visited;
    static class Point{
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }

    static int r,c,breakTime;
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        breakTime = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new int[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'O') {
                    visited[i][j] = 3;
                }
            }
        }

        int time = 0;
        while(time++ < breakTime){

            if(time % 2 == 0) {

                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            visited[i][j] = time + 3;
                        }
                    }
                }
            }
            else if(time % 2 == 1){
                for(int y=0; y<r; y++){
                    for(int x=0; x<c; x++){
                        if(visited[y][x] == time) {
                            map[y][x] = '.';
                            for (int dir = 0; dir < 4; dir++) {
                                int ny = y + dy[dir];
                                int nx = x + dx[dir];
                                if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                                if(map[ny][nx] == 'O' && visited[ny][nx] != time){
                                    map[ny][nx] = '.';
                                    visited[ny][nx] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }

        for(int i=0; i<r; i++){
            System.out.println(map[i]);
        }
    }
}