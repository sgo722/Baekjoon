import java.io.*;
import java.util.*;

/**
 * 문제 - 다리만들기2
 * @author SSAFY
 * 섬을 구분해야한다.
 * 다리를 연결한다.
 */
public class Main {

    static class Node{
        int r;
        int c;
        int len;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
            this.len = 0;
        }

        public Node(int r, int c, int len) {
            this.r = r;
            this.c = c;
            this.len = len;
        }
    }

    static int dr[] = {-1,0,1,0};
    static int dc[] = {0,1,0,-1};
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Node> islands;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        input();
        seperateIsland();
//        debugMap();
        connect();
        System.out.println(ans);
    }

    static void connect() {

        for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                if(map[r][c] != 0) {
                    findBridge(r,c,map[r][c]);
                }
            }
        }
    }

    static void findBridge(int r, int c, int mapIdx) {
        Queue<Node> q = new LinkedList<>();
        visitedClear();
        q.add(new Node(r,c));
        visited[r][c] = true;

        while(q.size()>0) {
            Node now = q.poll();
            for(int i=0; i<4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == mapIdx) continue;
                if(map[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    q.add(new Node(nr,nc,now.len+1));
                }else if(map[nr][nc] != 0 && now.len >= 1){
                    ans = Math.min(ans, now.len);
                    return;
                }
            }
        }
    }

    static void seperateIsland() {

        int island = 2;
        for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                if(map[r][c] == 1) {
                    bfs(r,c, island);
                    island++;
                }
            }
        }
    }


    static void bfs(int r, int c, int flag) {
        Queue<Node> q = new LinkedList<>();
        visitedClear();
        map[r][c] = flag;
        q.add(new Node(r,c));
        visited[r][c] = true;

        while(q.size()>0) {
            Node now = q.poll();
            for(int i=0; i<4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 1) {
                    map[nr][nc]= flag;
                    visited[nr][nc] = true;
                    q.add(new Node(nr,nc));
                }
            }
        }

    }

    static void input() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        islands = new ArrayList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void visitedClear(){

        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                visited[r][c] = false;
            }
        }
    }

    static void debugMap() {
        for(int r=0;r<n;r++) {
            for(int c=0; c<n; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
    }
}