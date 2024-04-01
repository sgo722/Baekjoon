import java.io.*;
import java.util.*;

public class Main{
	
	
	static int n, num;
	static int[] a, lis;
	static int ans;
	public static void main(String[] args) throws IOException{
		input();
		go();
	}
	
	
	static void go() {
		
		for(int i=1; i<=n; i++) {
			lis[i] = 1;
			for(int j=1; j<=i; j++) {
				if(a[i] > a[j]) {
					lis[i] = Math.max(lis[i], lis[j]+1);
				}
			}
			
			ans = Math.max(ans, lis[i]);
		}
		
		System.out.println(n-ans);
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n+1];
		lis = new int[n+1];
		ans = Integer.MIN_VALUE;
		
		for(int i=1; i<=n; i++) {
			num = Integer.parseInt(br.readLine());
			a[i] = num;
		}
	}
}