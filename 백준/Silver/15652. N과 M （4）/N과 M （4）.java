import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
/**
 * 문제시작 - 22:00
 * 아이디어 - 이전 문제들과 비슷해서
 * 그냥 visited생각안하고 사이즈만 맞으면 출력하면 될 것 같은데
 * 이런 경우는 String객체를 만들순있어보이는데, StringBuilder는 어떻게 사용해야할지 모르겠다.
 * 
 * 답확인) StringBuilder배열을 가지고 만들수 있다.
 */

public class Main{
	static int[] arr;
	static int n, m;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m];
		
		go(1, 0);
		
		System.out.println(sb);
	}
	
	public static void go(int idx, int size) {
		if(size == m) {
			for(int i : arr) {
				sb.append(i).append(' ');
			}
			sb.append("\n");
			return;
		}
		
		for(int i=idx; i<=n; i++) {
			arr[size] = i;
			go(i, size+1);
		}
	}
}

