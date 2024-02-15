import java.io.*;
import java.util.*;

/**
 * 문제 - 탑
 * 문제 이해)
 * 여러개의 탑이 나열되어있고, 오른쪽 방향부터 왼쪽방향으로 레이저를 쏘게된다.
 * 나보다 큰 탑이 내 레이저를 받을 수 있는데, 이렇게 누가 내 레이저를 받을 수 있는지 적는 것이다.
 * 레이저를 받아줄 탑이 없다면 0이고, 있다면 그 순서(인덱스+1)를 출력하면된다.
 * 아이디어)
 * 뒤에서부터 훑는 것은 O(N^2 + .. 1^2)이고, N은 50만이기때문에 25 * 10^10이므로 터지게된다.
 * 2500억 연산 + a이기 때문에 문제가 발생한다.
 * 그래서 한번에 훑어서 해결할 수 있는 방법으로 큐나 스택을 생각해야한다.
 * 
 * 나보다 큰놈이 있을때 인덱스를 저장한다?
 * 6 9 5 7 4라고 보았을때 4의 레이저를 쏘면 7이 받을 수 있다.
 * 스택을 생각해보고 있는데,
 * 맨앞은 무조건 0이고, 6이 9보다 작기때문에, 9도 스택에 들어오게 된다.
 * 지금 탑이 나보다 작으면 내가 줄 선다. 탑이 나보다 크면? 넣지않는다..? 그걸 바라본다?
 * 이렇게하면 7을 바라봐야하는데 9를 바라보게된다.
 * 
 * 4
 * 7
 * 5
 * 9
 * 6
 * 6 9 5 7
 * 1. 앞부터하는 방식[실패]
 * => 7이 들어오게하면서 4가 바라볼 수 있게 만드는 방법이 있을까
 * 
 * 2. 뒤에서부터하는 방식[가능성있어보여]
 * 반대방향으로 훑으면서 스택에는 내가 바라볼 사람이 올때까지 기다리는 애들로 모이게하면될 것 같다.
 * 현재들어오려는 놈이 스택의 탑보다 크면 스택의 탑이 현재들어오려는 놈보다 커질때까지 스택을 뺀다.
 * 현재들어오려는 놈이 스택의 탑보다 작으면 스택에 넣는다.
 * 스택이 비어있으면 그냥 넣는다.
 * 마지막으로 스택에 남이있는애들은 0을 넣는다. => 생각해보니 기본이 0이라 안넣어도될듯
 *
 */
public class Main{
	
	static int[] arr, ans;
    static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	Stack<Integer> stk = new Stack<>();
    	int n = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	arr = new int[n];
    	ans = new int[n];
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());	
    	}


    	for(int i=n-1; i>=0; i--) {
			while(stk.size() > 0 && arr[stk.peek()] <= arr[i]) {
				ans[stk.pop()] = i+1;
			}
    		stk.push(i);
    	}
    	

    	for(int x : ans) {
			sb.append(x).append(" ");
		}
		System.out.println(sb);
    }
    
}