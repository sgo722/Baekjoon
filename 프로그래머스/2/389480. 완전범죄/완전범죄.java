class Solution {
    
    static final int MAX_IDX = 40;
    static final int MAX_N = 120;
    static final int MAX_M = 120;
    static int answer = Integer.MAX_VALUE;
    static int[][] infos;
    static boolean[][][] dp = new boolean[MAX_IDX + 1][MAX_N + 1][MAX_M + 1];
    
    static void dfs(int idx, int a, int b, int n, int m){
        if(a >= n || b >= m) return;
        if(idx == infos.length){
            answer = Math.min(answer, a);
            return;
        }
        
        if(dp[idx][a][b]) return;
        
        dp[idx][a][b] = true;
        dfs(idx+1, (a + infos[idx][0]) >= MAX_N ? MAX_N : a + infos[idx][0], b , n , m);
        dfs(idx+1, a , (b + infos[idx][1]) >= MAX_M ? MAX_M : b + infos[idx][1], n , m);
        
    }
    public int solution(int[][] info, int n, int m) {
        
        infos = info;
        dfs(0,0,0,n,m);
        
        if(answer == Integer.MAX_VALUE) answer = -1;
        
        return answer;
    }
}