import java.io.*;

/**
 * 작성자 : 양준영
 * 아이디어 :
 * 6과 9를 제외한 수중에서 가장 많이 필요로 하는경우와 6과 9를 합치고 /2로 나눈 경우중 더 큰 값을 출력한다.
 */
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] v = new int[10];
		char[] arr = br.readLine().toCharArray();
		for(char ch : arr) {
			v[ch-'0']++;
		}
		int ans = 0;
		for(int i=0; i<10; i++) {
			if(i == 6 || i == 9) continue;
			ans = Math.max(ans,v[i]);
		}
		if((v[6]+v[9]) % 2 == 0) {
			ans = Math.max(ans, (v[6]+v[9]) / 2);
		}else {
			ans = Math.max(ans,(v[6]+v[9])/2+1);
		}
		
		System.out.println(ans);
	
	}
}