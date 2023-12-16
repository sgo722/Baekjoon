#include <bits/stdc++.h>
using namespace std;

int n,k;
int dp[10004];
int a[104];
int temp;


int main(){

    cin >> n >> k;
    dp[0] = 1;

    for(int i=0; i<n; i++){
        cin >> a[i];
    }

    for(int i=0; i<n; i++){
        if(a[i] > 10000) continue;
        for(int j=a[i]; j<=k; j++){
            dp[j] += dp[j-a[i]];
        }
    }


    cout << dp[k] << "\n";
    return 0;
}