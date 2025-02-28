import java.util.*;

class Solution {
    
    // 외벽 점검을 1시간안에 해야하는데 최소의 친구들을 보내서 취약지점들에 대한 조사를 한다.
    // s <= 조사 <= s + dist[i];
    // 12라 하면 0 ~ 11인덱스가 주어진다?
    // 1. 2 ^ 100 -> 친구 넣어보고 확인한다 : 시간복잡도 터지겠다.
    // 무조건 한 조사지점을 잡고 시작하는게 맞겠다.
    // l <= 위치 <= r;
    // 하나의 dist가 여러개의 weak지점으로 들어갈 수 잇다고 생각해보면
    // 원형이라는 점을 어떻게 이용하면 되지 않을까
    

    static final int MAX_N = 200;
    static int[] visited = new int[MAX_N + 1];
    
    static boolean isFinish(int[] weak){
        for(int i=0; i<weak.length; i++){
            int weakIdx = weak[i];
            if(visited[weakIdx] == 0) return false;
        }
        
        return true;
    }
    
    static void checkDist(int startIdx, int dist, int n){
        
        for(int i = 0; i<= dist; i++){
            int nextIdx = (startIdx + i) % n;
            visited[nextIdx]++;
        }
    }
    
    static void uncheckDist(int startIdx, int dist, int n){
        
        for(int i = 0; i<=dist; i++){
            int nextIdx = (startIdx + i) % n;
            visited[nextIdx]--;
        }
    }
    
    static void dfs(int depth, int n, int[] weak, int[] dist){
        
        if(depth >= answer) return;
        
        if(isFinish(weak)){
            answer = Math.min(depth, answer);
            return;
        }
        
        if(depth == dist.length){
            return;
        }
        
        
        for(int i=0; i<weak.length; i++){
            if(visited[weak[i]] > 0) continue;
            
            checkDist(weak[i], dist[depth], n);
            dfs(depth+1, n, weak, dist);
            uncheckDist(weak[i], dist[depth], n);
        }
    }
    
    static int answer = Integer.MAX_VALUE;
    public int solution(int n, int[] weak, int[] dist) {
        
        int[] temp = new int[dist.length];
        for(int i=0; i<dist.length; i++){
            temp[i] = dist[i];
        }
        
        Arrays.sort(temp);
        for(int i=0; i<dist.length; i++){
            dist[dist.length-1-i] = temp[i];
        }
        dfs(0,n,weak,dist);
        
        
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
}