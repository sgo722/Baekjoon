import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 - 1107 리모컨
 * 아이디어 :
 * 이동하려는 값 - 100이 초기값이고,
 * 이동하려는 값의 길이와 고장나지 않은 버튼으로 눌러서 이동할 수 있는 값의 길이가 같아졌을 때 값을 비교한뒤,
 * 최소값을 계산한다.
 * N이 50만이고, 버튼은 10개 이기때문에 10^6 1,000,000 경우의수가 2초안에는 무조건 들어갈듯
 *  * 만약에 4자리수에 있는 수가 5자리에 더 빨리 접근할수있는 경우가 있을수있다. => size때문에 계속해서 이런 문제가 수정되지 않고 있었음.
 size가 아닌 6자리보다 커지면이라는 조건을 바꿔서 해결했다고 생각함.
 */
public class Main{
	static int arr[] = new int[10];
	static int m,n;
	static int ans = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		if(m!=0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<m; i++) {
				arr[Integer.parseInt(st.nextToken())] = 1;
			}
		}
		ans = Math.abs(n-100);
		go("");
		System.out.println(ans);
	}
	
	static void go(String s){
		if(s.length() > 6) return;
		if(s.length() >= 1) {
			ans = Math.min(Math.abs(n-Integer.parseInt(s))+s.length(), ans);
		}
		for(int i=0; i<=9; i++) {
			if(arr[i] == 1) continue;
			go(s+i);
		}
	}
}