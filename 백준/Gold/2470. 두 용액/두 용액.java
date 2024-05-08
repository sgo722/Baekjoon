
import java.io.*;
import java.util.*;

public class Main{
    static int n;

    static class Point{
        int s;
        int e;

        public Point(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "s=" + s +
                    ", e=" + e +
                    '}';
        }
    }
    static ArrayList<Integer> water;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        water = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            water.add(num);
        }

        Collections.sort(water);


        int s = 0;
        int e = water.size()-1;
        int ans = Integer.MAX_VALUE;
        Point point = new Point(s,e);
        while(s < e){
            int start = water.get(s);
            int end = water.get(e);
            int sum = start+end;
            int sumAbs = Math.abs(sum);
            if(ans > sumAbs){
                ans = sumAbs;
                point.s = s;
                point.e = e;
            }
            if(sum == 0) break;
            if(sum < 0) s++;
            else e--;
        }


        System.out.println(water.get(point.s) + " " + water.get(point.e));
    }
}