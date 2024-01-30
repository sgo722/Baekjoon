import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import static java.lang.Integer.*;

/**
 * 문제 : 뱀과 사다리게임
 * 시작 - 13:10
 * 문제 이해)
 * 1에서 100까지 이동하는데 1,2,3,4,5,6 주사위가 굴러가는 경우에 의해서 도착하는 가장 빠른 경우를 찾아야한다.
 * 사다리는 어떤 지점에 도착했을때 더 높은 지점으로 이동시켜주고, 뱀에 도착하면 현재위치보다 낮은 지점으로 이동시킨다.
 * 아이디어)
 * 어떻게 가장 빠른 경우를 찾을 수 있을까?
 * 현재 위치에서 6가지 방향으로 이동하게된다. 즉, 한가지 노드에서 6가지의 경우로 분기되는 것을 의미하고,
 * 그 떄가 주사위 던진 누적횟수가 더해지게 되는 것이다.
 * 그러면 다음 방향에서 다음방향으로 이동하는 같은 횟수에 포함된 위치들의 값을 저장하면된다.
 * 
 * 구현은 어떻게 해야할까)
 * 구현은 bfs로 구현할 수 있다고 생각한다. 근데 시간초과가 발생할수도있어보인다.
 * 1에서 100으로 이동하는데, 뱀이 설치되어있어서 1밖에 이동하지 못한다고 생각하면 6^100을 돌려야하기때문에 시간초과가 발생하겠다.
 * 그러면 이거 dp네요?
 * 
 * 
 * 구현 시작 - 13:35
 */
public class Main{
	static int[] arr;
	static int[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[101];
		visited = new int[101];
		int n = parseInt(st.nextToken());
		int m = parseInt(st.nextToken());

		for(int i=1; i<=100; i++) {
			arr[i] = i;
		}
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a] = b;
			
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a] = b;
		}
		
		bfs(1);
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = 0;
		int cnt = 1;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i=0; i<qSize; i++) {
				int here = q.poll();
				for(int j=1; j<=6; j++) {
					int there = here + j;
					if(there > 100) continue;
					if(visited[arr[there]] == 1) continue;
					if(arr[there] == 100) {
						System.out.println(cnt);
						return;
					}
					visited[arr[there]] = 1;
					visited[there] = 1;
					q.add(arr[there]);
				}
			}
			cnt++;
		}
	}
}