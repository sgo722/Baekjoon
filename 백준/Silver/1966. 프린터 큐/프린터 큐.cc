#include <bits/stdc++.h>
using namespace std;

int v[104];
int t, n, m;
int main(){
    cin >> t;

    for(int i=0; i<t; i++){
        queue<pair<int,int>> q;
        priority_queue<int> pq;
        cin >> n >> m;
        for(int j=0; j<n; j++){
            cin >> v[j];
            q.push({v[j],j});
            pq.push(v[j]);
        }
        int cnt = 0;
        while(q.size()){
            int value = q.front().first;
            int idx = q.front().second;
            q.pop();
            if(pq.top() == value){
                pq.pop();
                cnt++;
                if(idx == m) {
                    cout << cnt << "\n";
                    break;
                }
            }else{
                q.push({value,idx});
            }
        }
    }
    return 0;
}