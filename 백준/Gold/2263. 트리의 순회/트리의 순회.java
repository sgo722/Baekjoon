import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;



/**
 * [B5] 트리
 * 문제시작 - 20:05
 * 아이디어:
 * preOrder - VRL
 * inOrder -  LVR
 * postOrder - LRV
 *
 * 호출하는 순서를 반대로 뒤집고, s,e로 시작하는 부분을
 * e,s로 호출하면되지않을까
 * e-(root
 */
public class Main {
	static int n;
	static int[] post, in, visited;
	static StringBuilder sb = new StringBuilder();
	static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		in = new int[n];
		post = new int[n];
        visited = new int[n];
		for(int i=0; i<n; i++) {
			in[i] = Integer.parseInt(st1.nextToken());
			post[i] = Integer.parseInt(st2.nextToken());
		}

		go(n-1,0,n-1);
		System.out.println(sb);
	}

	public static void go(int root, int s, int e) {
		if (root < 0 || visited[root] == -1) return;
		for(int i=e; i>=s; i--) {
			if(in[i] == post[root]) {
                visited[root] = -1;
				sb.append(post[root]).append(" ");
				go(root-1-(e-i), s, i-1);
				go(root-1,i+1,e);
                return;
			}
		}
	}

}