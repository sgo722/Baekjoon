#include <bits/stdc++.h>
using namespace std;

int n, num, m;
map<int,int> mp;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> num;
        mp[num]++;
    }

    cin >> m;
    for(int i=0; i<m; i++){
        cin >> num;
        cout << mp[num] << ' ';
    }


    return 0;
}