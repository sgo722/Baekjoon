import java.io.*;
import java.util.*;

/**
 * 문제 시작 - 11:53
 * 아이디어 -
 * 1개면 상근이가 이긴다.
 * 2개면 창영이가 이긴다.
 * 3개면 상근이가 이긴다
 * 4개면 진다
 * 5개면 이긴다
 * 6개면 진
 * 홀수개면 상근 승
 * 짝수개면 창영 승
 */
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n % 2 == 1) {
			System.out.println("SK");
		}else {
			System.out.println("CY");
		}
	}
}