import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제 - BJ_15900_나무탈출
 * 문제이해 -
 * 나무탈출이라는 게임을 진행한다.
 * 각 리프노드에는 하나씩의 말이 놓여있고, 본인 턴에 하나의 말을 부모노드로 이동시켜아한다.
 * 그렇게 루트노드에 도착하면 게임판에서 사라지게 된다.
 * 만약 게임판에 남은 말이 없다면 움직일 말이 없는 것으로 되어서 그 턴에 움직여야하는 사람이 지게 된다.
 * 아이디어)
 * 1. 부모노드를 가지고 있는 배열을 만들어서, 이동할떄 자신의 배열값을 인덱스화시켜서 부모노드로의 이동시켜볼까..?
 * 모든 부모노드들이 1인지 확인하는 메서드를 생각해보면 O(N)이고, N이 50만이므로, 이건 시간초과의 근거가 된다.
 * 그렇기 때문에 재귀를 이용한 완전탐색은 시도해볼 이유가 없다.
 *
 * 2. 홀수/짝수의 값으로 결과를 확인하는 방법은 어떨까?
 * 모든 노드들이 움직였을때의 결과값이 홀수라면 No를, 짝수라면 Yes를 출력해주면 된다.
 * => 루트노드의 자식들은 1번씩만 이동하면 탈출할 수 있다.
 * => 루트노드들의 자식들의 자식들은 2번씩 이동하면 탈출할 수 있다.
 * => 이렇게 생각해보면 자식들을 관리하는 배열을 하나 만들고, 카운팅 배열을 만들어서 탈출횟수를 저장해두면 될 것 같다.
 * => 자식노드들의 탈출 횟수 = 부모노드의 탈출 횟수 + 1이 된다.
 * 이걸로 구현해본다면 모든 노드들을 한번만 훑기때문에 O(2N) == 조회, 저장이기 때문에, 시간초과가 발생하지 않을 거라고 생각된다.
 * 틀린 이유)
 * 1. 리프노드의 횟수만 카운팅하면 되기 때문에 리프노드의 개수가 0인 개수를 카운트해주자
 * 2. 양방향 간선으로 만들어서 방문처리를 통해서 이미 방문했다면 갱신하지 않도록 해주어야했다.
 * 3. 총 카운팅 횟수가 홀수개여야 성원이가 승리했다는 Yes문구를, 짝수개면 No문구를 띄워줘야했는데 반대로 출력하고있었다.
 * 4. int형 자료형을 long자료형으로 변경. 정답값이 20억이상이 넘어갈 수 있어서 long으로 바꿔줄 필요가 있었다.
 * 5. n값을 조정하면서 parent[n]값에 대해서 확인하지 않고 있어서 n값을 전체적으로 수정했다.
 * 6. 아하.. 1부터 순차적으로 탐색하는 것이 아니라, 1의 자식들에 대해서 다시 재 탐색이 이뤄지게끔 해야겠다.
 */
public class Main{
    static ArrayList<Integer>[] parent;
    static long[] count, visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        long ans = 0;
        parent = new ArrayList[n+1];
        count = new long[n+1];
        visited = new long[n+1];

        for(int i=0; i<n+1; i++){
            parent[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            parent[a].add(b);
            parent[b].add(a);
        }

        count[1] = 0;
        visited[1] = 1;
        for(int i=0; i<parent[1].size(); i++){
            visited[parent[1].get(i)] = 1;
            count[parent[1].get(i)] = count[1] + 1;
            go(parent[1].get(i));
        }

        for(int i=2; i<=n; i++){
            if(parent[i].size() == 1) {
//                System.out.println(i + " " + count[i]);
                ans += count[i];
            }
        }

        if(ans % 2 == 1){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    static void go(int idx){
        for(int i=0; i<parent[idx].size(); i++){
            if(visited[parent[idx].get(i)] == 1) continue;
            visited[parent[idx].get(i)] = 1;
            count[parent[idx].get(i)] = count[idx] + 1;
            go(parent[idx].get(i));
        }
    }
}