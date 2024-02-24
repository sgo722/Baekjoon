
import java.io.*;
import java.util.*;


public class Main{
    static int ans, n;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(0, arr);

        System.out.println(ans);


    }

    // 상하좌우로 이동하는 로직 만들어준다.
    static void go(int idx, int[][] x){

        if(idx == 5){ // 최대로 얻을 수 있는 블록에 대해서 검사한다.
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    ans = Math.max(ans, x[i][j]);
                }
            }
            return;
        }
        int[][] temp = new int[n][n];
        int[][] temp2 = new int[n][n];
        int[][] temp3 = new int[n][n];
        int[][] temp4 = new int[n][n];

//        print(x);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                temp[i][j] = x[i][j];
            }
        }


        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                temp2[i][j] = temp[j][n-1-i];
            }
        }

        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                temp3[i][j] = temp2[j][n-1-i];
            }
        }

        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                temp4[i][j] = temp3[j][n-1-i];
            }
        }


//        print(temp);


        Left(temp);
        go(idx+1, temp);
        Left(temp2);
        go(idx+1, temp2);
        Left(temp3);
        go(idx+1, temp3);
        Left(temp4);
        go(idx+1, temp4);
    }

    static void print(int[][] temp){
        for(int i=0; i<n; i++){
            for(int j=0; j<n;j++){
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    private static boolean doLeft(int[][] squares) {
        boolean isSum = false;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n - 1; y++) {
                int swapIndex = y + 1;
                while (swapIndex < n - 1 && squares[x][swapIndex] == 0) swapIndex++;
                if (squares[x][y] == squares[x][swapIndex]) {
                    squares[x][y] *= 2;
                    squares[x][swapIndex] = 0;
                    isSum = true;
                }
            }
            int startY = 0;
            while (startY < n - 1) {
                if (squares[x][startY] != 0) {
                    startY++;
                    continue;
                }
                int swapIndex = startY;
                while (swapIndex < n - 1 && squares[x][swapIndex] == 0) swapIndex++;
                squares[x][startY] = squares[x][swapIndex];
                squares[x][swapIndex] = 0;
                startY++;
            }
        }
        return isSum;
    }

    private static void Left(int[][] temp) {
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=j+1; k<n; k++){
                    if(temp[i][k] == 0) continue;
                    if(temp[i][j] == 0 && temp[i][k] != 0){
                        temp[i][j] = temp[i][k];
                        temp[i][k] = 0;
                    }else if(temp[i][j] != 0 && temp[i][j] == temp[i][k]){
                        temp[i][k] = 0;
                        temp[i][j] *= 2;
                        break;
                    }else if(temp[i][j] != 0 && temp[i][j] != temp[i][k]){
                        break;
                    }
                }
            }
        }
    }
}