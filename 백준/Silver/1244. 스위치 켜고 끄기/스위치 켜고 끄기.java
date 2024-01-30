import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 : 1224 키고끄기
 * 시작 - 21:20
 * 문제정독 키워드 1) 성별, 스위치 번호, 받은 번호, 남학생/여학생 키워드 동작방식
 * 문제정독 키워드 2) 스위치 상태(온/오프) , 스위치 8개 고정, 학생 몇명 뽑아 번호 분배
 * 문제정독 키워드 3) 입력 정보(처음 상태, 각 학생 성별, 받은 수)
 * 입력 예측) 학생들을 몇명 뽑는다고 적혀있다.
 * 처음 상태에 대해서 입력받고, 학생 수에 대해서 입력받고 다음줄에 학생에 대한 정보들이 주어지지않을까
 * 그리고 나온 학생대로 진행해야한다고했으니까 배열에 저장해도되고, 입력받자마자 바로 뒤집어도 될 것 같다.
 * 예제 입력 -> 스위치 개수 입력받는 내용이 있었다.
 * 분석했을땐 스위치 8개 고정인줄 알았는데, 그림1에 8개로 배치되어있다고 설명한 거였다.
 * 1이 남자 - 배수들 뒤집는다
 * 2이 여자 - 주어진 수를 기준으로 좌우탐색을 진행하고 대칭이면 뒤집는다.
 * 아이디어)
 * 스위치 배열을 불리언 배열로 만들고, 남학생이면 주어진 수부터 스위치 길이를 초과하기전까지 뒤집는다.
 * 여학생이면 기준을 뒤집고 좌우대칭 확인한다. 대칭이면 뒤집고 확장해서 다음 좌우대칭 확인
 * 구현 시작 - 19:42
 * 구현 완료 - 19:52
 * 틀림 - 인덱스 아웃
 * 수정 - 22:02 (조건문 검사 순서때문에 인덱스 아웃이 날수도 있을 것 같아 수정함.)
 * 틀림 - 출력 형식이 잘못되었습니다.
 * 수정 - 22:04 (띄어쓰기 문제인가 싶어서 수정함.)
 * 틀림 - 출력 형식이 잘못되었습니다.
 * 수정 - 22:09 (한줄에 20개씩 출력해야한다는 걸 깨달음)
 */
public class Main{
    static boolean[] line;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        line = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++){
            if(Integer.parseInt(st.nextToken()) == 1){
                line[i] = true;
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if (s == 1) {
                for (int idx = value; idx <= n; idx += value) {
                    line[idx] = !line[idx];
                }
            } else if (s == 2) {
                line[value] = !line[value];
                int len = 1;
                while (true) {
                    if (value+len <= n && value - len >= 1 && line[value + len] == line[value - len] ) {
                        line[value + len] = !line[value + len];
                        line[value - len] = !line[value - len];
                        len++;
                    } else {
                        break;
                    }
                }
            }
        }


        for(int i=1; i<=n; i++){
            if(line[i] == true) {
                System.out.print(1 + " ");
            }else if(line[i] == false){
                System.out.print(0 + " ");
            }
            if(i % 20 == 0) System.out.println();
        }
    }
}