import java.io.*;
import java.util.*;

public class Main{

    static int n,m,k;
    static int[][][] map;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        map = new int[n+1][m+1][3];

        for(int i=1; i<=n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < 3; k++) {
                    map[i][j][k] = map[i - 1][j][k] + map[i][j - 1][k] - map[i - 1][j - 1][k];
                }
                switch (line.charAt(j - 1)) {
                    case 'J':
                        map[i][j][0]++;
                        break;
                    case 'O':
                        map[i][j][1]++;
                        break;
                    case 'I':
                        map[i][j][2]++;
                        break;
                }
            }
        }

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            for(int j=0;j<3; j++){
                sb.append(map[c][d][j] - map[a-1][d][j] - map[c][b-1][j] + map[a-1][b-1][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}