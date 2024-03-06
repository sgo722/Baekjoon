import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    static String strLeft, strRight;
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(check());
    }


    static int check(){
        int count =0;
        if(strLeft.length() == strRight.length()){
            for(int i=0; i<strLeft.length(); i++){
                if(strLeft.charAt(i) != strRight.charAt(i)){
                    break;
                } else{
                    if(strLeft.charAt(i) == '8'){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        strLeft = st.nextToken();
        strRight = st.nextToken();
    }
}