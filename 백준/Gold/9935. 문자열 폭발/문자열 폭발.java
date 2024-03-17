import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static Stack<Character> stk;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        stk = new Stack<>();
        sb = new StringBuilder();
        br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String x = br.readLine();
        String m = "";
        for (int i = 0; i < s.length(); i++) {
            stk.push(s.charAt(i));

            if (stk.size() >= x.length()) {
                boolean flag = true;
                for (int j = 0; j < x.length(); j++) {
                    if (stk.get(stk.size() - x.length() + j) != x.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < x.length(); j++) {
                        stk.pop();
                    }
                }
            }
        }

        for(char ch : stk){
            sb.append(ch);
        }

        System.out.println(sb.length() > 0 ? sb : "FRULA");
    }
}