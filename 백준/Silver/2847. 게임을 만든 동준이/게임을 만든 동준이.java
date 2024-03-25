import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br;
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        input();
        solution();
    }

    static void solution(){
        int cnt = 0;
        if(n == 1){
            System.out.println(cnt);
            return;
        }
        int num = arr[n-1];
        for(int i=n-2; i>=0; i--){
            if(arr[i] >= num){
                cnt = cnt + (arr[i] - num + 1);
                arr[i] = num-1;
            }
            num = arr[i];
        }

        System.out.println(cnt);
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
}