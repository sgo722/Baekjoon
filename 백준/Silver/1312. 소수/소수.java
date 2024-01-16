import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
/**
 * 문제 시작 - 16:30
 * A B C값이 주어지는데
 * A를 B로 나누고, 소수점 C번째 숫자를 출력하라.
 * 아이디어 :
 * 소수점 출력한다.
 */
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		a%=b;
		for(int i=0; i<n-1; i++) {
			a *= 10;
			a %= b;
		}
		a*=10;
		
		System.out.println(a/b);
	}

}
