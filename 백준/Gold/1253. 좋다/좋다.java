import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);
        Map<Integer,Integer> map = new TreeMap<>();

        for(int i=0; i<n; i++){
            if(map.containsKey(arr.get(i))) {
                map.put(arr.get(i), map.get(arr.get(i)) + 1);
            }else{
                map.put(arr.get(i), 1);
            }
        }

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int sum = arr.get(i) + arr.get(j);
                int count;
                if(map.containsKey(sum)) {
                    count = map.get(sum);
                    if (arr.get(i) == 0 && arr.get(j) == 0) {
                        if(count >= 3){
                            answer += count;
                            map.remove(sum);
                        }
                    } else if (arr.get(i) == 0 || arr.get(j) == 0) {
                        if(count >= 2){
                            answer += count;
                            map.remove(sum);
                        }
                    }else{
                        answer += count;
                        map.remove(sum);
                    }
                }
            }
        }

        System.out.println(answer);


    }
}