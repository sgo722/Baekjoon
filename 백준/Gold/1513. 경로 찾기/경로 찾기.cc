#include <bits/stdc++.h>
using namespace std;
#define mod 1000007

int N, M, C;
int a,b;
int m[54][54];
int dp[54][54][54][54];

int go(int y, int x, int cnt, int prev){
    if(y > N || x > M) return 0;
    if(y == N && x == M){
        if(cnt == 0 && m[y][x] == 0) return 1;
        if(cnt == 1 && m[y][x] > prev) return 1;
        return 0;
    }

    int &ret = dp[y][x][cnt][prev];
    if(ret != -1) return ret;
    ret = 0;
    if(m[y][x] == 0){
        ret = (go(y+1,x,cnt,prev)+go(y,x+1,cnt,prev)) % mod;
    }
    else if(m[y][x] > prev){
        ret = (go(y+1,x,cnt-1,m[y][x])+go(y,x+1,cnt-1,m[y][x]))%mod;
    }

    return ret;
}

int main(){
    cin >> N >> M >> C;
    memset(dp,-1,sizeof(dp));
    for(int i=1; i<=C; i++){
        cin >> a >> b;
        m[a][b]= i;
    }

    for(int i=0; i<=C; i++){
        cout << go(1,1,i,0) << " ";
    }

    return 0;
}