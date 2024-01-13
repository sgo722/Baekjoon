import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int[] arr = new int[num1];
		for(int i=1; i<=num1; i++) {
			arr[i-1] = i;
		}
		for(int i=0; i<num2; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}
		
		for(int i=0; i<num1; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}