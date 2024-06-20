import java.io.*;
import java.util.*;

public class Main{
    static int h,w;

    static int[] height;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        height = new int[w];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<w; i++){
            int h = Integer.parseInt(st.nextToken());
            height[i] = h;
        }

        for(int i=0; i<w; i++){
            for(int j=h-1; j>h-1-height[i]; j--){
                map[j][i] = 1;
            }
        }

        for(int i=0; i<w; i++){
            for(int j=h-1; j>h-1-height[i]; j--){
                if(map[j][i] == 1){
                    int k = i+1;
                    boolean flag = false;
                    for(k=i+1; k<w; k++){
                        if(map[j][k] == 1){
                            flag = true;
                            break;
                        }
                    }
                    if(flag) {
                        for (int y = i + 1; y < k; y++) {
                            map[j][y] = 2;
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(map[i][j] == 2){
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}