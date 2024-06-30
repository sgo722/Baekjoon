
import java.io.*;
import java.util.*;

public class Main{

    static class Node{
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }
    static int n,m;
    static int[][] map;
    static int[][] visited;

    static int dy[] = {-1,-1,-1,0,0,1,1,1};
    static int dx[] = {-1,0,1,-1,1,-1,0,1};

    static ArrayList<ArrayList<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int flag = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    visited[i][j] = flag;
                    dfs(i, j, map[i][j], flag);
                    flag++;
                }
            }
        }

//        System.out.println(flag);
//        for(int i=0; i<n; i++){
//            for(int j=0; j<m; j++){
//                System.out.print(visited[i][j] + " ");
//            }
//            System.out.println();
//        }


        for (int i = 0; i < flag; i++) {
            list.add(new ArrayList<>());
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                list.get(visited[i][j]).add(new Node(i, j));
            }
        }


        int cnt = 0;
        for (int i = 1; i < flag; i++) {
            boolean possible = true;
            for (int j = 0; j < list.get(i).size(); j++) {
                Node now = list.get(i).get(j);
                if (!check(now)) {
                    possible = false;
                    break;
                }
            }
            if (possible){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean check(Node node){
        int y = node.y;
        int x = node.x;

        for(int i=0; i<8; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(map[ny][nx] > map[y][x]) return false;
        }
        return true;
    }

    static void dfs(int y, int x, int value, int flag){
        for(int i=0; i<8; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(visited[ny][nx] > 0) continue;
            if(map[ny][nx] == value){
                visited[ny][nx] = flag;
                dfs(ny,nx,value,flag);
            }
        }
    }
}