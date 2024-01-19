import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 문제시작 - 23:20
 * 아이디어 - 
 * 조합 nCr
 * 2xn을 2x1[n개]로 채우는 방법 조합 - nC0
 * 2xn을 2x2[1개]와 2x1[n-2개]로 채우는 방법 n-1C1
 * ...
 * n보다 r이 커지면 종료해야할듯?
 * 문제 구현 - 23:37
 * 구현 완료 - 23:49
 * 답이 피보나치수열처럼 나오는데 왜지? 이럴거면 dp로했지..?
 * 문제점은 조합연산에서 1000부터 시작하면 int형 범위를 금방 넘어가는 문제가 있어서 틀렸다고 나오는 것 같다.
 * 그러면 dp로 구현해보자 - 피보나치수열처럼 나오는 이유에 대해선 더 공부해야봐야할듯
 * index가 1000일때를 포함시키지 않아서 틀렸던것같음.
 */
public class Main{
	static int n, r = 0, ans = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] arr = new int[1004];
		
		arr[1] = 1;
		arr[2] = 2;
		
		for(int i=3; i<=1000; i++) {
			arr[i] = (arr[i-1]%10007) + (arr[i-2]%10007);
			arr[i] %= 10007;
		}
		
		System.out.println(arr[n]);
	}
	
	
}