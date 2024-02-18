import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 파핑파핑 지뢰찾기
 * dfs로 지뢰를 찾아나가는게 맞다고 본다. 왜?
 * => 1행 1열부터 0을 찾아가면서 다 터트린다. 그리고나서 한번 더 돌면서 터져야하는 폭탄들을 카운트하면 될 것 같다.
 * 그러면 복구하는 경우도 없기때문에 시간복잡도를 효율적으로 변경할 수 있다.
 */
public class Solution {


    static char[][] map;
    static int[][] cur, visited;
    static ArrayList<Point> noMine;

    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    static int n, t, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            ans = 0;
            n = Integer.parseInt(br.readLine());
            noMine = new ArrayList<>();
            map = new char[n][n]; // 맵은 어떻게 생겨먹었는가?
            cur = new int[n][n]; // 주변에 지뢰가 몇개있는가?
            visited = new int[n][n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = s.charAt(j);
                }
            }

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    int cnt = 0;
                    if(map[y][x] == '.') {
                        for (int k = 0; k < 8; k++) { // 현재위치로부터 8방향 탐색
                            int ny = y + dy[k];
                            int nx = x + dx[k];
                            if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                            if (map[ny][nx] == '*') cnt++; // 지뢰가있다면?
                        }
                        cur[y][x] = cnt; // 현재 위치에서 8방향으로 지뢰의 개수 카운트
                    }
                }
            }

//            for(int i=0; i<n; i++){
//                for(int j=0; j<n; j++){
//                    System.out.print(cur[i][j] + " ");
//                }
//                System.out.println();
//            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '.') { // 땅이라면
                        if (cur[i][j] == 0 && visited[i][j] == 0) { // 주변에 지뢰가 없는 땅이라면?
                            ans++;
                            boom(i, j);
                        } else noMine.add(new Point(i, j)); // 주변에 지뢰가 있는 땅이라면?
                    }
                }
            }

            for(int i=0; i< noMine.size(); i++){
                int y = noMine.get(i).y;
                int x = noMine.get(i).x;
                if(visited[y][x] == 0) ans++;
            }

            System.out.println("#" + tc + " " + ans);
        }
    }

//    static boolean checkAround(int y, int x){
//
//        for(int i=0; i<8; i++){
//            int ny = y + dy[i];
//            int nx = x + dx[i];
//            if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
//            if(map[ny][nx] == '*') return false;
//        }
//
//        return true;
//    }

    static void boom(int y, int x) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(y, x));
        visited[y][x] = 1;
        while (q.size() > 0) {
            Point p = q.poll();
            for (int i = 0; i < 8; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n || map[ny][nx] == '*') continue;
                if (visited[ny][nx] == 1) continue;
                visited[ny][nx] = 1;
                if (cur[ny][nx] == 0) {
                    q.add(new Point(ny, nx));
                }
            }
        }
    }
}

class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}