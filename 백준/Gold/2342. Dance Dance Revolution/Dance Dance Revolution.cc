#include <bits/stdc++.h>
using namespace std;
#define INF 2000000000

// 풀었음.
// 문제점
// 1. dp배열의 크기 수정
// 2. 발이 0에 있을 때 움직이는 로직 수정
// 3. 같은 발에 위치할 때 로직 수정.
// 개선하고싶은 부분
// 1. 같은 위치에 발이 놓이는 경우를 막을 수 있으면 좋을 것 같음.

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