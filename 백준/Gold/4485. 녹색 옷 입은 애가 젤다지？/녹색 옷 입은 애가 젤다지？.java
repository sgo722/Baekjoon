import java.io.*;
import java.util.*;

public class Main{

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int[][] map, visited;
    static int n;

    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        int test = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            test++;
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            map = new int[n][n];
            visited = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    visited[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs();
            System.out.println("Problem " + test + ": " + visited[n-1][n-1]);
        }
    }

    static void bfs(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0));
        visited[0][0] = map[0][0];

        while(q.size() > 0){
            Point p = q.poll();
            int y = p.y;
            int x = p.x;

            for(int i=0; i<4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if(visited[ny][nx] > visited[y][x] + map[ny][nx]){
                    visited[ny][nx] = visited[y][x] + map[ny][nx];
                    q.add(new Point(ny,nx));
                }
            }
        }
    }
}