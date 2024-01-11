#include <bits/stdc++.h>
using namespace std;

int v[29][29], visited[29][29];
int n;
string s;
vector<int> vec;
int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};

int go(int y, int x){
    int cnt = 1;

    for(int i=0; i<4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
        if(visited[ny][nx]) continue;
        if(v[ny][nx] == 1) {
            visited[ny][nx] = 1;
            cnt += go(ny, nx);
        }
    }
    return cnt;
}
int main(){
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> s;
        for(int j=0; j<n; j++){
            v[i][j] = s[j] - '0';
        }
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(v[i][j] == 1 && visited[i][j] == 0) {
                visited[i][j] = 1;
                vec.push_back(go(i,j));
            }
        }
    }
    sort(vec.begin(),vec.end());
    cout << vec.size() << "\n";
    for(int it : vec){
        cout << it << "\n";
    }
    return 0;
}