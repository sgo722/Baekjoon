#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int n;
ll a[104];
ll dp[104][1004];

ll go(ll idx, ll sum){
    if(sum < 0 || sum > 20) return 0;
    if(idx == n-1){
        if(a[idx] == sum) return 1;
        return 0;
    }

    ll &ans = dp[idx][sum];
    if(ans != -1) return ans;

    ans = go(idx+1, sum+a[idx]) + go(idx+1, sum-a[idx]);
//    cout << "dp[" << idx << "][" << sum << "] = " << ans << "\n";
    return ans;
}
int main(){
    cin >> n;

    memset(dp,-1,sizeof(dp));
    for(int i=0; i<n; i++){
        cin >> a[i];
    }

    cout << go(1,a[0]);
    return 0;
}