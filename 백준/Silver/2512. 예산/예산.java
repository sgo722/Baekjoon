import java.io.*;
import java.util.*;



public class Main{
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=0; i<n; i++){
            int cnt = (n-i);
            int avg = m / cnt;
//            System.out.print(cnt + " " + m + " ");
//            System.out.print(arr[i] + " ");
//            System.out.println(avg);
            if(avg > arr[i]){ // 평균이 현재 인덱스보다 크다면?
                if(i == n-1){
                    ans = arr[i];
                }
                m -= arr[i];
            }else{ // 평균이 현재 인덱스보다 작다면?
                ans = avg;
                break;
            }
        }

        System.out.println(ans);
    }
}

// 평균으로 나눈 값보다 현재 인덱스의 값이 작으면 값을 빼고 평균을 다시 계산
// 평균보다 값이 크면 이게 맥스값이 된다.