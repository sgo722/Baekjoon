#include <bits/stdc++.h>
using namespace std;
#define MAX_N 100001

// 정답 코드
// check 함수를 통해서 움직임 값을 구현함.
// 궁금한 점
// 이 전에 내가 작성한 코드들과 시간복잡도가 많이 차이날까?
// 내가 했던 것보다 조금은 많이 걸릴 것 같다고 생각한다.
// 이전 코드에서는 발이 같은 위치에 놓일 경우 처리를 해주었지만, 이 경우는 처리되어있지 않기 때문이다.
// 최적값을 나타내는 것은 동일하지만, 이런 과정에서 더 많이 걸린다고 생각한다.

int dp[5][5][MAX_N], n;
vector<int> v;

int check(int from, int to){
    if(from == 0) return 2;
    if(from == to) return 1;
    if(abs(from-to) == 2) return 4;
    return 3;
}

int solve(int y, int x, int target){
    if(target == n) return 0;
    if(dp[y][x][target] != -1) return dp[y][x][target];

    int left = solve(v[target], x, target+1)+check(y,v[target]);
    int right = solve(y,v[target],target+1)+check(x,v[target]);
    return dp[y][x][target] = min(left,right);
}
int main(){
    while(1){
        int num;
        cin >> num;
        if(num == 0){
            break;
        }
        v.push_back(num);
    }

    memset(dp,-1,sizeof(dp));
    n = v.size();
    cout << solve(0,0,0) << "\n";
    return 0;
}