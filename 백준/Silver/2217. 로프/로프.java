import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 문제 시작 - 23 : 51
 * 문제이해)
 * 최대 중량을 구하는 것이 문제인데, 각 버틸수있는 중량이 주어진다. k개의 로프로 병합해서 들수도 있다.
 * k개의 로프로 병합해서 들어올때 무개를 n이라하면 각 로프에서 n/k만큼 중량이 걸린다.
 * 일단 각 로프가 들어올릴 수 있는 최대값을 구할 것 같다.
 * 그리고 n개의 로프로 들어올릴 수 있는 최대 값을 업데이트한다.
 * 아이디어)
 * 1. N이 10만이라서 조합으로 문제를 해결하려고하면 시간초과가 발생할 것 같다.
 * 2. 오름차순으로 정렬하면 현재 무게 * 뒤에 남아있는 로프수를 곱해주면 현재 로프을 포함한 가장 많이 들수 잇는 무게를 계산할 수 있다.
 *	시간초과문제도 없어보인다고 생각한다 -> 2초인데 10만번밖에 안돌기때문에 넉넉하다.
 */
public class Main{
	static int ans = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		for(int i=0; i<n; i++) {
			ans = Math.max(ans, arr[i] * (n-i));
		}
		
		System.out.println(ans);
	}
}