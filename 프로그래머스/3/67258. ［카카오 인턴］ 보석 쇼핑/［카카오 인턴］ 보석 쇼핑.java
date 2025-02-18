import java.util.*;

class Solution {
    
    static HashMap<String, Integer> map = new HashMap<>();
    static HashSet<String> set = new HashSet<>();
    static HashSet<String> count = new HashSet<>();
    
    public int[] solution(String[] gems) {
        int[] answer = {0,0};
        int n = gems.length;
        for(int i=0; i<n; i++){
            count.add(gems[i]);
        }
        
        int goalCount = count.size();
        
        int j=-1;
        int minLen = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++){
            while(j+1 <= n-1 && set.size() != goalCount){
                map.put(gems[j+1], map.getOrDefault(gems[j+1],0) + 1);
                set.add(gems[j+1]);
                j++;
            }
            
            if(set.size() == goalCount){
                if(minLen > j-i+1){
                    minLen = j-i+1;
                    answer[0] = i+1;
                    answer[1] = j+1;
                }
            }
            
            map.put(gems[i], map.getOrDefault(gems[i],0) - 1);
            
            if(map.get(gems[i]) == 0){
                set.remove(gems[i]);
            }
            
        }
        return answer;
    }
}