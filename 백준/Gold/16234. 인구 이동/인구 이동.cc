#include <bits/stdc++.h>
using namespace std;

int N,L,R, cnt;
int a[54][54];
int visited[54][54];
int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};
vector<pair<int,int>> v;

pair<int,int> dfs(int y, int x){
    pair<int,int> ret = {1,a[y][x]};
    v.push_back({y,x});
    visited[y][x] = 1;
    for(int i=0; i<4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
        if(visited[ny][nx]) continue;
        if(abs(a[y][x]-a[ny][nx]) >= L && abs(a[y][x]-a[ny][nx]) <= R) {
            pair<int,int> temp = dfs(ny,nx);
            ret.first += temp.first;
            ret.second += temp.second;
        }
    }
    return ret;
}
int main(){
    cin >> N >> L >> R;

    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin >> a[i][j];
        }
    }


//    for(int i=0; i<N; i++){
//        for(int j=0; j<N; j++){
//            cout << a[i][j] << " ";
//        }
//        cout << "\n";
//    }

    cnt = 0;
    while(1){
        v.clear();
        int f = 0;
        memset(visited,0,sizeof(visited));
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]) continue;
                pair<int,int> temp = dfs(i,j);
                if(temp.first > 1){
                    f = 1;
                    for(auto it : v){
                        a[it.first][it.second] = temp.second/temp.first;
                    }
                    v.clear();
                }
                else v.clear();
            }
        }
        if(f==0) break;
        cnt++;
    }

    cout << cnt << "\n";

    return 0;
}