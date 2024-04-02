import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{
	static final int MOD = 1000000;
	static long[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BigInteger n = new BigInteger(br.readLine());
		int pisano = 15 * 10 * (MOD/10);
		long n = Long.parseLong(br.readLine()) % pisano;
		arr = new long[pisano+1];
		
		arr[1] = 1;
		for(int i=2; i<=n; i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % MOD;
		}
		
		System.out.println(arr[(int)n]);
		
	}
}