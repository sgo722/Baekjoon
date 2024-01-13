import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		if(a % 4 == 0) {
			if(a % 400 == 0){
				System.out.println(1);
			}
			else if(a % 100 == 0) {
				System.out.println(0);
			}
			else {
				System.out.println(1);
			}
		}
		else {
			System.out.println(0);
		}
	}
}