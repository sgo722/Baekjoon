import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * 문제 - 국회의원 선거
 * 문제이해 - 다솜이가 당선되기 위해서 매수해야하는 인원수를 파악하라
 * 다솜이의 득표수가 첫번째, 그리고 다른 후보들의 득표수가 제공된다.
 * 후보들의 배열을 정렬하면서 가장 득표수가 많은 후보의 수를 빼고 다솜에게 더하면서 횟수를 카운팅한다.
 * 가장 높은 후보의 득표수보다 많아졌을때의 카운팅한 값을 출력한다.
 */
public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        n--;
        int count = 0;
        if(n == 0) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[n];
        int dasom = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        while(true){
            Arrays.sort(arr);
            if(arr[n-1] < dasom) break;
            dasom++;
            arr[n-1]--;
            count++;
        }

        System.out.println(count);
    }
}