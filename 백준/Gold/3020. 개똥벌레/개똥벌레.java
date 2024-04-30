import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.text.html.MinimalHTMLWriter;

public class Main {
	
	static int[] upHeight, downHeight;
	
	static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int maxH = Integer.parseInt(st.nextToken());
		upHeight = new int[maxH+1];
		downHeight = new int[maxH+1];
		
		for(int i=1; i<=n; i++) {
			int height = Integer.parseInt(br.readLine());
			
			if(i%2 == 1) { // 짝수인경우
				upHeight[height]++;
			}else { // 홀수인경우
				downHeight[maxH-height+1]++;
			}
		}
		
		
		for(int i=1; i<=maxH; i++) {
			downHeight[i] += downHeight[i-1];
		}
		
		for(int i=maxH; i>=1; i--) {
			upHeight[i-1] += upHeight[i];
		}
		
		int curMin = Integer.MAX_VALUE;
		for(int i=1; i<=maxH; i++) {
			int sum = upHeight[i] + downHeight[i];
//			System.out.println(sum);
			if(sum < curMin) {
				curMin = sum;
				list = new ArrayList<>();
				list.add(i);
			}else if(sum == curMin) {
				list.add(i);
			}
		}
		
		System.out.println(curMin +" " + list.size());
				
	}

}
