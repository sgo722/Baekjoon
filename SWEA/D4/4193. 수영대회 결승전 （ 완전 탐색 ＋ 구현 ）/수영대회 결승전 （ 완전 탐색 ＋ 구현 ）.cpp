#include <bits/stdc++.h>
using namespace std;
#define INF 987654321
int t,n, sy,sx, ey, ex;
int a[19][19];
int visited[19][19];
vector<pair<int,int>> so;
int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};

void fadeSo(){
    for(pair<int,int> it : so){
        a[it.first][it.second] = 0;
    }
}

void createSo(){
    for(pair<int,int> it : so){
        if(a[it.first][it.second] == 2) return;
        a[it.first][it.second] = 2;
    }
}
void bfs(){
    int cnt = 0;
    queue<pair<int,int>> q;
    q.push({sy,sx});
    while(q.size()){
        int qSize = q.size();
        for(int i=0; i<qSize; i++) {
            int y = q.front().first;
            int x = q.front().second;
            q.pop();
            if (a[y][x] == 2) {
                q.push({y, x});
                continue;
            }
            visited[y][x] = min(visited[y][x], cnt+1);
            for (int j = 0; j < 4; j++) {
                int ny = y + dy[j];
                int nx = x + dx[j];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if (visited[ny][nx] != INF) continue;
                if (a[ny][nx] == 0 || a[ny][nx] == 2) {
                    q.push({ny, nx});
                }
            }
        }
        if (cnt % 3 == 2) fadeSo();
        else createSo();
        cnt++;
    }
}
int main(){
    cin >> t;
    for(int test=1; test <= t; test++){
        so.clear();
        fill(&visited[0][0], &visited[0][0]+19 * 19, INF);
        cin >> n;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                cin >> a[i][j];
                if(a[i][j] == 2){
                    so.push_back({i,j});
                }
            }
        }
        cin >> sy >> sx;
        cin >> ey >> ex;
        bfs();

//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//                cout << visited[i][j] << " ";
//            }
//            cout << "\n";
//        }
//        cout << "\n\n\n\n";
        if(visited[ey][ex] == INF){
            cout << "#" << test << " " <<  -1 << "\n";
        }else{
            cout << "#" << test << " " << visited[ey][ex] -1 << "\n";
        }
    }
    return 0;
}