import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int count = 0;
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		int value = Integer.parseInt(st2.nextToken());
		for(int i=0; i<N; i++) {
			if(arr[i] == value) {
				count++;
			}
		}
		
		System.out.println(count);
		br.close();
		bw.flush();
		bw.close();
		
	}
}