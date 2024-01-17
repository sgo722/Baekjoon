import java.io.*;
import java.util.*;

/**
 * 문제 시작 - 20:47
 * 아이디어 - 높은 점수 5개를 골라내고, 처음 인덱스를 출력한다.
 * 아이디어2 - 2차원 배열을 이용한다. 
 */
public class Main{
	public static void main(String[] args) throws IOException{
		
		int[][] arr = new int [8][2];
		int[] ret = new int [5];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for(int i=0; i<8; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[i][0] = n;
			arr[i][1] = i+1;
		}
		
		for(int i=0; i<5; i++) {
			
		}
		Arrays.sort(arr,(int[] a, int[] b) -> {
			return b[0] - a[0];
		});
		
		for(int i=0; i<5; i++) {
			sum += arr[i][0];
			ret[i] = arr[i][1];
		}
		Arrays.sort(ret);
		System.out.println(sum);
		for(int i=0; i<5; i++) {
			System.out.print(ret[i] + " ");
		}
	}
}