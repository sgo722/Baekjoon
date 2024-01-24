import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 - Z
 * 시작 - 17:20
 * 아이디어 :
 * (y,x,size) 상태에서 4개의 상태로 분기하고 size가 1이면 출력한다.
 * (y,x,size/2), (y,x+size/2,size/2), (y+size/2,x,size/2), (y+size/2,x+size/2, size/2)
 * 1차 구현완료 - 22:39
 * 시간초과가 없을까? 2^15 * 2^15 = 30000 * 30000 = 9_000_000_000
 * 1씩 돌면 시간초과가 뜰 것 같
 * 그러면 범위에 포함되지 않으면 사이즈를 더해야할것같은
 * 문제점 보완 : 23:20
 */
public class Main{
	static int flag = 0;
	static int count = 0;
	static int ey,ex;
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		 int n = Integer.parseInt(st.nextToken());
		 ey = Integer.parseInt(st.nextToken());
		 ex = Integer.parseInt(st.nextToken());
		 int size = (int)Math.pow(2, n);
		 go(0,0,size);
		 System.out.println(count-1);
	}
	
	public static void go(int y, int x, int size) {
		 if(flag == 1) return;
		 if(size == 1) {
			 if(ey == y && ex == x) flag = 1;
		     count++;
		     return;
		 }
		 if(y <= ey && ey < y+size && x <= ex && ex < x + size) {
			 go(y,x,size/2);
			 go(y,x+size/2,size/2);
			 go(y+size/2,x,size/2);
			 go(y+size/2,x+size/2, size/2);
		 }else {
			 count += size*size;
		 }
	}
}