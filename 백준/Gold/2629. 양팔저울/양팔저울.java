import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 추의 무게를 이용해서
 * 구슬의 무게를 만들수 있으면 가능 없으면 불가능
 *
 */
public class Main{

    static int[] chu;
    static boolean[] goosle;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        goosle = new boolean[40004];
        chu = new int[n];
        for(int i=0; i<n; i++){
            chu[i] = Integer.parseInt(st.nextToken());
        }

        goosle[0] = true;
        for(int i=0; i<n; i++){
            list = new ArrayList<>();
            for(int j=0;j<=40000; j++){
                if(goosle[j]){
                    list.add(Math.abs(j-chu[i]));
                    if(j+chu[i] <= 40000) {
                        list.add(j+chu[i]);
                    }
                }
            }
//            System.out.println(list);
            list.add(chu[i]);
            for(int j=0; j<list.size(); j++){
                goosle[list.get(j)] = true;
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<m; i++){
            int weight = Integer.parseInt(st.nextToken());
            if(goosle[weight]){
                System.out.print("Y ");
            }else{
                System.out.print("N ");
            }
        }

    }
}

/**
 * 주어진 값들의 합과 뺄셈을 다 계산해놓으면 이 구슬이 되는지 안되는지 확인핳 수 있다고 생각한다.
 * 추의 개수는 30개
 * 추의 무게는 500g이하
 * 구슬의 개수는 7개
 * 구슬의 무게는 40,000g이하
 * 3^30 = 더하는경우, 빼는경우, 포함되지않는경우 시간초과
 * 내 무게와 같으면 만들수 있고, 체크되어있으면 거기에서 내 무게를 더하거나 뺼 수 있다.
 */