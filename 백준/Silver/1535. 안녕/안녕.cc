#include <bits/stdc++.h>
using namespace std;

int n;
int damage[24], happy[24];
int dp[104];
int main(){
    cin >> n;
    memset(dp,0,sizeof(dp));
    for(int i=0; i<n; i++){
        cin >> damage[i];
    }
    for(int i=0; i<n; i++){
        cin >> happy[i];
    }

    for(int i=0; i<n; i++){
        for(int j=100; j>damage[i]; j--){
            dp[j] = max(dp[j], dp[j-damage[i]] + happy[i]);
        }
    }

    cout << dp[100] << "\n";

    return 0;
}