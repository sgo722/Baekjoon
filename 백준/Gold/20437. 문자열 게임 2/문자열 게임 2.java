import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
	static int[] str;
	static int[] count;
	static int n;
	static Queue<Integer>[] qList;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		qList = new LinkedList[26];
		
		
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<26; j++) {
				qList[j] = new LinkedList<>();
			}
			int maxLenght = Integer.MIN_VALUE;
			int minLenght = Integer.MAX_VALUE;
			
			count = new int[26];
			String s = br.readLine();
			str = new int[s.length()];
			for(int j=0; j<s.length(); j++) {
				int idx = s.charAt(j) - 'a';
				count[idx]++;
				str[j] = count[idx];
			}
			
			int k = Integer.parseInt(br.readLine());
//			for(int it : str) {
//				System.out.print(it + " ");
//			}
//			System.out.println();
			for(int j=0; j<s.length(); j++) {
				int idx = s.charAt(j) - 'a';
				qList[idx].add(j);
				if(str[j] >= k) {
					int alphabet_idx = qList[idx].poll();
					maxLenght = Math.max(maxLenght, j-alphabet_idx+1);
					minLenght = Math.min(minLenght, j-alphabet_idx+1);
				}
			}
			
			if(maxLenght == Integer.MIN_VALUE && minLenght == Integer.MAX_VALUE) {
				System.out.println(-1);
			}else {
				System.out.println(minLenght + " " + maxLenght);
			}
			
		}
		
	}
}