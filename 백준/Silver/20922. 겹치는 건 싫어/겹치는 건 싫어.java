import java.io.*;
import java.util.*;


public class Main{


    static class Point{
        int num;
        int cnt;

        public Point(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
    static int n, k, ans;
    static int[] arr;
    static int[] cnt;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Queue<Point> q = new LinkedList<>();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        cnt = new int[100004];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            cnt[num]++;
            while(cnt[num] > k){
                Point poll = q.poll();
                int pollNum = poll.num;
                cnt[pollNum]--;
            }
            q.add(new Point(num,cnt[num]));
            ans = Math.max(ans, q.size());
        }

        System.out.println(ans);
    }
}