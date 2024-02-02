import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

    static int[] alphabet, check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        alphabet = new int[26];
        check = new int[4];
        String input = br.readLine();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<4; i++){
            check[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int l = 0;
        int r = p-1;
        for(int i=l; i<=r; i++){
            alphabet[input.charAt(i) - 'A']++;
        }

        while(true) {
            if(check[0] <= alphabet[0] && check[1] <= alphabet[2] && check[2] <= alphabet[6] && check[3] <= alphabet[19]){
                cnt++;
            }
            alphabet[input.charAt(l) - 'A']--;
            l++;
            r++;
            if(r == s) break;
            alphabet[input.charAt(r) - 'A']++;
        }
        System.out.println(cnt);
    }
}