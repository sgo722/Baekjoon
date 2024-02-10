import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] returnValue = {25,10,5,1};
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            int money = Integer.parseInt(br.readLine());
            for(int j=0; j<4; j++){
                sb.append(money / returnValue[j]).append(" ");
                money %= returnValue[j];
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}