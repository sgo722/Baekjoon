import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
/**
 * Deque를 사용하면 쉽게 풀릴 것 같다.
 */
public class Main {
	static Deque<Integer> dq = new ArrayDeque<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for(int i=n; i>=1; i--) {
			dq.addLast(i);
		}
		
		while(true) {
			sb.append(dq.pollLast() + " ");
			if(dq.size() == 0) break;
			dq.addFirst(dq.pollLast());
		}
		
		System.out.println(sb);
	}
}
