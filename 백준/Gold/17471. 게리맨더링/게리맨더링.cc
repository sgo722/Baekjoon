#include <bits/stdc++.h>
using namespace std;

const int max_n = 1e9;
int n, m;
int a[14], temp;
vector<int> v[14];
int comp[14], visited[14];
int result = max_n;

pair<int,int> dfs(int here, int value){
    visited[here] = 1;
    pair<int,int> ret = {1,a[here]};
    for(int there : v[here]){
        if(comp[there] != value) continue;
        if(visited[there]) continue;
        pair<int,int> _temp = dfs(there, value);
        ret.first += _temp.first;
        ret.second += _temp.second;
    }
    return ret;
}


int main(){
    cin >> n;
    for(int i=1; i<=n; i++){
        cin >> a[i];
    }

    for(int i=1; i<=n; i++){
        cin >> m;
        for(int j=0; j<m; j++){
            cin >> temp;
            v[i].push_back(temp);
            v[temp].push_back(i);
        }
    }

    for(int i=1; i<=1<<(n-1); i++){
        fill(visited,visited+14,0);
        fill(comp,comp+14,0);
        int idx1=-1, idx2=-1;
        for(int j=0; j<n; j++){
            if(i & (1<<j)) {
                idx1 = j+1;
                comp[j+1] = 1;
            }
            else idx2 = j+1;
        }
        pair<int,int> comp1 = dfs(idx1,1);
        pair<int,int> comp2 = dfs(idx2,0);

        if(comp1.first + comp2.first == n) {
            if (result > abs(comp1.second - comp2.second)) {
                result = abs(comp1.second - comp2.second);
            }
        }
    }

    if(result == max_n) cout << -1 << "\n";
    else cout << result << "\n";
    return 0;
}