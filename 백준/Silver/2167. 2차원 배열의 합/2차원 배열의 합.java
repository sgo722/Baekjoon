import java.io.*;
import java.util.*;

/**
 * 문제 시작 - 12:10
 * 아이디어 - 입력받고 배열을 만든 후, 범위에 포함되는 값들을 더한다.
 */
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		n = Integer.parseInt(br.readLine());
		for(int t=0; t<n; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			i--;
			j--;
			y--;
			x--;
			int sum = 0;
			for(int r=i; r<=y; r++) {
				for(int c=j; c<=x; c++) {
					sum += arr[r][c];
				}
			}
			
			System.out.println(sum);
		}
	}
}