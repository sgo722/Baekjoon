import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 : 감시
 * 아이디어) 백트래킹
 * @author SSAFY
 *
 */
public class Main{

    static int n,m;
    static char[] ret, ch;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ret = new char[n];
        ch = new char[m];
        for(int i=0; i<m; i++) {
            ch[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(ch);

        go(0, 0, 1, 2);

        System.out.print(sb);
    }

    static void go(int idx, int cnt, int mo, int ja){
        if(cnt == n){
            if(ja <= 0 && mo <= 0) {
                for (int i = 0; i < n; i++) {
                    sb.append(ret[i]);
                }
                sb.append("\n");

                return;
            }
            return;
        }

        for(int i = idx; i<m; i++){
            ret[cnt] = ch[i];
            if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u') {
                go(i + 1, cnt + 1, mo - 1, ja);
            }else{
                go(i + 1, cnt + 1, mo, ja-1);
            }

        }
    }
}