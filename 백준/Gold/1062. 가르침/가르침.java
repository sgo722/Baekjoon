import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int[] words;
    static int n, m, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = -1;

        words = new int[n];
        for(int i=0; i<n; i++){
            int sum = 0;
            char[] chars = br.readLine().toCharArray();
            for(int j=0; j<chars.length; j++){
                sum |= (1 << (chars[j] - 'a'));
            }
            words[i] = sum;
        }

        if(m < 5){
            System.out.println(0);
            return;
        }
        go(0, 0, 0);

        System.out.println(ans);
    }

    static void go(int learn, int count, int word){
        if(count == m || word == 26){
            int ret = 0;
            for(int i=0; i<n; i++){
                if((words[i] & learn) == words[i]){ // 배운 단어라면
                    ret++;
                }
            }
            ans = Math.max(ans, ret);
            return;
        }

        if(word == 0 || word == 2 || word == 8 || word == 13 || word == 19){
            go(learn | (1<<word), count+1, word+1); // a n t i c 면 배운다.
        }
        else{ // 아니라면
            go(learn | (1<<word), count+1, word+1); // 배우거나
            go(learn, count, word+1); // 배우지 않는다.
        }
    }
}