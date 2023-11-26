#include <bits/stdc++.h>
using namespace std;

int n,m,v;
int a,b;
int visited[1004];
vector<int> vec[1004];

void dfs(int here){
    cout << here << " ";
    visited[here] = 1;
    for(int there : vec[here]){
        if(visited[there]) continue;
        dfs(there);
    }
}

void bfs(int start){

    queue<int> q;
    q.push(start);
    visited[start] = 1;
    while(q.size()){
        int here = q.front();
        cout << here << " ";
        q.pop();

        for(int there : vec[here]){
            if(visited[there]) continue;
            visited[there] = 1;
            q.push(there);
        }
    }
}
int main(){
    cin >> n >> m >> v;

    for(int i=0; i<m; i++){
        cin >> a >> b;
        vec[a].push_back(b);
        vec[b].push_back(a);
    }

    for(int i=0; i<1000; i++){
        sort(vec[i].begin(),vec[i].end());
    }

    dfs(v);
    memset(visited,0,sizeof(visited));
    cout << "\n";
    bfs(v);
    return 0;
}