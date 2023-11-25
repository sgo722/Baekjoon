#include <bits/stdc++.h>
using namespace std;

int n, a,b, last,cnt,ret;
vector<pair<int,int>> v;
int main(){
    cin >> n;

    for(int i=0; i<n; i++){
        cin >> a >> b;
        v.push_back({b,a});
    }

    sort(v.begin(),v.end());
    int end = v[0].first;
    int cnt = 1;
    for(int i=1; i<v.size(); i++){
        if(end > v[i].second) continue;
        else{
            end = v[i].first;
            cnt++;
        }
    }
    cout << cnt << "\n";
    return 0;
}