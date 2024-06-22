import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    static ArrayList<Integer> a,b;
    static HashMap<Integer,Long> mp1, mp2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        mp1 = new HashMap<>();
        mp2 = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new ArrayList<>();
        for(int i=0; i<n; i++){
            a.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        b = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            b.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<n; i++){
            int sum = a.get(i);
            long count = mp1.getOrDefault(sum,0L);
            mp1.put(sum,count+1);
            for(int j=i+1; j<n; j++){
                sum += a.get(j);
                long sumCount = mp1.getOrDefault(sum,0L);
                mp1.put(sum, sumCount+1);
            }
        }

        for(int i=0; i<m; i++){
            int sum = b.get(i);
            long count = mp2.getOrDefault(sum,0L);
            mp2.put(sum,count+1);
            for(int j=i+1; j<m; j++){
                sum += b.get(j);
                long sumCount = mp2.getOrDefault(sum,0L);
                mp2.put(sum, sumCount+1);
            }
        }

        long sum = 0;
        for(int it : mp1.keySet()){
            long aCount = mp1.get(it);
            long bCount = mp2.getOrDefault(t-it,0L);
//            System.out.println(aCount + " " + bCount);
            long count = aCount * bCount;
            sum += count;
        }


        System.out.println(sum);
    }
}