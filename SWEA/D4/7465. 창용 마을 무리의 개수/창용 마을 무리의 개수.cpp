#include <bits/stdc++.h>
using namespace std;

int t;
int n,m,a,b;
vector<int> v[104];
int visited[104];

void go(int here){
    visited[here] = 1;
    for(int there : v[here]){
        if(visited[there]) continue;
        go(there);
    }
}
int main(){
    cin >> t;
    for(int test = 1; test <= t; test++){
        memset(visited,0,sizeof(visited));
        for(int i=0; i<104; i++){
            v[i].clear();
        }
        int cnt = 0;
        cin >> n >> m;
        for(int i=0; i<m; i++){
            cin >> a >> b;
            v[a].push_back(b);
            v[b].push_back(a);
        }

        for(int i=1; i<=n; i++){
            if(visited[i]) continue;
            go(i);
            cnt++;
        }

        cout << "#" << test << " " << cnt << "\n";
    }
    return 0;
}
