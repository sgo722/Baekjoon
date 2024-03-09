import java.io.*;
import java.util.*;

public class Main {


    static class Node{
        int y;
        int x;
        int breakWall;

        public Node(int y ,int x, int breakWall){
            this.y = y;
            this.x = x;
            this.breakWall = breakWall;
        }
    }
    static BufferedReader br;
    static StringTokenizer st;
    static int n,m;

    static int[][] map;

    static int[][][] visited;

    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};


    public static void main(String[] args) throws IOException{
        input();
        bfs();
        printAns();
//        visitedDebug(visited);
    }

    static void printAns() {
        int ans = Math.min(visited[0][n-1][m-1], visited[1][n-1][m-1]);
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(ans);
    }

    static void bfs(){
        Node start = new Node(0,0,0);
        visitedClear();
        visited[0][0][0] = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(start);


        while(q.size() > 0){
            Node now = q.poll();
            for(int i=0; i<4; i++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue; // 범위를 벗어났을 경우
                if(visited[now.breakWall][ny][nx] != Integer.MAX_VALUE) continue; // 이미 방문한 지점이라면?
                if(map[ny][nx] == 1){ // 이동하려는 곳이 벽이면?
                    if(now.breakWall == 0) {
                        if(visited[now.breakWall+1][ny][nx] > visited[now.breakWall][now.y][now.x] + 1) {
                            visited[now.breakWall+1][ny][nx] = visited[now.breakWall][now.y][now.x] + 1;
                            q.add(new Node(ny,nx,now.breakWall+1));
                        }
                    }
                }else {  // 벽이 아니라면?
                    if(visited[now.breakWall][ny][nx] > visited[now.breakWall][now.y][now.x] + 1) {
                        visited[now.breakWall][ny][nx] = visited[now.breakWall][now.y][now.x] + 1;
                        q.add(new Node(ny, nx, now.breakWall));
                    }
                }
            }
        }
    }

    static void visitedClear(){
        for(int i=0; i<2; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
    }

    static void visitedDebug(int[][][] visited){
        for(int i=0; i<2; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    System.out.print(visited[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println();
    }

    static void input() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new int[2][n][m];
        map = new int[n][m];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }
    }
}