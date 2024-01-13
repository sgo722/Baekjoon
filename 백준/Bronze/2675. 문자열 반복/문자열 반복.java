import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// BufferedReader + StringBuilder + split
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			StringBuilder sb = new StringBuilder();
			for(byte it : str[1].getBytes()) {
				for(int k=0; k<a; k++) {
					sb.append((char)(it));
				}
			}
			System.out.println(sb);
		}
	}
}