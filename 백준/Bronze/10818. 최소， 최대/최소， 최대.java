import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+4];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int minNum = 987654321;
		int maxNum = -987654321;
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num < minNum) {
				minNum = num;
			}
			if(num > maxNum) {
				maxNum= num;
			}
		}
		System.out.println(minNum + " " + maxNum);
	}
}