import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 문제 : 색종이 만들기
 * 시작 - 14:22
 * 아이디어 :
 * 재귀를이용해서 탐색하고 주어진 점으로부터 size만큼의 사각형만큼 검사한다.
 * 사이즈크기에 만족하면 0인지 1인지에 따라서 개수를 올린다.
 * 사이즈 크기에 만족하지 못하면 다음 재귀로 들어간다.
 */


public class Main {
	static int[][] arr;
	static int[] ans = new int[2];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		go(0,0,n);
		
		System.out.println(ans[0] + "\n" + ans[1]);
	}
	
	static void go(int y, int x, int size) {
		if(size == 1) {
			ans[arr[y][x]]++;
			return;
		}
		int color = arr[y][x];
		int cnt = 0;
		for(int i=y; i<y+size; i++) {
			for(int j=x; j<x+size; j++) {
				if(color == arr[i][j]) {
					cnt++;
				}
			}
		}
		
		if(cnt == size * size) {
			ans[color]++;
			return;
		}
		go(y,x,size/2);
		go(y,x+size/2,size/2);
		go(y+size/2,x,size/2);
		go(y+size/2,x+size/2,size/2);
	}
}