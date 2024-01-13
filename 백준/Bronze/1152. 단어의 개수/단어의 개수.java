import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().trim().split(" ");
		int count = 0;
		for(String it : str) {
			if(it == "") continue;
			count++;
		}
		System.out.println(count);
	}
}