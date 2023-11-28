#include <bits/stdc++.h>
using namespace std;
#define INF 987654321

int n, k, value;
int ans = INF;
int dp[10000004];
vector<int> v;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> n >> k;
    fill(dp,dp+10000004,INF);
    for(int i=0; i<n; i++){
        cin >> value;
        v.push_back(value);
    }
    sort(v.begin(),v.end());

    dp[0] = 0;
    for(int i=0; i<v.size(); i++){
        for(int j=1; j<=k; j++){
            if(j-v[i] < 0) continue;
            dp[j] = min(dp[j],dp[j-v[i]]+1);
        }
    }

    if(dp[k] == INF){
        cout << -1 << "\n";
    }
    else {
        cout << dp[k] << "\n";
    }



    return 0;
}