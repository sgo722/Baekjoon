import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// BufferedReader + StringBuilder
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			String s = st.nextToken();
			for(int j=0; j<s.length(); j++) {
				for(int k=0; k<a; k++) {
					sb.append(s.charAt(j));
				}
			}
			System.out.println(sb);
		}
	}
}