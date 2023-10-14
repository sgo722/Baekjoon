// 가지고있는 숫자 중에서 가지고있다면 입력된 숫자의 map value를 1로 만들고 없다면 0 으로 만들어서 출력하라

#include <bits/stdc++.h>
using namespace std;

#define max 500000
int n, k, num;
map<int,int> mp;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> n;

    for(int i=0; i<=max; i++){
        mp[i] = 0;
    }
    for(int i=0; i<n; i++){
        cin >> num;
        mp[num] = 1;
    }
    cin >> k;
    for(int i=0; i<k; i++){
        cin >> num;
        cout << mp[num] << ' ';
    }


    return 0;
}
