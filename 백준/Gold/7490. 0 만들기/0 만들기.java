import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    static int n, t;
    static String[] op;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            op = new String[n];

            dfs(1, " ");
            dfs(1, "+");
            dfs(1, "-");
            System.out.println();
        }

    }

    static void dfs(int depth, String ch) {
        op[depth-1] = ch;
        if (depth == n-1) {
            if(cal() == 0) {
                for (int i = 1; i <= depth; i++) {
                    System.out.print(i + op[i - 1]);
                }
                System.out.println(n);
            }
            return;
        }

//        if(ch != "")
        dfs(depth + 1, " ");
        dfs(depth + 1, "+");
        dfs(depth + 1, "-");
    }

    static int cal(){

        Queue<Integer> numQ = new LinkedList<>();
        Queue<String> opQ = new LinkedList<>();

        int prev = 1;
        for(int i=2; i<=n; i++){
            if(op[i-2] == "+"){
                numQ.add(prev);
                opQ.add("+");
                prev = i;
            }else if(op[i-2] == "-"){
                numQ.add(prev);
                opQ.add("-");
                prev = -i;
            }else if(op[i-2] == " "){
                if(prev < 0){
                    prev = prev * 10 - i;
                }else{
                    prev = prev * 10 + i;
                }
            }
            if(i==n){
                numQ.add(prev);
            }
        }

        while(opQ.size() > 0){
            String ch = opQ.poll();
            if(ch.equals("+")){
                int a = numQ.poll();
                int b = numQ.poll();
                a = a + b;
                numQ.add(a);
            }else if(ch.equals("-")){
                int a = numQ.poll();
                int b = numQ.poll();
                int total = a + b;
                numQ.add(total);
            }
        }


        return numQ.poll();
    }
}