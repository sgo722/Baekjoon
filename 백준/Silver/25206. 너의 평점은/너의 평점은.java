import java.io.*;
import java.util.*;

/**
 * 문제 시작 - 23:27
 * 아이디어 - 입력받고 소수점을 더블로 변환하고 평균을 구하면되지 않을까
*/
public class Main{
	static long[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		double sum = 0;
		double sumHak = 0;
		for(int i=0; i<20; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			double hak = Double.parseDouble(st.nextToken());
			String s = st.nextToken();
			if(s.equals("A+")) {
				sum += hak * 4.5;
			}else if(s.equals("A0")) {
				sum += hak * 4.0;
			}else if(s.equals("B+")) {
				sum += hak * 3.5;
			}else if(s.equals("B0")) {
				sum += hak * 3.0;
			}else if(s.equals("C+")) {
				sum += hak * 2.5;
			}else if(s.equals("C0")) {
				sum += hak * 2.0;
			}else if(s.equals("D+")) {
				sum += hak * 1.5;
			}else if(s.equals("D0")) {
				sum += hak * 1.0;
			}else if(s.equals("F")) {
				sum += hak * 0.0;
			}else if(s.equals("P")) {
				continue;
			}
			sumHak += hak;
		}
		sum /= sumHak;
		System.out.println(sum);
	}
}