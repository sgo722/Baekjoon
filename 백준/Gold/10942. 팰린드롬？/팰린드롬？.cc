#include <bits/stdc++.h>
using namespace std;

// dp[a][b]가 1이면, dp[b][a]도 1로 만들려고했는데 그럴필요가 없었음.
// fastIO안하면 시간초과 발생한다.
int n, m, s, e;
int v[2004];
int dp[2004][2004];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> n;
    for(int i=1; i<=n; i++){
        cin >> v[i];
    }

    for(int i=1; i<=n; i++){
        dp[i][i] = 1;
    }

    for(int i=1; i<=n-1; i++){
       if(v[i]==v[i+1]){
           dp[i][i+1] = 1;
       }
    }

    for(int _size = 2; _size <= n; _size++){
        for(int i=1; i<=n-_size; i++){
            if(v[i] == v[i+_size] && dp[i+1][i+_size-1]) dp[i][i+_size] = 1;
        }
    }
    cin >> m;
    for(int i=0; i<m; i++){
        cin >> s >> e;
        cout << dp[s][e] << "\n";
    }
    return 0;
}