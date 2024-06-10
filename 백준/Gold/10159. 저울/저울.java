import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] list;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        map = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            map[i][i] = 1;
        }


        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = -1;
        }

        for(int k=1; k<=n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1){
                        map[i][j] = 1;
                    }
                    else if(map[i][k] == -1 && map[k][j] == -1){
                        map[i][j] = -1;
                    }
                }
            }
        }

        for(int i=1; i<=n; i++){
            int cnt = 0;
            for(int j=1; j<=n; j++){
                if(map[i][j] != 0){
                    cnt++;
                }
            }
            System.out.println(n-cnt);
        }
    }
}