import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br;

    static StringTokenizer st;
    static int[] arr;

    static boolean[] visited, done;

    static int count;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            done = new boolean[n+1];
            count = 0;

            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=n; j++){
                arr[j] = Integer.parseInt(st.nextToken());

                if(arr[j] == j){
                    done[j] = true;
                    count++;
                }
            }

            for(int j=1; j<=n; j++){
                if(!done[j]){
                    dfs(j);
                }
            }

            System.out.println(n-count);
        }

    }

    static void dfs(int idx){

        //이미 방문 했을 때
        if(visited[idx]){
            done[idx] = true; // 팀 편성 완료했다고 처리
            count++; // 팀 편성 완료 인원 증가
        }else{
            // 방문하지 않았을 떄 -> 방문처리
            visited[idx] = true;
        }

        // 다음 학생이 팀 결성을 아직 못했을 경우
        if(!done[arr[idx]]){
            dfs(arr[idx]);
        }

        visited[idx] = false;
        done[idx] = true;
    }
}