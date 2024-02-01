import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class Main{
    static int n;
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i=2; i<=9; i++){
            if(checkSosu(i)) go(i,1);
        }

        System.out.println(ans);
    }

    static void go(int prevNum, int len){
        if(len == n) {
            ans.append(prevNum).append("\n");
            return;
        }

        for(int i=0; i<10; i++){
            int num = prevNum * 10 + i;
            if(checkSosu(num)) go(num, len+1);
        }
    }

    static boolean checkSosu(int num){
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

}