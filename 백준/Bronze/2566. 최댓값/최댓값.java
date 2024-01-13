import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		int[][] a = new int[9][9];
		int y = 0;
		int x = 0;
		int maxNum = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int r=0; r<9; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for(int c=0; c<9; c++) {
				int num = Integer.parseInt(st.nextToken());
				a[r][c] = num;
				if(num > maxNum) {
					maxNum = num;
					y = r;
					x = c;
				}
			}
		}
		System.out.println(maxNum);
		System.out.println((y+1) + " " + (x+1));
	}
}