import java.io.*;
import java.util.*;

public class Main {

	static class Tree{
		long height;
		int count;
		public Tree(long height, int count) {
			super();
			this.height = height;
			this.count = count;
		}
		
		
	}
	static Stack<Tree> stk = new Stack<>();
	static long[] height;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		height = new long[n];

		long maxH = 0;
		long sum = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			long b = Integer.parseInt(st.nextToken());
			if (a == 1) { // 통나무 설치
				stk.push(new Tree(b,1));
				if(maxH < b) {
					maxH = b;
				}
			} else if (a == 2) { // 통나무 제거
				if (stk.size() > 0) {
					maxH = Math.max(maxH - b, 0);
					long h = maxH;
					int cnt = 0;
					while (stk.size() > 0 && stk.peek().height > h) {
						Tree tree = stk.pop();
						cnt += tree.count;
					}
					
					stk.push(new Tree(h, cnt));
				}
			}
//			System.out.println(stk);
		}

		
		while(stk.size() > 0) {
			Tree tree =  stk.pop();
			sum = sum + (tree.count * tree.height);
		}
		
		System.out.println(sum);
	}

}

/**
 * 우선순위 큐에 idx와 height를 저장하고 height로 정렬한다. height가 높은 순서대로 해당 idx의 height를 줄여준다.
 * 그리고 처음 입력된 것부터
 * 
 * 가장 긴 통나무 k를 기준으로 max(k-m,0)이상인 통나무들의 길이를 max(k-m,0)으로 만들어버린다. k-m 이상이고 k 이하인
 * 통나무들 다들 k-m의 높이가된다.
 * 
 * 
 * k-m보다 큰 값들은 다 pop하고 k-m을 넣으면 되겟네
 *
 * 하나씩 팝하고 푸시하면 틀린다.
 */
