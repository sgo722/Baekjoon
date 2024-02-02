import java.io.*;
import java.util.*;

public class Main{
    static int[] arr, distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        arr = new int[n];
        distance = new int[n];


        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            distance[i] = w;
        }

        Queue<Integer> q = new LinkedList<>();

        int cnt = 0;

        for(int i=0; i<n; i++){
            cnt++;
            if(q.size()>0) {
                int front = q.peek();
                int size = q.size();
                for (int j = front; j < front+size; j++) {
                    distance[j]--;
                }
                for (int j = front; j < front+size; j++) {
                    if (distance[j] == 0) {
                        l += arr[j];
                        q.poll();
                    }
                }
            }

            while(l < arr[i]) {
                cnt++;
                int front = q.peek();
                int size = q.size();
                while (distance[front] != 0) {
                    cnt++;
                    for (int j = front; j < front + size; j++) {
                        distance[j]--;
                    }
                }
                for (int j = front; j < front + size; j++) {
                    if (distance[j] == 0) {
                        l += arr[j];
                        q.poll();
                    }
                }
                cnt--;
            }
            q.add(i);
            l -= arr[i];
        }
        cnt+=w;

        System.out.println(cnt);
    }
}