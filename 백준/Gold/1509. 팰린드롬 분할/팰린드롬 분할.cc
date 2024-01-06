#include <bits/stdc++.h>
using namespace std;
#define INF 987654321

string s;
int dp[2504][2504], dp2[2504];

int go(int here){
    if(here == s.size()) return 0;
    if(dp2[here] != INF) return dp2[here];
    int &ret = dp2[here];
    for(int _size=1; here + _size <= s.size(); _size++){
        if(dp[here][_size] == 1) {
            ret = min(ret, go(here + _size) + 1);
        }
    }
    return ret;
}
int main(){
    cin >> s;
    fill(dp2,dp2+2504,INF);

    for(int i=0; i<s.size(); i++){
        dp[i][1] = 1;
    }

    for(int i=0; i<s.size()-1; i++){
        if(s[i] == s[i+1]){
            dp[i][2] = 1;
        }
    }

    for(int size = 3; size <= s.size(); size++){
        for(int j=0; size + j <= s.size(); j++){
            if(s[j] == s[j+size-1] && dp[j+1][size-2] == 1){
                dp[j][size] = 1;
            }
        }
    }

    cout << go(0) << "\n";
    return 0;
}