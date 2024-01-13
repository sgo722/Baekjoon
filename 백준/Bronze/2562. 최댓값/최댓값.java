import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int idx = 0;
		int maxNum = 0;
		for(int i=0; i<9; i++) {
			int num = sc.nextInt();
			if(maxNum < num) {
				idx = i;
				maxNum = num;
			}
		}
		System.out.println(maxNum);
		System.out.print(idx+1);
		
	}
}