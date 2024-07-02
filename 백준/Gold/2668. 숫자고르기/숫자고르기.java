import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int n;
    static int[] arr;
    static boolean[] visited;
    static boolean[] team;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        visited = new boolean[n+1];
        team = new boolean[n+1];

        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=n; i++){
            if(team[arr[i]]) continue;
            dfs(i, arr[i],new ArrayList<>());
        }

        int count = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(team[i]) {
                count++;
                result.add(i);
            }
        }

        System.out.println(count);
        for(int it : result){
            System.out.println(it);
        }

    }

    static void dfs(int start, int cur, ArrayList<Integer> list){

        list.add(cur);
        if(start == cur){
            for(int it : list){
                team[it] = true;
            }
            return;
        }

        if(visited[cur] || team[cur]) return;
        visited[cur] = true;
        dfs(start, arr[cur], list);
        visited[cur] = false;
    }
}