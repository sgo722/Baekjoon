#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int n;
ll dp[34][34];

// 한 알을 꼭 n번만큼 골라내야 한다. n번만큼 골라냈다면 그 경우엔 하나의 문자열이 만들어진것이다.
ll go(int one, int half){
    if(half == -1) return 0;
    if(one == 0) return 1;
    ll &ret = dp[one][half];
    if(ret != -1) return ret;
    ret = go(one-1,half+1) + go(one,half-1);
    return ret;
}
int main(){

    while(cin >> n){
        memset(dp,-1,sizeof(dp));
        if(n == 0) break;
        cout << go(n,0) << endl;
    }

    return 0;
}