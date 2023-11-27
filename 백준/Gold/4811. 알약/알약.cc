#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int n, ans;
ll dp[64][34][34];
ll go(int day, int hCnt, int wCnt){
    if(hCnt > n || wCnt > n || hCnt < wCnt){
        return 0;
    }
    if(day == 2 * n){
        return 1;
    }

    ll &ret = dp[day][hCnt][wCnt];

    if(ret != -1){
        return ret;
    }

    ret = go(day + 1, hCnt + 1, wCnt) + go(day + 1, hCnt, wCnt + 1);

    return ret;
}
int main(){

    while(cin >> n){
        memset(dp,-1,sizeof(dp));
        ans = 0;
        if(n == 0) break;
        cout << go(1,1,0) << "\n";
    }

    return 0;
}
