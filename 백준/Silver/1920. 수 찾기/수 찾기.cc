#include <bits/stdc++.h>
using namespace std;

int n, num, m;
vector<int> v;
map<int,int> mp;

void go(int start, int end){
    if(start > end) return;
    if(start == end){
        if(mp[v[start]] != 0) cout << 1 << "\n";
        else cout << 0 << "\n";
        return;
    }

    go(start,(start+end)/2);
    go((start+end)/2+1,end);
}
int main(){
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> num;
        mp[num]++;
    }


    cin >> m;
    for(int j=0; j<m; j++){
        cin >> num;
        v.push_back(num);
    }

    go(0,m-1);

    return 0;
}