#include <bits/stdc++.h>
using namespace std;

int t, n, a, b, m;
vector<int> v[1004];
int visited[1004];
void dfs(int here){
    visited[here] = 1;
    for(int there : v[here]){
        if(visited[there]) continue;
        dfs(there);
    }
    return;
}
int main(){
    cin >> t;
    while(t--){
        memset(visited,0,sizeof(visited));
        for(int i=0; i<1004; i++){
            v[i].clear();
        }
        int cnt = 0;
        cin >> n;
        cin >> m;
        for(int i=0; i<m; i++){
            cin >> a >> b;
            v[a].push_back(b);
            v[b].push_back(a);
        }

        dfs(1);
        for(int i=1; i<=n; i++){
            if(visited[i]) cnt++;
        }
        if(cnt == n && m == n-1) cout << "tree" << "\n";
        else cout << "graph" << "\n";
    }
    return 0;
}