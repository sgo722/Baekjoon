import java.io.*;
        import java.util.*;

public class Main {


    static class Move implements Comparable<Move> {
        int y;
        int x;
        int dir;
        int mirror;

        public Move(int y, int x, int dir, int mirror) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.mirror = mirror;
        }


        @Override
        public int compareTo(Move o) {
            return this.mirror - o.mirror;
        }
    }

    static int w, h, ans;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static char[][] map;
    static int[][][] visited;
    static Move[] cPoint;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new char[h][w];
        visited = new int[h][w][4];
        cPoint = new Move[2];
        ans = Integer.MAX_VALUE;

        for (int r = 0, idx = 0; r < h; r++) {
            String s = br.readLine();
            for (int c = 0; c < w; c++) {
                map[r][c] = s.charAt(c);
                if (map[r][c] == 'C') {
                    cPoint[idx++] = new Move(r,c,-1,-1);
                }
            }
        }


        bfs(cPoint[0]);
        System.out.println(ans);
    }

    static void bfs(Move start) {

        PriorityQueue<Move> q = new PriorityQueue<>();
        Move end = cPoint[1];
        q.add(start);


        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        while (!q.isEmpty()) {
            Move now = q.poll();
            int y = now.y;
            int x = now.x;
            int dir = now.dir;
            int mirror = now.mirror;


            if(y == end.y && x == end.x){
                ans = Math.min(ans,mirror);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= h || nx >= w) continue;
                if (map[ny][nx] == '*') continue;
                if(dir != -1 && (dir+4+2)%4 == i) continue;
                int nextMirror = (dir == i) ? mirror : mirror+1;
                if(visited[ny][nx][i] > mirror){
                    visited[ny][nx][i] = nextMirror;
                    q.add(new Move(ny,nx,i,nextMirror));
                }
            }
        }
    }
}