import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 시작 - 23:04
 * 아이디어 :
 * 큰 동전부터 시작해서 나눠지면 몫은 더하고 나머지값을 다음 순서의 동전에게 넘긴다.
 * -> 시간제한은 1초 1억의 연산이 가능하고, 동정늬 개수는 1<=N<=10이기 때문에 반복문이 10회기이때문에 시간은 여유있다고 생각함.
 */
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		int[][] arr = new int[n][2];
		
		for(int i=0; i<n; i++) {
			arr[i][0] = Integer.parseInt(br.readLine());
		}
		
		for(int i=n-1; i>=0; i--) {
			arr[i][1] = k / arr[i][0];
			k %= arr[i][0];
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			ans += arr[i][1];
		}
		
		System.out.println(ans);
	}
}