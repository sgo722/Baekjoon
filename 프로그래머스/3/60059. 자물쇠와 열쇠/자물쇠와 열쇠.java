class Solution {
    
    static void printMap(int[][] map, int size){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    static boolean check(int x, int y, int[][] key, int[][] lock){
        
        for(int i=x; i<n+x; i++){
            for(int j=y; j<n+y; j++){
                if(i < 0 || j < 0 || i >= m || j >= m) continue;
                if(i-x < 0 || j-y < 0 || i-x >= n || j-y >= n) continue;
                if(lock[i][j] == 1 && key[i-x][j-y] == 1) return false;
                if(lock[i][j] == 0 && key[i-x][j-y] == 0) return false;
            }
        }
        
        return true;
    }
    
    static boolean isPossible(int x, int y, int[][] key, int[][] lock){
        
        int[][] temp = new int[m][m];
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                temp[i][j] = lock[i][j];
            }
        }
        
        for(int i=x; i<n+x; i++){
            for(int j=y; j<n+y; j++){
                if(i < 0 || j < 0 || i >= m || j >= m) continue;
                if(i-x < 0 || j-y < 0 || i-x >= m || j-y >= n){
                    // if(i==1 && j ==2) System.out.println(i + " " + j + " " + (i-x) + " " + (j-y));
                    continue;
                }
                if(temp[i][j] == 0){
                    temp[i][j] = key[i-x][j-y];
                    // System.out.println(i + " " + j);
                }
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                
                if(temp[i][j] == 0){
                    // printMap(temp,m);
                    // System.out.println(i + " " + j);
                    return false;
                }
            }
        }
        
        return true;
    }
                
    static int n, m;
                
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;;
        n = key.length;
        m = lock.length;
        int[][] temp = new int[n][n];
        
        for(int rotate=0; rotate<4; rotate++){
            
            for(int i=-n+1; i<m; i++){
                for(int j=-n+1; j<m; j++){
                    if(check(i,j,key,lock)){
                        if(isPossible(i,j,key,lock)){
                            answer = true;
                        }
                    }
                }
            }
            
            if(answer == true) break;

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    temp[i][j] = key[j][n-1-i];
                }
            }
            
            

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    key[i][j] = temp[i][j];
                }
            }
        }
        
        return answer;
    }
}