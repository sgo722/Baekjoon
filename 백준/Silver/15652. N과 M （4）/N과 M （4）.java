import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
/**
 * 문제시작 - 22:00
 * 아이디어 - 이전 문제들과 비슷해서
 * 그냥 visited생각안하고 사이즈만 맞으면 출력하면 될 것 같은데
 * 이런 경우는 String객체를 만들순있어보이는데, StringBuilder는 어떻게 사용해야할지 모르겠다.
 */

public class Main{
	static int n, m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = i;
		}
		
		go(1, "", 0);
	}
	
	public static void go(int idx, String s, int size) {
		if(size == m) {
			System.out.println(s);
			return;
		}
		
		for(int i=idx; i<=n; i++) {
			go(i,s+i+" ", size+1);
		}
	}
}