import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 -  서로소 집합
 * 문제이해)
 * 문제이름부터 Union-find 알고리즘이다.
 * 테스트케이스가 주어지고, n개의 수와 m개의 연산이 주어진다.
 *
 * m개의 연산은 3개의 문자로 주어진다.
 * 첫번째 문자는 명령어이고, 두번째와 세번째는 연산에 수행되는 집합을 의미한다.
 *
 */
public class Solution{

    static int[] parent;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for(int t=1; t<=tc; t++) {
            sb.append("#" + t + " ");
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            makeSet(n);

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine(), " ");

                int op = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(op == 0){
                    union(a,b);
                }else if(op == 1){
                    if(find(a) == find(b)){ // 같은 부모노드를 가지고 있다면
                        sb.append(1);
                    }else{
                        sb.append(0);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void makeSet(int number){
        parent = new int[number+1];

        for(int i=1; i<=number; i++){
            parent[i] = i;
        }
    }

    static int find(int x){
        if(parent[x] == x) return x; // 루트노드면 본인을 반환
        return parent[x] = find(parent[x]); // 루트노드가 아니면 부모노드로 이동
    }

    static void union(int a, int b){

        // 각 팀의 대표자를 찾아서 합친다.

        // 서로 같은 집합이면? 합칠 필요가 없다.
        if(find(a) == find(b)) return;
        parent[find(b)] = find(a);
    }
}