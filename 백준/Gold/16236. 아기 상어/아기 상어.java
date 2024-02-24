
import java.io.*;
import java.util.*;

/**
 * N x N 어항
 * M 마리의 물고기
 * 1마리의 아기상어
 * 아기상어 크기 2이고, 1초에 상하좌우 1칸씩 이동이 가능하다.
 * 자기보다 크기가 작은 물고기 잡아먹으면서 이동한다.
 * 크기가 같은 물고기는 잡아먹을 수 없지만, 이동할 순 있다.
 *
 * 먹을 수 있는 물고기 1마리 이상이면 가장 가까운 물고기를 먹으러 간다.
 * 물고기의 개수가 아기상어의 크기와 같아지면 아기상어는 1만큼 커진다.
 *
 * 물고기를 먹을 수 없다면 엄마상어를 부르게되는데 엄마상어를 부르기전까지 최대로 먹을 수 있는 물고기 수를 구하라.
 * N은 2이상 20이하이고, 빈칸, 물고기 크기, 아기상어 위치가 주어진다.
 */
public class Main {

    static class Fish {
        int y;
        int x;
        int weight;
        boolean alive;

        public Fish(int y, int x, int weight, boolean alive) {
            this.y = y;
            this.x = x;
            this.weight = weight;
            this.alive = alive;
        }
    }

    static class Shark {
        int y;
        int x;
        int eatCount;
        int weight;

        public Shark(int y, int x, int eatCount, int weight) {
            this.y = y;
            this.x = x;
            this.eatCount = eatCount;
            this.weight = weight;
        }
    }

    static int n;
    static int[][] arr, visited;
    static ArrayList<Fish> fishes;
    static Shark shark;

    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new int[n][n];
        fishes = new ArrayList<>();

        // 아기상어와 물고기들에 대한 정의
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] >= 1 && arr[i][j] < 9) {
                    fishes.add(new Fish(i, j, arr[i][j], true));
                } else if (arr[i][j] == 9) {
                    arr[i][j] = 0;
                    shark = new Shark(i, j, 0, 2);
                }
            }

        }

        int ret = 0;
        for(int i=0; i<fishes.size(); i++){
            if(callMom()) break;
            // 먹을 수 있는 물고기가 있다면? 어떤 물고기인가
            int time = bfs();
            if(time == -1) break;
            ret += time;
        }
        System.out.println(ret);


        // 아기상어가 bfs로 주변을 탐색하다가 이동할 수 있으면 이동하고 주변을 다시 탐색한다.
    }



    static boolean callMom(){
        int cnt = 0;
        for(int i=0; i<fishes.size(); i++){
            if(fishes.get(i).alive && fishes.get(i).weight < shark.weight){
                cnt++;
            }
        }
        if(cnt == 0) return true;
        return false;
    }
    static int bfs() {
//        System.out.println(shark.y + " " + shark.x);
        int eatY = 21;
        int eatX = 21;
        Queue<Shark> q = new LinkedList<>();

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = 0;
            }
        }


        q.add(shark);
        visited[shark.y][shark.x] = 1;
        int time = 0;

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int size = 0; size < qSize; size++) {
                Shark now = q.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = now.y + dy[i];
                    int nx = now.x + dx[i];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] == 1) continue; // 샤크가 이동할 수 있으면?
                    visited[ny][nx] = 1;
                    if (arr[ny][nx] == 0 || arr[ny][nx] == shark.weight) {
                        q.add(new Shark(ny, nx, now.eatCount, now.weight));
                    } else if (arr[ny][nx] >= 1 && arr[ny][nx] <= 6 && arr[ny][nx] < shark.weight) { // 먹을 수 있는 물고기에 대한 취합
//                        for(int kill=0; kill<fishes.size(); kill++){
//                            if(fishes.get(kill).y == ny  && fishes.get(kill).x == nx){
////                                System.out.println(kill);
//                                fishes.get(kill).alive = false;
//                            }
//                        }
                        if(eatY > ny){
                            eatY = ny;
                            eatX = nx;
                        }else if(eatY == ny){
                            if(eatX > nx){
                                eatX = nx;
                            }
                        }
                        flag = true;
                    }
                }
            }
            time++;
            if(flag) break;
        }
        if(!flag) return -1; // 다 이동해봣는데 먹을 수 있는 물고기가 없던데?? 갇혀있는 물고기 갇은 경우아닐까?

        for(int kill=0; kill<fishes.size(); kill++){ // 먹을 수 있었으니까 먹어 불자
            if(fishes.get(kill).alive && fishes.get(kill).y == eatY  && fishes.get(kill).x == eatX){
                arr[shark.y][shark.x] = 0;
                shark.y = eatY;
                shark.x = eatX;
                arr[shark.y][shark.x] = 9;
                shark.eatCount++;
                if(shark.eatCount == shark.weight){
                    shark.weight++;
                    shark.eatCount = 0;
                }
                fishes.get(kill).alive = false;
            }
        }
        return time;
    }

}