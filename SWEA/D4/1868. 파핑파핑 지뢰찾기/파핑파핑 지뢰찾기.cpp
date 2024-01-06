#include <bits/stdc++.h>
using namespace std;

string s;
int t,n;
char a[304][304];
int v[304][304], visited[304][304];

int dy[] = {-1,-1,-1,0,0,1,1,1};
int dx[] = {-1,0,1,-1,1,-1,0,1};

void check(int y, int x){
    for(int i=0; i<8; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
        if(a[ny][nx] == '*') { v[y][x]++; }
    }
}

void dfs(int y, int x){
    for(int i=0; i<8; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
        if(visited[ny][nx] || a[ny][nx] == '*') continue;
        visited[ny][nx] = 1;
        if(v[ny][nx] == 0) dfs(ny, nx);
    }
}
int main(){
    cin >> t;
    for(int test=1; test<=t; test++){
        memset(visited,0,sizeof(visited));
        memset(v,0,sizeof(v));
        int cnt = 0;
        cin >> n;
        for(int i=0; i<n; i++) {
            cin >> s;
            for (int j = 0; j < n; j++) {
                a[i][j] = s[j];
            }
        }

        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if(a[i][j] == '*') continue;
                check(i, j);
            }
        }
//
//        for(int i=0; i<n; i++) {
//            for (int j = 0; j < n; j++) {
//                cout << v[i][j] << " ";
//            }
//            cout << "\n";
//        }
//
//        cout << "\n";


        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j] == 0 && v[i][j] == 0 && a[i][j] != '*'){
                    visited[i][j] = 1;
                    dfs(i,j);
                    cnt++;
                }
            }
//            for(int j=0; j<n; j++) {
//                for (int k = 0; k < n; k++) {
//                    cout << visited[j][k] << " ";
//                }
//                cout << "\n";
//            }
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j] == 0 && a[i][j] != '*') cnt++;
            }
        }

        cout << "#" << test << " " << cnt << "\n";
    }
    return 0;
}