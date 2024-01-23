import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 트리
 * 문제시작 -
 * 아이디어:
 * preOrder - VRL
 * inOrder -  LVR
 * postOrder - LRV
 */
public class Main {
	static int n;
	static int[] pre, in;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=0; tc<t; tc++) {
			sb = new StringBuilder();
			n = Integer.parseInt(br.readLine());
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			in = new int[n];
			pre = new int[n];
			for(int i=0; i<n; i++) {
				pre[i] = Integer.parseInt(st1.nextToken());
				in[i] = Integer.parseInt(st2.nextToken());
			}
			
			go(0,0,n);
			System.out.println(sb);
		}
	}
	
	public static void go(int root, int s, int e) {
		if(s > e) {
			return;
		}
		for(int i=s; i<e; i++) {
			if(in[i] == pre[root]) {
				go(root+1, s, i);
				go(root+1+i-s,i+1,e);
				sb.append(pre[root]).append(" ");
				return;
			}
		}
	}
}