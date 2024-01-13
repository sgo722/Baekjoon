import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int a = sc.nextInt();
		int b = sc.nextInt();

		for(int i=0; i<a; i++) {
			int value = sc.nextInt();
			if(value < b) {
				sb.append(value + " ");
			}
		}
		System.out.println(sb);
	}
}