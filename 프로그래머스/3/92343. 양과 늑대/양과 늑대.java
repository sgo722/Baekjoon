import java.util.*;

class Solution {
    // 17마리의 양과 늑대가 존재함.
    // 1
    static class Node{
        int info;
        ArrayList<Integer> childs;
        
        public Node(int info){
            this.info = info;
            childs = new ArrayList<>();
        }
        
        public void addChild(int childIdx){
            childs.add(childIdx);
        }
        
    }
    
    static final int MAX_NUM = 17;
    static Node[] parents = new Node[MAX_NUM + 1];
    static int[] visited = new int[MAX_NUM + 1];
    static int ans = 0;
    
    static void findMaxNum(int sheep, int wolf, ArrayList<Integer> canGo){
        
        if(sheep <= wolf){
            return;
        }
        ans = Math.max(ans, sheep);
        
        int size = canGo.size();
        for(int i=0; i<size; i++){
            
            ArrayList<Integer> nextCanGo = new ArrayList<>();
            
            int nextIdx = canGo.get(i);
            if(visited[nextIdx] >= 1) continue;
            
            int info = parents[nextIdx].info;
            visited[nextIdx]++;
            
            for(int child : parents[nextIdx].childs){
                nextCanGo.add(child);
            }
            
            for(int origin : canGo){
                nextCanGo.add(origin);
            }
            
            if(info == 0){
                findMaxNum(sheep + 1, wolf, nextCanGo);
            }else{
                findMaxNum(sheep, wolf + 1, nextCanGo);
            }
            
            
            visited[nextIdx]--;
            
            
            
        }
        
    }
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        int n = info.length;
        
        for(int i=0; i<n; i++){
            parents[i] = new Node(info[i]);
        }
        
        for(int i=0; i<n-1; i++){
            int parent = edges[i][0];
            int child = edges[i][1];
            parents[parent].addChild(child);
        }
        
        visited[0] = 1;
        findMaxNum(1, 0, parents[0].childs);
        
        answer = ans;
        return answer;
    }
}