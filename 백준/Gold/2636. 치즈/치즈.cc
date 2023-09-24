#include <bits/stdc++.h>
using namespace std;
#define prev junyeong

int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};
int a[104][104];
int prev, cnt, hour;
int visited[104][104];
int n, m, y, x;

queue<pair<int,int>> q;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    for(int i = 0; i<n;i++){
        for(int j=0; j<m; j++){
            cin >> a[i][j];
            if(a[i][j] == 1) cnt++;
        }
    }

    if(cnt == 0){
        cout << hour << '\n' << prev;
        return 0;
    }
    prev = cnt;
    while(1) {
        hour++;
        cnt = 0;
        queue<pair<int, int>> q;
        visited[0][0] = 1;
        q.push({0, 0});
        while (q.size()) {
            tie(y, x) = q.front();
            q.pop();
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (a[ny][nx] == 1) visited[ny][nx] = -1;
                if (visited[ny][nx]) continue;
                visited[ny][nx] = visited[y][x] + 1;
                q.push({ny, nx});
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
//                if (i != 0 && j != 0 && a[i][j] == 0) a[i][j] = -1;
                    if (visited[i][j] == -1) a[i][j] = 0;
                }
            }
        }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
//                    cout << a[i][j] << ' ';
                    if (a[i][j] == 1) cnt++;
                    visited[i][j] = 0;
                }
//                cout << '\n';
            }
//            cout << "\n\n\n\n";
            if (cnt == 0) break;
            else {
                prev = cnt;
            }
    }

    cout << hour << '\n' << prev;
    return 0;
}