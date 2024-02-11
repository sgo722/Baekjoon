import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr.add(3);
        int j=4;
        for(int i=1; arr.get(arr.size()-1) < n; i++){
            arr.add(arr.get(arr.size()-1) * 2 + j);
            j++;
        }

        go(n, arr.size()-1);
    }


    static void go(int target, int depth){
//        System.out.println("target : " + target + ", arr[" + depth + "] : " + arr.get(depth));

        if(depth == 0) {
            if (target == 1) {
                System.out.println("m");
            } else {
                System.out.println("o");
            }

            return;
        }

        if(target < arr.get(depth-1)){
            go(target, depth-1);
        }else if(target == arr.get(depth-1)){
            go(0,0);
        }else if(target <= arr.get(depth-1) + depth + 2){
            go(target-arr.get(depth-1),0);
        }else{
            go(target-arr.get(depth-1)-depth-3, depth);
        }
    }
}