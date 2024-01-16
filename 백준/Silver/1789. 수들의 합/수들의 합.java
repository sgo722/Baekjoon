import java.io.*;

/**
 * 문제 시작 - 22:37
 * 아이디어 - 무조건 1부터 더해나가야하지않을까?
*/
public class Main{
	static long[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long cnt = 0;
		for(long i=1; i<=n; i++) {
			if(2*i +1 <= n && 3*i+2 > n) {
				cnt+=2;
				break;
			}
			n-=i;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}