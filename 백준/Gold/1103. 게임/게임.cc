#include <bits/stdc++.h>
using namespace std;


int N, M;
string s;
int a[54][54];
int visited[54][54];
int dp[54][54];
int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};

int dfs(int y, int x){
    if(a[y][x] == 'H' || y < 0 || x < 0 || y >= N || x >= M){
        return 0;
    }


    if(visited[y][x] == 1){
        cout << -1 << "\n";
        exit(0);
    }

    if(dp[y][x] != -1) return dp[y][x];

    visited[y][x] = 1;
    dp[y][x] = 0;
    for(int i=0; i<4; i++){
        int ny = y + dy[i] * a[y][x];
        int nx = x + dx[i] * a[y][x];
        dp[y][x] = max(dp[y][x], dfs(ny,nx)+1);
    }
    visited[y][x] = 0;

    return dp[y][x];
}

int main(){

    cin >> N >> M;
    memset(dp,-1,sizeof(dp));
    for(int i=0; i<N; i++){
        cin >> s;
        for(int j=0; j<M; j++){
            if(s[j] == 'H') a[i][j] = s[j];
            else {
                a[i][j] = s[j] - '0';
            }
        }
    }

    cout << dfs(0,0);
    return 0;
}