import java.io.*;
import java.util.*;

public class Main{

    static class Point{
        int y;
        int x;
        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static Point s;


    static Queue<Point> waters;

    static int r,c;
    static char[][] map;

    static int[][] visited;

    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};



    public static void main(String[] args) throws IOException{
        input();
        bfs();
    }

    static void bfs(){
        int time = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(s);
        visited[s.y][s.x] = 1;

        while(q.size() > 0){
            time++;
            int waterSize = waters.size();
            for(int i=0; i<waterSize; i++){ // 물 이동
                Point water = waters.poll();
                int y = water.y;
                int x = water.x;
                for(int dir=0; dir<4; dir++){
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];
                    if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                    if(map[ny][nx] == '*') continue;
                    if(map[ny][nx] == 'X' || map[ny][nx] == 'D') continue;
                    map[ny][nx] = '*';
                    waters.add(new Point(ny, nx));
                }
            }

            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                Point now = q.poll();
                int y = now.y;
                int x = now.x;
                for(int dir=0; dir<4; dir++){
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];
                    if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                    if(map[ny][nx] == '*' || map[ny][nx] == 'X') continue;
                    if(map[ny][nx] == 'D'){
                        System.out.println(time);
                        return;
                    }
                    if(visited[ny][nx] != 0) continue;
                    visited[ny][nx] = time;
                    q.add(new Point(ny, nx));
                }
            }
        }

        System.out.println("KAKTUS");
        return;
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        waters = new LinkedList<>();
        visited = new int[r][c];
        map = new char[r][c];

        for(int i=0; i<r; i++){
            String str = br.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'S'){
                    s = new Point(i,j);
                }else if(map[i][j] == '*'){
                    waters.add(new Point(i,j));
                }
            }
        }
    }
}