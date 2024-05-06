import java.io.*;
import java.util.*;

// 답 참고함
// 깊이와 문자를 저장하는 방식으로 우선순위큐로 문자, 깊이 오름차순으로 정렬하는 방식을 생각하여
// PriorityQueue를 사용했으나, 같은 문자가 나오는 경우에 처리를 하지 못했고, 이부분에 대해서 고민하다가 답을 봤음
// 답에서는 어떻게 처리했는가?
// ==> 답에서는 다음으로 올 수 있는 문자들 모두 찾아본 후, 같은 깊이에 사전상 가장 늦은 문자열이 여러개일 경우에는
// => 해당 인덱스를 전부 저장한 후, 같은 문자여도 다음에 어떤 문자가 올지 확인할수 있도록 만들었다.
public class Main {

    static int n, u, v;
    static String input;

    static boolean[] visited;

    static ArrayList<Integer> list[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = br.readLine();
        StringTokenizer st;
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        bfs();
        System.out.println(sb);
    }

    public static void bfs() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        visited[1] = true;
        sb.append(getChar(1));

        while(!arr.isEmpty()){
            ArrayList<Integer> validNodes = null;
            char max = '\0';
            for(int cur : arr){
                for(int next : list[cur]){
                    if(visited[next]) continue;
                    char charOfNext = getChar(next);
                    if(max > charOfNext) continue;
                    if(validNodes == null || max < charOfNext){
                        validNodes = new ArrayList<>();
                        max = charOfNext;
                    }
                    validNodes.add(next);
                }
            }

            if(validNodes == null) break;

            sb.append(max);
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int next : validNodes){
                visited[next] = true;
                tmp.add(next);
            }
            arr = tmp;
        }
    }

    public static char getChar(int idx){
        return input.charAt(idx-1);
    }
}