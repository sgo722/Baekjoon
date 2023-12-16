#include <bits/stdc++.h>
using namespace std;

int n,m1,m2, kcal, p1,p2;
int dp[100004];

int main(){
    while(1){
        scanf("%d %d.%d", &n, &m1, &m2); // 사탕개수, 내가 가진 돈 입력 - 실수형 연산의 한계때문에 정수형으로 입력받기
        if(n == 0 && m1 == 0 && m2 == 0) break; // 종료조건
        memset(dp,0,sizeof(dp)); // dp[cost] = kcal => dp는 cost에 해당하는 최대 kcal를 가진다.
        int m = m1 * 100 + m2; // 내가 가진 돈 계산
        for(int i=0; i<n; i++){
            scanf("%d %d.%d", &kcal, &p1, &p2); // 사탕 칼로리, 사탕가격 입력 - 실수형 연산 한계로 인한 정수형 변환
            int p = p1 * 100 + p2; // 사탕 가격 계산
            for(int j = p; j<= m; j++){
                dp[j] = max(dp[j], dp[j-p]+kcal); // 같은 금액을 지불하는데 더 많은 칼로리를 얻는 경우 확인한다.
            }
        }
        cout << dp[m] << "\n";
    }
    return 0;
}