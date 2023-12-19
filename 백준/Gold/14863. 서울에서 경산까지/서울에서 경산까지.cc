#include <bits/stdc++.h>
using namespace std;


// 못푼문제.
// 내 코드에서의 문제점
// 1) 끝까지 탐색한 값이 dp값을 모두 초기화시켜서 dp에 값을 올바르게 저장하지 못하고 있었음.
struct B{
    int time;
    int money;
};

int n, k;
int dp[104][100004];
B walk[104],ride[104];

int go(int here, int time){
    if(here == n){
        return 0;
    }

    int &ret = dp[here][time];
    if(ret) return ret;
    ret = -1e6;
    if(time - walk[here].time >= 0) ret = max(ret, go(here + 1, time - walk[here].time) + walk[here].money);
    if(time - ride[here].time >= 0) ret = max(ret, go(here + 1, time - ride[here].time) + ride[here].money);
    return ret;
}
int main() {

    cin >> n >> k;

    for(int i=0; i<n; i++){
        cin >> walk[i].time >> walk[i].money >> ride[i].time >> ride[i].money;
    }
    
    cout << go(0,k);
    return 0;
}