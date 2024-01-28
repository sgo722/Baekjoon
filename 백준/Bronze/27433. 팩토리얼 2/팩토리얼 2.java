import java.util.Scanner;


/**
 * 문제 : 팩토리얼 2
 * 아이디어 :
 * 재귀로 팩토리얼을 만들고, 변수범위가 20이니까 long으로 설정해줘야할 것 같다.
 */


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(fibo(n));
	}
	
	static Long fibo(int n) {
		if(n == 1 || n == 0) {
			return 1L;
		}
		return n * fibo(n-1);
		
	}
}
