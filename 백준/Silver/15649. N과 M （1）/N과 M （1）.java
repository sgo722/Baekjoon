import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
/**
 * 문제시작 - 08:14
 * 아이디어 -
 * 조합을 이용한다.
 * 시간 1초 : 8^8 => 1600만 가능해보이긴함.
 * 구현시작 - 08:17
 * 구현완료 - 08:29
 * 문제점 - 
 * 스트링 객체를 생성하는 과정에서 시간이 많이 걸릴것같아 StringBuilder를 넘겨주는게 좋지 않을까?
 * => 해보려고했으나 StringBuilder객체를 이용하면 출력이 이상하게 나옴.
 * StringBuilder를 이용한 구현 실패 - 08:43
 */

public class Main{
	
	static int n,m;
	static int[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visited = new int[n+1];
		combi(0,"",0);
	}
	
	public static void combi(int idx, String s, int cnt) {
		if(cnt == m) {
			System.out.println(s);
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				combi(i,s+i+" ",cnt+1);
				visited[i] = 0;
			}
		}
	}
}

// StringBuilder를 이용한 코드인데 어떤 부분에서 문제가 있는지 모르겠음.
//public class Main{
//	
//	static int n,m;
//	static int[] visited;
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		StringBuilder sb = new StringBuilder();
//		n = Integer.parseInt(st.nextToken());
//		m = Integer.parseInt(st.nextToken());
//		
//		visited = new int[n+1];
//		combi(0,sb,0);
//	}
//	
//	public static void combi(int idx, StringBuilder sb, int cnt) {
//		if(cnt == m) {
//			System.out.println(sb);
//			return;
//		}
//		
//		for(int i=1; i<=n; i++) {
//			if(visited[i] == 0) {
//				visited[i] = 1;
//				combi(i,sb.append(i+" "),cnt+1);
//				visited[i] = 0;
//			}
//		}
//	}
//}

