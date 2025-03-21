import java.util.*;

class Solution {
    // 30 ^ 5 <= 2^25 * 2^6 <= 2^32 - 1;
    // 2 ^ 30 = 10 ^ 9;
    // 가지치기.
    static final int MAX_N = 30;
    static int answer = 0;
    static int[][] qtemp;
    static int[] anstemp;
    static ArrayList<HashMap<Integer, Integer>> list = new ArrayList<>();
    static boolean[] visited = new boolean[MAX_N + 1];
    
    static boolean check(ArrayList<Integer> numbers){
        
        for(int i=0; i<list.size(); i++){
            
            int count = 0;
            for(int j=0; j<numbers.size(); j++){
                if(list.get(i).containsKey(numbers.get(j))){
                    count++;
                }
            }
            if(count != anstemp[i]) return false;
        }
        
        return true;
    }
    
    static void dfs(int depth, int n, ArrayList<Integer> numbers, int lastNumber){
        if(depth == 5){
            if(check(numbers)){
                answer++;
            }
            return;
        }
        
        for(int i=lastNumber + 1; i<=n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            numbers.add(i);
            
            dfs(depth + 1, n, numbers, i);
            
            visited[i] = false;
            numbers.remove(numbers.size() - 1);
            
        }
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        
        qtemp = q;
        anstemp = ans;
        
        // System.out.println(ans.length);
        for(int i=0; i<ans.length; i++){
            list.add(new HashMap<>());
        }
        
        for(int i=0; i<q.length; i++){
            for(int j=0; j<q[i].length; j++){
                list.get(i).put(q[i][j], list.get(i).getOrDefault(q[i][j],0) + 1);
            }
        }
        dfs(0, n, new ArrayList<>(), 0);
        return answer;
    }
}