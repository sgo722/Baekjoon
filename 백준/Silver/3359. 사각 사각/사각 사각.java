import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 3359 사각사각
 */
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[][] sum = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sum[0][0] = arr[0][0];
		sum[0][1] = arr[0][1];
		
		for(int i=1; i<n; i++) {
			sum[i][0] = Math.max(sum[i-1][0] + arr[i][0] + Math.abs(arr[i][1] - arr[i-1][1]), sum[i-1][1] + arr[i][0] + Math.abs(arr[i][1] - arr[i-1][0]));
			sum[i][1] = Math.max(sum[i-1][0] + arr[i][1] + Math.abs(arr[i][0] - arr[i-1][1]), sum[i-1][1] + arr[i][1] + Math.abs(arr[i][0] - arr[i-1][0]));
		}
		// 현재상태 누워있음 = 전꺼 누워있음 + 현재 너비 + (현재 높이 - 전 높이) , 전꺼 서있음  + 현재 너비 + (현재 높이 - 전 너비)
		// 현재상태 서있음 = 전꺼 누워있음 + 현재 높이 + (현재 너비 - 전 높이) , 전꺼 서있음  + 현재 높이 + (현재 너비 - 전 너비)
		
		

		System.out.println(Math.max(sum[n-1][0],sum[n-1][1]));
	}
}