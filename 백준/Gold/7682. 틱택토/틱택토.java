import java.io.*;
import java.util.*;

public class Main{
	
	static char[][] map;
	static int xCnt, oCnt;
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			xCnt = 0;
			oCnt = 0;
			String s = br.readLine();
			map = new char[3][3];
			if(s.equals("end")) break;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					map[i][j] = s.charAt(i*3+j);
					if(map[i][j] == 'X') xCnt++;
					else if(map[i][j] == 'O') oCnt++;
				}
			}
			
//			print(map);
			int flag = check();

//			System.out.println(flag);
			if(flag > 4) {
				System.out.println("invalid");
				continue;
			}
			else if(flag == 4 && xCnt == oCnt+1) {
				System.out.println("valid");
				continue;
			}else if(flag == 2 && xCnt == oCnt) {
				System.out.println("valid");
				continue;
			}else if(flag == 2 && xCnt > oCnt) {
				System.out.println("invalid");
				continue;
			}
			if(oCnt > 4 || xCnt < oCnt || xCnt > oCnt+1) System.out.println("invalid");
			else if(xCnt + oCnt == 9) {
				
				System.out.println("valid");
			}
			else System.out.println("invalid");
		}
	}
	
	static void print(char[][] map) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static int check() {
		int flag = 0;
		
		if(map[1][1]=='O' && map[0][0] == 'O' && map[2][2] == 'O') flag |= (1<<1);
		if(map[1][1]=='O' && map[0][2] == 'O' && map[2][0] == 'O') flag |= (1<<1);
		
		if(map[1][1]=='X' && map[0][0] == 'X' && map[2][2] == 'X') flag |= (1<<2);
		if(map[1][1]=='X' && map[0][2] == 'X' && map[2][0] == 'X') flag |= (1<<2);
		
		
		for(int i=0; i<3; i++) {
			if(map[i][0] == 'O' && map[i][1] == 'O' && map[i][2] == 'O') flag |= (1<<1);
			if(map[0][i] == 'O' && map[1][i] == 'O' && map[2][i] == 'O') flag |= (1<<1);
			if(map[i][0] == 'X' && map[i][1] == 'X' && map[i][2] == 'X') flag |= (1<<2);
			if(map[0][i] == 'X' && map[1][i] == 'X' && map[2][i] == 'X') flag |= (1<<2);
		}
	
		return flag;
	}
}