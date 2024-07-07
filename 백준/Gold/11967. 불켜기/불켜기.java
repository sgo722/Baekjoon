import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static class Point{
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int n,m;

    static ArrayList<Point>[][] graph;
    static boolean[][] visited;
    static boolean[][] light;

    static int[] dy= {-1,0,1,0};
    static int[] dx= {0,1,0,-1};

    static int count;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n][n];

        visited = new boolean[n][n];
        light = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                graph[i][j] = new ArrayList<>();
            }
        }



        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            graph[y][x].add(new Point(a,b));
        }

        System.out.println(bfs());
    }

    static int bfs(){
        int count = 1;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0));
        light[0][0] = true;
        visited[0][0] = true;

        while(q.size() > 0){
            Point now = q.poll();

            if(graph[now.y][now.x].size() > 0) {
                visited = new boolean[n][n];
                visited[now.y][now.x]= true;
                for (Point p : graph[now.y][now.x]) {
                    if (light[p.y][p.x]) continue;
                    light[p.y][p.x] = true;
                    count++;
                }
                graph[now.y][now.x].clear();
            }

            for(int i=0; i<4; i++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if(visited[ny][nx] || !light[ny][nx]) continue;
                visited[ny][nx] = true;
                q.add(new Point(ny,nx));
            }
        }

        return count;
    }
}