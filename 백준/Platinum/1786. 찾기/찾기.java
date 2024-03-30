import java.io.*;
import java.util.*;


public class Main{

    static String text, pattern;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        input();
        kmp();
    }

    static void kmp(){
        int cnt = 0;
        int[] fail = mkfail();
        int text_size = text.length();
        int pattern_size = pattern.length();

        int idx = 0;
        for(int i=0; i<text_size; i++){
            while(idx > 0 && text.charAt(i) != pattern.charAt(idx)) idx = fail[idx - 1];
            if(text.charAt(i) == pattern.charAt(idx)) {
                if (idx == pattern_size - 1) {
                    sb.append(i - idx + 1 + " ");
                    cnt++;
                    idx = fail[idx];
                } else{
                    idx++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }

    static int[] mkfail(){
        int[] fail = new int[pattern.length()];

        int idx=0;
        for(int i=1; i<pattern.length(); i++){
            while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) idx = fail[idx-1];
            if(pattern.charAt(i) == pattern.charAt(idx)) fail[i] = ++idx;
        }

        return fail;
    }

    static void print(int[] arr){
        for(int it : arr){
            System.out.print(it + " ");
        }
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        text = br.readLine();
        pattern = br.readLine();
    }
}