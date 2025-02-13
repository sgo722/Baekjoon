import java.util.*;

class Solution {
    static class Pair implements Comparable<Pair>{
        int idx;
        int a;
        int b;
        
        public Pair(int idx, int a, int b){
            this.idx = idx;
            this.a = a;
            this.b = b;
        }
        
        @Override
        public int compareTo(Pair p){
            if(this.a == p.a){
                return this.b - p.b;
            }
            return p.a - this.a;
        }
    }
    static class Tuple implements Comparable<Tuple>{
        int idx;
        int sum;
        
        public Tuple(int idx, int sum){
            this.idx = idx;
            this.sum = sum;
        }
        
        @Override
        public int compareTo(Tuple p){
            if(p.sum == this.sum){
                return this.idx - p.idx;
            }
            return p.sum - this.sum;
        }
    }
    
    static PriorityQueue<Pair> pq1 = new PriorityQueue<>();
    static PriorityQueue<Tuple> pq2 = new PriorityQueue<>();
    
    static ArrayList<Pair> list = new ArrayList<>();
    static boolean[] visited = new boolean[100001];
    
    public int solution(int[][] scores) {
        int answer = 0;
        int n = scores.length;
        for(int i=0; i<n; i++){
            int a = scores[i][0];
            int b = scores[i][1];
            list.add(new Pair(i,a,b));
            pq1.add(new Pair(i,a,b));
        }
        
        Pair kill = pq1.poll();
        int a = kill.a;
        int b = kill.b;
        int killIdx = kill.idx;
        
        while(pq1.size() > 0){
            Pair now = pq1.poll();
            int nowIdx = now.idx;
            int nowA = now.a;
            int nowB = now.b;
            if(b < nowB){
                b = nowB;
            }else if(a > nowA && b > nowB){
                visited[nowIdx] = true;
                if(nowIdx == 0) return -1;
            }
        }
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                pq2.add(new Tuple(list.get(i).idx, list.get(i).a + list.get(i).b));
            }
        }
        
        int count = 1;
        while(pq2.size() > 0){
            Tuple now = pq2.poll();
            int idx = now.idx;
            int sum = now.sum;
            
            if(idx == 0){
                return count;
            }
            
            int sameCount = 0;
            while(pq2.size() > 0 && pq2.peek().sum == sum){
                sameCount++;
                int nextIdx = pq2.poll().idx;
            }
            count = count + sameCount + 1;
        }
        
        
        return -1;
    }
}