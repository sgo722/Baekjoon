#include <bits/stdc++.h>
using namespace std;

int a,b,cnt;
int main(){
    cin >> a >> b;
    cnt = 0;
    for(int i=1; i<=a; i++){
        if(a % i == 0) cnt++;
        if(cnt == b) {
            cout << i << "\n";
            return 0;
        }
    }
    cout << 0 << "\n";
    return 0;
}