import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제시작 - 23:30
 * 아이디어
 * 값 두개와 연산자 하나의 결과를 다음 dfs문에 넘긴다.
 * n번째 숫자는 N번쨰 연산자를 통해서 n+1번째 숫자와 결합된다.
 * 숫자만 분리하는것은 StringTokenizer로 할수있겠지만, 연산자만 어떻게 따로 분리해낼 수 있을지 모르곘다.
 * toCharArray를 통해서 -부호와 +부호를 분리해내야겠다.
 * 순서대로 연산하는 경우
 * 뒤에 값을 먼저 연산하는 경우
 * 
 * 아 모르겠다 하루종일 고민했느데 못풀겠음.
 * 더하기연산부터 생각하고 빼면 최솟값이 나오는구나..
 */
//
//public class Main{
//	public static final int MAX_N = 987654321;
//	public static ArrayList<Integer> arr;
//	public static ArrayList<Character> op;
//	public static int ans = MAX_N;
//	
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String s = br.readLine();
//		StringTokenizer st = new StringTokenizer(s, "+-");
//		
//		arr = new ArrayList<>();
//		op = new ArrayList<>();
//
//		for(char ch : s.toCharArray()) {
//			if(ch == '+' || ch == '-') {
//				op.add(ch);
//			}
//		}
////		System.out.println(op.size());
//		
//		
//		while(st.hasMoreTokens()) {
//			arr.add(Integer.parseInt(st.nextToken()));
//		}
//		go(0,0);
//		
//		System.out.println(ans);
//	}
//	
//	public static void go(int idx, int sum) {
//		if(idx == arr.size()) {
//			ans = Math.min(ans,sum);
//			return;
//		}
//		if(op.get(idx) == '+') {
//			System.out.println("+ : " + idx);
//			go(idx+1, sum + arr.get(idx));
//			if(idx+2 < arr.size()) {
//				if(op.get(idx+1) == '+') {
//					go(idx+2, sum + (arr.get(idx)+ arr.get(idx+1)));
//				}
//				if(op.get(idx+1) == '-') {
//					go(idx+2, sum + (arr.get(idx) - arr.get(idx+1)));
//				}
//			}
//		}else {
//			System.out.println("- : " + idx);
//			go(idx+1, sum - arr.get(idx));
//			if(idx+2 < arr.size()) {
//				if(op.get(idx+1) == '+') {
//					go(idx+2, sum - (arr.get(idx) + arr.get(idx+1)));
//				}
//				if(op.get(idx+1) == '-') {
//					go(idx+2, sum - (arr.get(idx) - arr.get(idx+1)));
//				}
//			}
//		}
//	}
//}

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		
		while(st.hasMoreTokens()) {
			int temp = 0;
			
			StringTokenizer addition = new StringTokenizer(st.nextToken(), "+");
			
			while(addition.hasMoreTokens()) {
				temp += Integer.parseInt(addition.nextToken());
			}
			
			if(sum == Integer.MAX_VALUE) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		System.out.println(sum);
	}
}