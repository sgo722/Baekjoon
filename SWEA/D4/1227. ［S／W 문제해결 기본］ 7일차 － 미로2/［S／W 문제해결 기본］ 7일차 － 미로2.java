import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{

    static char[][] map;
    static Point start, end;

    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};

    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[100][100];
        for(int tc=1; tc<=10; tc++){
            visited = new int[100][100];
            br.readLine();
            for(int r=0; r<100; r++){
                String s = br.readLine();
                for(int c=0; c<100; c++){
                    map[r][c] = s.charAt(c);
                    if(map[r][c] == '2') start = new Point(r,c);
                    if(map[r][c] == '3') end = new Point(r,c);
                }
            }

            bfs(start);
            if(visited[end.y][end.x] == 1) {
                System.out.println("#" + tc + " " + 1);
            }else{
                System.out.println("#" + tc + " " + 0);
            }
        }
    }

    static void bfs(Point start){
        Queue<Point> q = new LinkedList<>();
        visited[start.y][start.x] = 1;
        q.add(start);

        while(q.size() > 0 && visited[end.y][end.x] == 0){
            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                Point p = q.poll();
                for(int dir=0; dir<4; dir++){
                    int ny = p.y + dy[dir];
                    int nx = p.x + dx[dir];
                    if(ny < 0 || nx < 0 || ny >= 100 || nx >= 100 || visited[ny][nx] == 1 || map[ny][nx] == '1') continue;
                    visited[ny][nx] = 1;
                    q.add(new Point(ny,nx));
                }
            }
        }
    }
}

class Point{
    int y;
    int x;
    public Point(int y, int x){
        this.y = y;
        this.x = x;
    }
}