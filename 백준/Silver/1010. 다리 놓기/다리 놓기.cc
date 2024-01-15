#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

ll n,a,b;
int main(){
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> a >> b;
        ll gop = 1;
        int cnt = 1;
        for(int j=b; j>(b-a); j--){
            gop *= j;
            gop /= cnt;
            cnt++;
        }
        cout << gop << "\n";
    }
    return 0;
}