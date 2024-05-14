import java.io.*;
import java.util.*;


public class Main{

    static class Test implements Comparable<Test>{
        int k;
        int score;

        public Test(int k, int score) {
            this.k = k;
            this.score = score;
        }

        @Override
        public int compareTo(Test o) {
            return o.k - this.k;
        }
    }
    static int[][] dp;

    static ArrayList<Test> tests;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        dp = new int[n+1][t+1];
        tests = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            tests.add(new Test(k,score));
        }

        Collections.sort(tests);

        for(int i=1; i<=n; i++){
            Test test = tests.get(i-1);
            int k = test.k;
            int score = test.score;
            for(int j=0; j<=t; j++){
//                System.out.println(k + " " + score);
                if(j + k <= t) {
                    dp[i][j+k] = Math.max(dp[i-1][j+k], dp[i-1][j] + score);
//                    System.out.println(dp[i][j]);
                }
            }
        }

        System.out.println(dp[n][t]);

    }
}

// 평균으로 나눈 값보다 현재 인덱스의 값이 작으면 값을 빼고 평균을 다시 계산
// 평균보다 값이 크면 이게 맥스값이 된다.