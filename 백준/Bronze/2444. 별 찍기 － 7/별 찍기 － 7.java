import java.util.Scanner;

//Scanner + 구현
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			for(int j=i; j<n; j++) {
				System.out.print(" ");
			}
			for(int j=1; j< 2*i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=n-1; i>=1; i--) {
			for(int j=i; j<n; j++) {
				System.out.print(" ");
			}
			for(int j=1; j< 2*i; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
	}
}