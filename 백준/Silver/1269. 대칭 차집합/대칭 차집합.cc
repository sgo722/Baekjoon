#include <bits/stdc++.h>
using namespace std;

map<int,int> mp;
int a, b, num, cnt;
int main(){
    cin >> a >> b;
    for(int i=0; i<a; i++){
        cin >> num;
        mp[num]++;
    }
    for(int i=0; i<b; i++){
        cin >> num;
        mp[num]++;
    }

    for(auto it : mp){
        if(it.second == 1) cnt++;
    }

    cout << cnt << "\n";
    return 0;
}