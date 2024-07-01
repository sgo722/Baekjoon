import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
    static int n,c;

    static ArrayList<Integer> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        boolean flag = false;
        for(int i=0; i<n; i++){
            int number = Integer.parseInt(st.nextToken());
            if(number == c){
                flag = true;
            }
            list.add(number);
        }

        Collections.sort(list);

        if(flag){
            System.out.println(1);
            return;
        }
        int l=0, r=list.size()-1;
        loop:
        while(l < r){
            int sum = list.get(l) + list.get(r);

            if(sum > c) r--;
            else if(sum == c){
                flag = true;
                break;
            }else if(sum < c){
                int findNumber = c - sum;
                for(int i=l+1; i<r; i++){
                    if(list.get(i) == findNumber){
                        flag = true;
                        break loop;
                    }
                }
                l++;
            }
        }

        if(flag){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}