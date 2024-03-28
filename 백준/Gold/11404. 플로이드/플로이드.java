import java.io.*;
import java.util.*;

public class Main{

    static final int MAX = 10000001;
    static int n, m, s,e,d;
    static int[][] dist;
    public static void main(String[] args) throws IOException{
        input();
        floyd();
        print();
    }


    static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dist[i][j] == MAX) dist[i][j] = 0;
                sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }


    static void floyd(){

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    dist[i][j] = Math.min(dist[i][k] +dist[k][j], dist[i][j]);
                }
            }
        }
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(dist[i],MAX);
        }

        for(int i=0; i<n; i++){
            dist[i][i] = 0;
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()) - 1;
            e = Integer.parseInt(st.nextToken()) - 1;
            d = Integer.parseInt(st.nextToken());
            dist[s][e] = Math.min(dist[s][e], d);
        }
    }
}