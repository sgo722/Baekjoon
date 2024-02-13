import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 앵무새 단어 전달 -> 한번에 N마리가 전달하니까 꼬였다.
 * 한 앵무새가 여러단어를 순서대로 말한다.
 * 앵무새 말하다가 다른 앵무새가 가로채서 말할수 있다.
 * 말하는 도중에는 가로챌수 없다.
 * 어떤 단어도 중복일 수 없다.
 *
 *
 * 문장 S들과 문장 L이 주어진다.
 * S을 받아적었을때 L이라는 문장이 나올 수 있는 지 판별하라.
 */


public class Main{
    static ArrayList<Queue<String>> sentences = new ArrayList<>();
    static Queue<String> answer = new LinkedList<>();
    static HashMap<String, Integer> map = new HashMap();
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            sentences.add(new LinkedList<>());
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
//                map.put(st.nextToken(), 0);
                sentences.get(i).add(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()){
            answer.add(st.nextToken());
        }

        int count = 0;
        while(answer.size() > 0) {
            for (int i = 0; i < n; i++) {
                while (sentences.get(i).size() > 0 && sentences.get(i).peek().equals(answer.peek())) {
                    sentences.get(i).poll();
                    answer.poll();
                }
            }
            count++;
            if(count == 10001) break;
        }

        if(count == 10001){
            System.out.println("Impossible");
            return;
        }
        for (int i = 0; i < n; i++) {
            while (sentences.get(i).size() > 0) {
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }

}