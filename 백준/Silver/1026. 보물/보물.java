import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


/**
 * 문제 시작 - 23:35
 * 아이디어 
 * B를 재배열 하지 말라고는 했으나, A를 원하는 대로 재배열을 진행하게되면
 * A와 B를 원하는 값을 곱할 수 있게 만들 수 있다.
 * 그렇기 때문에 B의 오름차순과 A의 내림차순을 곱하는 로직을 구현하면 될 것 같다.
 */
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] brr = new int[n];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
			brr[i] = Integer.parseInt(st2.nextToken());
		}
		
		Arrays.sort(arr);
		Arrays.sort(brr);
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			sum += arr[i] * brr[n-1-i];
		}
		
		System.out.println(sum);
	}
}