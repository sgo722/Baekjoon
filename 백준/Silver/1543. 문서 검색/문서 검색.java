import java.io.*;
import java.util.*;

/**
 * 문제 시작 - 20:30
 * 문자열 길이가 같은 경우의 검사에서 틀리고 있던 것 같음
 */
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = br.readLine().toCharArray();
		char[] word = br.readLine().toCharArray();
		int cnt = 0;
		for(int i=0; i<=chars.length-word.length; i++) {
			int flag = 0;
			for(int j=0; j<word.length; j++) {
				if(chars[i+j] != word[j]) {
					flag = 1;
					break;
				}
			}
			if(flag==0) {
				cnt++;
				i = i + word.length - 1;
			}
		}
		System.out.println(cnt);
	}
}