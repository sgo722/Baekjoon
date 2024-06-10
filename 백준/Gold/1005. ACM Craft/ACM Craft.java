import java.io.*;
import java.util.*;

public class Main{
    static int n,k,t;
    static int[] arr, indegree, result;
    static ArrayList<Integer> list[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n+1];
            indegree = new int[n+1];
            result = new int[n+1];
            list = new ArrayList[n+1];
            for(int j=0; j<=n; j++){
                list[j] = new ArrayList<>();
            }


            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[x].add(y);
                indegree[y]++;
            }

            int w = Integer.parseInt(br.readLine());

            Queue<Integer> q = new LinkedList<>();

            for(int j=1; j<=n; j++){
                result[j] = arr[j];

                if(indegree[j] == 0){
                    q.add(j);
                }
            }


            while(q.size() > 0) {
                int num = q.poll();

                for (int next : list[num]) {
                    result[next] = Math.max(result[next], result[num] + arr[next]);
                    indegree[next]--;

                    if(indegree[next] == 0){
                        q.add(next);
                    }
                }

            }
            System.out.println(result[w]);
        }
    }
}