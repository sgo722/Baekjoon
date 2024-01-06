#include <bits/stdc++.h>
using namespace std;
#define INF 987654321

string s;
int ans;
int t,n;
int a[104][104];
int temp[104][104];
int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};
queue<pair<int,int>> q;

void bfs(){

    while(q.size()){
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || nx >= n || ny >= n) continue;
            if(temp[ny][nx] > temp[y][x] + a[ny][nx]) {
                temp[ny][nx] = temp[y][x] + a[ny][nx];
                q.push({ny, nx});
            }
        }
    }
}
int main(){
    cin >> t;
    for(int test=1; test<=t; test++){
        while(q.size()){
            q.pop();
        }
        fill(&temp[0][0],&temp[0][0]+104*104, INF);
        cin >> n;

        for(int i=0; i<n; i++){
            cin >> s;
            for(int j=0; j<n; j++){
                a[i][j] = s[j] - '0';
            }
        }

        q.push({0, 0});
        temp[0][0] = a[0][0];
        bfs();

        cout << "#" << test << " " << temp[n-1][n-1] << "\n";
    }
    return 0;
}