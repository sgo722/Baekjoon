import java.util.*;

class Solution {
    /*
    * 500 * 100000 ? 5천만?
    */
    
    static final int MAX_N = 100000;
    
    static ArrayList<Integer>[] points;
    static HashMap<Integer, Integer> map = new HashMap<>();
    
    static int[] visited = new int[MAX_N + 1];
    
    static void init(){
        for(int i=0; i<=MAX_N; i++){
            visited[i] = Integer.MAX_VALUE;
        }
    }
    
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        points = new ArrayList[n+1];
        
        for(int i=0; i<=n; i++){
            points[i] = new ArrayList<>();
        }
        
        for(int i=0; i<roads.length; i++){
            int now = roads[i][0];
            int next = roads[i][1];
            
            points[next].add(now);
            points[now].add(next);
        }
        
        Queue<Integer> q = new LinkedList<>();
        init();
        int cur = destination;
        q.add(cur);
        visited[cur] = 0;
        map.put(cur,0);
        int dist = 0;
        while(q.size() > 0){
            int qSize = q.size();
            dist++;
            for(int size=0; size<qSize; size++){
                int now = q.poll();
                for(int j=0; j<points[now].size(); j++){
                    int next = points[now].get(j);
                    if(visited[next] >= dist){
                        q.add(next);
                        map.put(next, dist);
                        visited[next] = dist;
                    }
                }
            }
        }
            
        for(int i=0; i<sources.length; i++){
            answer[i] = map.getOrDefault(sources[i], -1);
        }
        return answer;
    }
}