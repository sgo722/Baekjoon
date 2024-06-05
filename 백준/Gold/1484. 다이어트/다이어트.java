import java.io.*;
import java.util.*;

public class Main{
    static int g;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        g = Integer.parseInt(br.readLine());

        long s = 1;
        long e = 2;

        boolean flag = false;

        while(e < 100_000){
            long ps = s*s;
            long pe = e*e;
            if(pe - ps == g){
                System.out.println(e);
                flag = true;
            }

            if(pe - ps > g){
                s++;
            }else{
                e++;
            }
        }

        if(!flag){
            System.out.println(-1);
        }
    }
}