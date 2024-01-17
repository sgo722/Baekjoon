import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] brr = new int[m][k];
		int[][] sum = new int[n][k];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<k; j++) {
				brr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<k; j++) {
				for(int temp=0; temp<m; temp++) {
					sum[i][j] += arr[i][temp] *  brr[temp][j];
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<k; j++) {
				sb.append(sum[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
		
	}

}
