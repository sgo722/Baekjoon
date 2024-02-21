
import java.io.*;
import java.util.*;

/**
 * 제목 : 치킨배달
 * 치킨거리 중 최저로 걸리는 거리를 출력하라.
 * @author SSAFY
 *
 */
public class Main{
    static class Point{
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    static ArrayList<Point> homes, chickens;
    static int[][] map;
    static int[] onChicken;
    static int ans = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        homes = new ArrayList<>();
        chickens = new ArrayList<>();
        
        map = new int[n][n];
        onChicken = new int[15];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) { // 집이면?
                    homes.add(new Point(i,j));
                }else if(map[i][j] == 2) { // 치킨집이면?
                    chickens.add(new Point(i,j));
                }
            }
        }
        
        
        go(m,-1); // m개의 치킨집을 설치한다.
        
        System.out.println(ans);
    }
    
    static void go(int count, int idx) {
        
        if(count == 0){// 치킨집 다 설치했다.

            int caseAns = 0;
            ArrayList<Integer> ck = new ArrayList<>();
            for(int i=0; i<chickens.size(); i++) {
                if(onChicken[i] == 1) {
                    ck.add(i);
                }
            }
            
            
            for(int i=0; i<homes.size(); i++) {
                int ret = Integer.MAX_VALUE;
                for(int j=0; j<ck.size(); j++) {
                    ret = Math.min(ret, calDist(i,ck.get(j)));
                }
                caseAns += ret;
            }
            
            ans = Math.min(ans, caseAns);
            return;
        }
        
        for(int i=idx+1; i<chickens.size(); i++) {
            onChicken[i] = 1;
            go(count-1, i);
            onChicken[i] = 0;
        }
    }
    
    
    static int calDist(int homeId, int ckId) {
        int y = Math.abs(homes.get(homeId).y - chickens.get(ckId).y);
        int x = Math.abs(homes.get(homeId).x - chickens.get(ckId).x);
        return x+y;
        
    }
}