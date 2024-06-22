import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    static ArrayList<Integer> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list = new ArrayList<>();
        for(int i=1; i<=9; i++){
            permutation(i, 1<<i);
        }

        Collections.sort(list);

        while(true){
            int idx = Integer.parseInt(br.readLine());
            if(idx == 0){
                return;
            }
            System.out.println(list.get(idx-1));
        }
    }

    static void permutation(int num, int check){
        if(num >= 30000000) return;
        list.add(num);
        for(int i=0; i<=9; i++){
            if((check & (1<<i)) == 0){
                permutation(num*10 + i, check | (1<<i));
            }
        }
    }
}