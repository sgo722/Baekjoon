#include <bits/stdc++.h>
using namespace std;

int n,m, ret;
int visited[504][504];
int a[504][504];
string s;
int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};

int dfs(int y, int x){
    if(visited[y][x] == 2) return 2;
    if(visited[y][x] == 1) return 1;
    if(y == n+1 || x == m+1 || y == 0 || x == 0) return 2;
    visited[y][x] = 1;
    int ny = y, nx = x;
    if(a[y][x] == 'U'){
        ny += dy[0];
        nx += dx[0];
    }else if(a[y][x] == 'R'){
        ny += dy[1];
        nx += dx[1];
    }else if(a[y][x] == 'D'){
        ny += dy[2];
        nx += dx[2];

    }else if(a[y][x] == 'L'){
        ny += dy[3];
        nx += dx[3];
    }
    visited[y][x] = dfs(ny,nx);
    return visited[y][x];
}


int main(){
    cin >> n >> m;

    for(int i=1; i<=n; i++){
        cin >> s;
        for(int j=0; j<m; j++){
            a[i][j+1] = s[j];
        }
    }

    for(int i=1; i<=n; i++){
        for(int j=1; j<=m; j++){
            if(visited[i][j]) continue;
            dfs(i,j);
        }
    }

    for(int i=1; i<=n; i++){
        for(int j=1; j<=m; j++){
            if(visited[i][j] == 2) ret++;
        }
    }

    cout << ret << "\n";
    return 0;
}