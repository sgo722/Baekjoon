import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    static BigInteger a,b;
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
        System.out.println(a.multiply(b));


    }


    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        a = new BigInteger(br.readLine());
        b = new BigInteger(br.readLine());

    }
}