import java.io.*;
import java.util.*;

/**
 * 문제 시작 - 00:25
 * 아이디어 -
 * 배열 크기 입력받고, 큰 배열을 만든 후 추가로 넣고 정렬한다.
 * 구현 완료 - 00:32
 * StringBuilder를 쓰면 시간초과에서 벗어날 수 있다.
 */
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int aSize = Integer.parseInt(st.nextToken());
		int bSize = Integer.parseInt(st.nextToken());
		int[] arr = new int[aSize+bSize];
		st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;
		for(int i=0; i<aSize; i++) {
			arr[cnt++] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<bSize; i++) {
			arr[cnt++] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int it : arr) {
			sb.append(it + " ");
		}
		System.out.println(sb);
		
	}
}