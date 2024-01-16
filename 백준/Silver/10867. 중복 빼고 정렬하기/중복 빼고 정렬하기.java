import java.io.*;
import java.util.*;

/**
 * 문제 시작 - 00:37
 * 아이디어 : Set을 활용해서 중제거하면 조금 간단해지지 않을
 */
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Set<Integer> set = new HashSet<Integer>();
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(set.contains(num) == true) {
				continue;
			}
			set.add(num);
			count++;
		}
		
		int[] arr = new int[count];
		count = 0;
		for(int it : set) {
			arr[count++] = it;
		}
		
		Arrays.sort(arr);
		
		for(int it : arr) {
			sb.append(it + " ");
		}
		
		System.out.println(sb);
	}
}