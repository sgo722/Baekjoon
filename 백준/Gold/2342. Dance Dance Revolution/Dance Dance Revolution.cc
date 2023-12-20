#include <bits/stdc++.h>
using namespace std;
#define INF 2000000000

int a[100004];
int dp[100004][5][5];

int go(int here, int r, int l){
    if(r > 0 && l > 0 && r == l) return INF;
    if(a[here] == 0) return 0;

    int &ans = dp[here][r][l];
    if(ans != 0) return ans;
    ans = INF;

    if(a[here] == r){
        ans = min(ans, go(here+1,r,l)+1);
    }
    else if(a[here] != r){
        if(r == 0){
            ans = min(ans, go(here+1,a[here],l)+2);
        }
        else if((a[here] % 2) == (r % 2)){
            ans = min(ans, go(here+1,a[here],l)+4);
        }
        else{
            ans = min(ans, go(here+1,a[here],l)+3);
        }
    }
    if(a[here] == l){
        ans = min(ans, go(here+1,r,l)+1);
    }
    else if(a[here] != l){
        if(l == 0){
            ans = min(ans, go(here+1,r,a[here])+2);
        }
        else if((a[here] % 2) == (l % 2)){
            ans = min(ans, go(here+1,r,a[here])+4);
        }
        else{
            ans = min(ans, go(here+1,r,a[here])+3);
        }
    }

    return ans;
}
int main(){

    for(int i=0; ; i++){
        cin >> a[i];
        if(a[i] == 0) break;
    }

    cout << go(0,0,0) << "\n";


    return 0;
}