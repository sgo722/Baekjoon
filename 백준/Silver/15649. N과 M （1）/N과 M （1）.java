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
 * sb를 이용한 풀이 답 참고했음.
 */

public class Main{
	
	public static int[] arr;
	public static int n,m;
	public static int[] visited;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		visited = new int[n+1];
		combi(0);
		System.out.println(sb);
		
	}
	
	public static void combi(int depth) {
		if(depth == m) {
			for(int here : arr) {
				sb.append(here).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				arr[depth] = i;
				combi(depth+1);
				visited[i] = 0;
			}
		}
	}
}