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

        public void drop(){
            y++;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }
    static int r,c,n;
    static char[][] map;

    static int[] list;

    static int[][] visited;

    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        for(int i=0; i<r; i++){
            String s = br.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = s.charAt(j);
            }
        }

        n = Integer.parseInt(br.readLine());
        list = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            int h = r - list[i];

            if(i%2==0) {
                for (int j = 0; j < c; j++) {
                    if (map[h][j] == 'x') {
                        map[h][j] = '.';
                        break;
                    }
                }
            }else{
                for (int j = c-1; j >= 0 ; j--) {
                    if (map[h][j] == 'x') {
                        map[h][j] = '.';
                        break;
                    }
                }
            }


            int clusterId = checkClusterId();
            ArrayList<Point> arr[] = new ArrayList[clusterId+1];

            for(int idx=0; idx<=clusterId; idx++){
                arr[idx] = new ArrayList<>();
            }

            for(int y=r-1; y>=0; y--) {
                for (int x = c-1; x >=0; x--) {
                    int idx = visited[y][x];
                    if(idx > 0){
                        arr[idx].add(new Point(y,x));
                    }
                }
            }

            for(int idx=1; idx<=clusterId; idx++){
                boolean flag = true;
                while(flag) {
                    for (Point p : arr[idx]) {
                        int ny = p.y + 1;
                        if(ny < r && map[ny][p.x] == '.') continue;
                        if(ny >= r || visited[ny][p.x] != idx){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        for(Point p : arr[idx]){
                            visited[p.y][p.x] = 0;
                            map[p.y][p.x] = '.';
                            p.drop();
                            map[p.y][p.x] = 'x';
                            visited[p.y][p.x] = idx;
                        }
                    }
                }
            }

        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }


    static int checkClusterId(){
        int clusterId = 0;
        visited = new int[r][c];
        ArrayList<Point> list = new ArrayList<>();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if (map[i][j] == 'x') {
                    list.add(new Point(i,j));
                }
            }
        }

        for(Point p : list){
            if(visited[p.y][p.x] > 0) continue;
            clusterId++;
            checkComponent(p.y,p.x, clusterId);
        }

//        System.out.println(clusterId);
//        System.out.println(list);
        return clusterId;
    }

    static void checkComponent(int y, int x, int clusterId){

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(y,x));
        visited[y][x] = clusterId;

        while(q.size() > 0){
            Point now = q.poll();
            for(int i=0; i<4; i++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                if(map[ny][nx] == '.') continue;
                if(visited[ny][nx] > 0) continue;
                visited[ny][nx] = clusterId;
                q.add(new Point(ny,nx));
            }
        }
    }
}