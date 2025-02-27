import java.util.*;

class Solution {

    static final int MAX_N = 360000;

    static void check(int s, int e){
        add[s] += 1;
        add[e] -= 1;
    }

    static long[] add = new long[MAX_N + 4];
    static long[] psum = new long[MAX_N + 4];
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";

        int n = logs.length;

        StringTokenizer play = new StringTokenizer(play_time, ":");
        int ph = Integer.parseInt(play.nextToken());
        int pm = Integer.parseInt(play.nextToken());
        int ps = Integer.parseInt(play.nextToken());
        int playTime = ph * 3600 + pm * 60 + ps;

        StringTokenizer adv = new StringTokenizer(adv_time, ":");
        int hh = Integer.parseInt(adv.nextToken());
        int mm = Integer.parseInt(adv.nextToken());
        int ss = Integer.parseInt(adv.nextToken());
        int advTime = hh * 3600 + mm * 60 + ss;

        
        int endTime = 0;
        for(int i=0; i<n; i++){
            StringTokenizer log = new StringTokenizer(logs[i], "-");
            StringTokenizer st1 = new StringTokenizer(log.nextToken(), ":");
            StringTokenizer st2 = new StringTokenizer(log.nextToken(), ":");
            int h1 = Integer.parseInt(st1.nextToken());
            int m1 = Integer.parseInt(st1.nextToken());
            int s1 = Integer.parseInt(st1.nextToken());
            int time1 = h1*3600 + m1*60 + s1;

            int h2 = Integer.parseInt(st2.nextToken());
            int m2 = Integer.parseInt(st2.nextToken());
            int s2 = Integer.parseInt(st2.nextToken());
            int time2 = h2*3600 + m2*60 + s2;
            
            endTime = Math.max(time2, endTime);
            check(time1, time2);
        }

        for(int i=1; i<=endTime; i++){
            add[i] += add[i-1];
        }
        
        
        long curTime = 0;
        for(int i=0; i<advTime; i++){
            curTime += add[i];
        }
        
        answer = "00:00:00";
        long maxTime = curTime;
        int startTime = 0;
        int resultTime = startTime;
        
        for(int i=advTime; i<=endTime; i++){
            curTime += add[i];
            curTime -= add[startTime++];
            if(maxTime < curTime){
                int answerH = startTime / 3600;
                int answerM = (startTime % 3600) / 60;
                int answerS = startTime % 60;
                maxTime = curTime;
                
                answer = String.format("%02d:%02d:%02d",answerH, answerM, answerS);
            }
        }


        return answer;
    }
}