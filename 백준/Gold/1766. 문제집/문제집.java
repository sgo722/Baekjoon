import java.io.*;
import java.util.*;

public class Main{

    static int n,m,a,b;
    static int[] inDegree;
    static ArrayList<Integer> arr[];
    public static void main(String[] args) throws Exception{
        input();
        List<Integer> list = go();
        for(int it : list){
            System.out.print(it + " ");
        }
    }

    static List<Integer> go(){
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));

        for(int i=1; i<=n; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        while(q.size() > 0){
            int now = q.poll();
            for(int it : arr[now]){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.add(it);
                }
            }

            result.add(now);
        }

        return result;
    }

    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        inDegree = new int[n+1];
        arr = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            inDegree[b]++;
        }
    }
}