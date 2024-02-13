import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static class Node{
        int y;
        int x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static int[][] map;
    static ArrayList<Node> nothing = new ArrayList<>();
    static ArrayList<Node> students = new ArrayList<>();

    static ArrayList<Node> teachers = new ArrayList<>();


    static int[][] visited;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};

    static int flag = 0;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new int[n][n];
        visited = new int[n][n];

        for(int i=0; i<n; i++){

            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                String s = st.nextToken();
                if(s.equals("S")){  // 학생
                    map[i][j] = 1;
                    students.add(new Node(i,j));
                }else if(s.equals("T")){ // 선생
                    map[i][j] = 2;
                    teachers.add(new Node(i,j));
                }else if(s.equals("X")){ // 벽돌 위치
                    map[i][j] = 0;
                    nothing.add(new Node(i,j));
                }
            }
        }
        int size = nothing.size();

        for(int i=0; i<size-2; i++){
            for(int j=i+1; j<size-1; j++){
                for(int k=j+1; k<size; k++){
                    map[nothing.get(i).y][nothing.get(i).x] = 3;
                    map[nothing.get(j).y][nothing.get(j).x] = 3;
                    map[nothing.get(k).y][nothing.get(k).x] = 3;
                    if(go()){
                        System.out.println("YES");
                        return;
                    }
                    map[nothing.get(i).y][nothing.get(i).x] = 0;
                    map[nothing.get(j).y][nothing.get(j).x] = 0;
                    map[nothing.get(k).y][nothing.get(k).x] = 0;
                }
            }
        }

        System.out.println("NO");
    }

    static boolean go(){

        for(int i=0; i<students.size(); i++){
            int y = students.get(i).y;
            int x = students.get(i).x;
            int dir = 0;
            while(dir != 4){
                int sy = y;
                int sx = x;
                while(true){
                    int ny = sy + dy[dir];
                    int nx = sx + dx[dir];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= n || map[ny][nx] == 3) break;
                    if(map[ny][nx] == 2) return false;
                    sy = ny;
                    sx = nx;
                }
                dir++;
            }
        }
        return true;
    }
}