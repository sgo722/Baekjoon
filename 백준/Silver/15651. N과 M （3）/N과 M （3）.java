import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
/**
 * 문제시작 - 22:00
 * 아이디어 - 이전 문제들과 비슷했다.
 * idx조절만 하면 되었다.
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
		
		for(int i=1; i<=n; i++) {
			arr[size] = i;
			go(i, size+1);
		}
	}
}

