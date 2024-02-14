import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static BufferedReader br;

    static int[][] arr;

    static int n;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        init();

        System.out.println(go(0,0,n));

    }


    private static String go(int y, int x, int size){
        if(size == 1){
            return String.valueOf(arr[y][x]);
        }

        String s = "";
        int flag = arr[y][x];
        for(int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                if(arr[i][j] != flag){
                    s += "(";
                    s += go(y,x,size/2);
                    s += go(y,x+size/2,size/2);
                    s += go(y+size/2,x,size/2);
                    s += go(y+size/2,x+size/2,size/2);
                    s += ")";
                    return s;
                }
            }
        }
        return String.valueOf(arr[y][x]);
    }
    private static void init() throws IOException{
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }

    }
}