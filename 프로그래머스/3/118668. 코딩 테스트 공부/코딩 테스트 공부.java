class Solution {
    // 알고력, 코딩력, 알고, 코딩, 시간
    // 알고력, 코딩력이 가장 어려운 문제보다 높아졌을 떄 종료.
    // 어떤 문제를 풀 수 있는 지 확인 - n
    // 경우의 수 3개 3^100 * n
    // 어떤 문제를 푸느냐에 따라 경우의 수가 달라짐
    // 같은 문제를 여러번 풀 수 있다.
    // 알고력을 쭉 올리고, 코딩력을 쭉 올린다.
    static final int MAX_ALP = 150;
    static final int MAX_COP = 150;
    static final int MAX_TIME = 10000;
    
    
    static void findMinTime(int alp, int cop, int time){
        
        if(ans <= time){
            return;
        }
        if(dp[alp][cop] <= time){
            return;
        }
        dp[alp][cop] = time;
        
        int count = 0;
        for(int i=0; i<p.length; i++){
            if(alp >= p[i][0] && cop >= p[i][1]){
                count++;
                if(count == p.length){
                    ans = Math.min(ans, time);
                    return;
                }
                
                int nextAlp = alp + p[i][2] > MAX_ALP ? MAX_ALP : alp + p[i][2];
                int nextCop = cop + p[i][3] > MAX_COP ? MAX_COP : cop + p[i][3];
                int nextTime = time + p[i][4];
                
                if(dp[nextAlp][nextCop] <= nextTime) continue;
                findMinTime(nextAlp, nextCop, nextTime);
            }
        }
        
        if(alp < MAX_ALP && dp[alp+1][cop] > time+1){
            int nextAlp = alp + 1 > MAX_ALP ? MAX_ALP : alp + 1;
            findMinTime(nextAlp, cop, time+1);
        }
        if(cop < MAX_COP && dp[alp][cop+1] > time+1){
            int nextCop = cop + 1 > MAX_COP ? MAX_COP : cop + 1;
            findMinTime(alp, nextCop, time+1);
        }
        
        
    }
    
    static int[][] dp = new int[MAX_ALP + 1][MAX_COP + 1];
    static int ans = MAX_TIME;
    static int[][] p;
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        p = problems;
        for(int i=0; i<=MAX_ALP; i++){
            for(int j=0; j<=MAX_COP; j++){
                dp[i][j] = MAX_TIME;
            }
        }
        
        findMinTime(alp, cop,0);
        
        return ans;
    }
}