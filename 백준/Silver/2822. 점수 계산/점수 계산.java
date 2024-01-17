import java.io.*;
import java.util.*;

/**
 * 문제 시작 - 20:47
 * 아이디어 - 높은 점수 5개를 골라내고, 처음 인덱스를 출력한다.
 * 아이디어 1 - 원본배열은 두고, 정렬한 배열을 만든다. 그리고 5번 스캔하면서 해당되는 인덱스를 출력한다.
 * -> 시간제한 상 풀리긴 하겠지만, 더 효율적인 코드가 있을 것 같다.
 */
public class Main{
	public static void main(String[] args) throws IOException{
		
		int[] arr = new int[8];
		int[] arr2 = new int[8];
		int[] cnt = new int[5];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		for(int i=0; i<8; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[i] = n;
			arr2[i] = n;
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<8; j++) {
				if(arr[7-i] == arr2[j]) {
					sum += arr2[j];
					cnt[i] = j+1;
					break;
				}
			}
		}
		Arrays.sort(cnt);
		System.out.println(sum);
		for(int i=0; i<5; i++) {
			System.out.print(cnt[i] + " ");
		}
	}
}