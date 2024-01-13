import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] arr = new int[30];
		for(int i=0; i<26; i++) {
			arr[i] = -1;
		}
		for(int i=0; i<str.length(); i++) {
			int idx = str.charAt(i) - 'a';
			if(arr[idx] == -1){
				arr[str.charAt(i)-'a'] = i;
			}
		}
		
		for(int i=0; i<26; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}