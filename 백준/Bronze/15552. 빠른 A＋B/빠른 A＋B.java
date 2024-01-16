import java.io.*;
import java.util.*;
/**
 * 작성자 : 양준영
 * 메모리 : 13936KB
 * 시간 : 116ms
 * 아이디어 : BufferedReader와 BufferedWriter를 사용한다.
 */
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(a+b+"\n");
			}
		bw.flush();
		bw.close();
		
	}
}
