#include <bits/stdc++.h>
using namespace std;

int n,ans;
string s;
vector<int> v[54];
int visited[54];

void bfs(int here){
    queue<int> q;
    visited[here] = 1;
    q.push(here);
    for(int i=0; i<2; i++) {
        int Qsize = q.size();
        for(int j=0; j<Qsize; j++){
            int here = q.front();
            q.pop();
            for (int there: v[here]) {
                if (visited[there]) continue;
                visited[there] = 1;
                q.push(there);
            }
        }
    }
}

int main(){
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> s;
        for(int j=0; j<n; j++) {
            if (s[j] == 'Y') {
                v[i].push_back(j);
            }
        }
    }

    for(int i=0; i<n; i++){
        memset(visited,0,sizeof(visited));
        int cnt = 0;
        bfs(i);
        for(int j=0; j<n; j++){
            if(i!=j && visited[j]){
                cnt++;
            }
        }
        ans = max(ans, cnt);
    }

    cout << ans << "\n";
    return 0;
}

// 문제 시작 : 14:33
// depth가 2인 경우까지 탐색해서 아는 애들은  visited처리한다.
// 14:46 bfs로 돌려야 맞겠네..
// 문제 해결 : 14:56