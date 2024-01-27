import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/**
 * 문제 : 222-풀링
 * 문제 시작 - 18:40
 * 두번째 순위에 있는 값을 리턴하면
 * 두번째 순위에 있는 값을 리턴한다.
 * 
 * 88배열을 44배열 22배열 11배여로 만든다.
 * 
 * 2by2배열에서 2번째로 큰수를 
 * 그런데 값을 어떻게 담을수 있지?
 * */
public class Main {
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(go(0,0,n));
	}
	
	static int go(int y, int x, int size) {
		ArrayList<Integer> ret = new ArrayList<>();
		if(size == 2) {
			for(int i=y; i<y+size; i++) {
				for(int j=x; j<x+size; j++) {
					ret.add(arr[i][j]);
				}
			}
			Collections.sort(ret);
			return ret.get(2);
		}
		
		ret.add(go(y,x,size/2));
		ret.add(go(y,x+size/2,size/2));
		ret.add(go(y+size/2,x,size/2));
		ret.add(go(y+size/2,x+size/2,size/2));
		Collections.sort(ret);
		return ret.get(2);
	}
	
}