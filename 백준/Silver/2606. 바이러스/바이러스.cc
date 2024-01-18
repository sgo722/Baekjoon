#include <bits/stdc++.h>
using namespace std;

int t,n,a,b;
vector<int> v[104];
int visited[104];

int go(int here){
    visited[here] = 1;
    int cnt = 1;
    for(int there : v[here]){
        if(visited[there]) continue;
        cnt += go(there);
    }
    return cnt;
}
int main(){
    cin >> t;
    cin >> n;

    for(int i=0; i<n; i++){
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }

    cout << go(1) - 1;
}