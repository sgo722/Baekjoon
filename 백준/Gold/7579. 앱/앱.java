import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br;
    static int n,m;

    static int ans;

    static int[][] arr;
    static ArrayList<App> apps;
    static class App{
        int memory;
        int cost;

        public int getMemory() {
            return memory;
        }

        public int getCost() {
            return cost;
        }

        public void setMemory(int memory) {
            this.memory = memory;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public App(int memory ,int cost) {
            this.memory = memory;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "App{" +
                    "memory=" + memory +
                    ", cost=" + cost +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException{
        input();
        solution();
    }


    static void solution(){

        for(int i=1; i<=n; i++){
            int memory = apps.get(i-1).getMemory();
            int cost = apps.get(i-1).getCost();
            for(int j=0; j<=10000; j++){
                if(j >= cost){ // 가방에 넣을 수 있으면 => 비용이 이렇게 걸리면?
                    arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-cost] + memory);
                }else{ // 가방에 못넣으면? => 비용이 작으면?
                    arr[i][j] = arr[i-1][j];
                }

                if(arr[i][j] >= m) ans = Math.min(ans, j);
            }
        }

        System.out.println(ans);
    }
    static void input() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        arr = new int[n+1][10001];
        apps = new ArrayList<>();
        ans = Integer.MAX_VALUE;

        st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int memory = Integer.parseInt(st1.nextToken());
            int cost = Integer.parseInt(st2.nextToken());
            App app = new App(memory, cost);
            apps.add(app);
        }
    }
}