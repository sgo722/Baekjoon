
import java.io.*;
import java.util.*;

public class Main{

    static int[] time = {300, 60, 10};
    static int[] count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        boolean flag = isPossible(n);
        if(flag){
            count = new int[3];
            for(int i=0; i<3; i++){
                int cnt = n/time[i];
                n %= time[i];
                count[i] = cnt;
            }

            for(int i=0; i<3; i++){
                System.out.print(count[i] + " ");
            }
            return;
        }
        System.out.println(-1);


    }

    static boolean isPossible(int t){
        for(int i=0; i<3; i++){
            t %= time[i];
        }
        if(t == 0) return true;
        return false;
    }
}