import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int value = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			if(arr[i] == value) {
				count++;
			}
		}
		System.out.println(count);
	}
}