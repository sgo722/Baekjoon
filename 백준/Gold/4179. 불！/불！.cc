#include <bits/stdc++.h>
using namespace std;

int a[1004][1004];
int jvisited[1004][1004];
int fvisited[1004][1004];
int dy[4] = {-1,0,1,0};
int dx[4] = {0,1,0,-1};
vector<pair<int,int>> jnow, fnow;
int r, c, y, x, cnt, ret = 987654321;
string s;
queue<pair<int,int>> q;


int main(){
    cin >> r >> c;
    for(int i=0; i<r; i++) {
        cin >> s;
        for (int j = 0; j < c; j++) {
            if (s[j] == '#') a[i][j] = 0;
            else if (s[j] == '.') a[i][j] = 1;
            else if (s[j] == 'J') {
                a[i][j] = 1;
                jnow.push_back({i, j});
            } else if (s[j] == 'F') {
                a[i][j] = 2;
                fnow.push_back({i, j});
            }
        }
    }

//    for(int i=0; i<r; i++){
//        for(int j=0; j<c; j++){
//            cout << a[i][j] << " ";
//        }
//        cout << "\n";
//    }

    q.push({jnow[0].first, jnow[0].second});
    jvisited[jnow[0].first][jnow[0].second] = 1;
    while(q.size()){
        tie(y,x) = q.front();
        q.pop();
        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
            if(a[ny][nx] == 0) continue;
            if(jvisited[ny][nx]) continue;
            jvisited[ny][nx] = jvisited[y][x] + 1;
            q.push({ny,nx});
        }
    }


    for(int i=0; i<fnow.size(); i++){
        q.push({fnow[i].first, fnow[i].second});
        fvisited[fnow[i].first][fnow[i].second] = 1;
    }
    while(q.size()){
        tie(y,x) = q.front();
        q.pop();
        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
            if(a[ny][nx] == 0) continue;
            if(fvisited[ny][nx]) continue;
            fvisited[ny][nx] = fvisited[y][x] + 1;
            q.push({ny,nx});
        }
    }

    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
            if(i == 0 || j == 0 || i==r-1 || j==c-1){
                if(jvisited[i][j] != 0 && fvisited[i][j] == 0){
                    cnt++;
                    ret = min(ret, jvisited[i][j]);
//                    cout << ret << "\n";
                }
                else if(jvisited[i][j] != 0 && jvisited[i][j] < fvisited[i][j]){
                    cnt++;
                    ret = min(ret,jvisited[i][j]);
                }
            }
        }
    }

    if(cnt == 0){
        cout << "IMPOSSIBLE" << "\n";
        return 0;
    }
    cout << ret << "\n";



    return 0;
}


/*
# : 0
. : 1
F : 2
J : 지훈이 위치

r, c : 행, 열

지훈이가 가장자리로 오게되면 탈출할수있다고 가정한다.
불은 사방으로 번진다.
지훈이가 한번 움직이면 불이 사방으로 번진다.
불이 도달하는 시간보다 지훈이가 먼저 위치에 도달하면 이동이 가능하다는것같은데?
가장자리에 불, 지훈이 중 뭐가 먼저 도달하는지 비교해보고 지훈이가 먼저 도달하는경우가 있다면 탈출할수있다한다.
탈출이 가능하면 그 값을 출력하고, 그런 경우가 없다면 "IMPOSSIBLE"을 출력한다.
*/