#include <bits/stdc++.h>
using namespace std;

int ans = 1e9;
int num;
void go(int n, int cnt){
    if(ans < cnt) return;
    if(n == 0){
        return;
    }
    if(n == 1){
        ans = min(ans,cnt);
        return;
    }

    if(n % 3 == 0){
        go(n / 3, cnt + 1);
    }
    if(n % 2 == 0){
        go(n / 2, cnt + 1);
    }
    go(n - 1, cnt + 1);
}
int main(){

    cin >> num;

    go(num,0);
    cout << ans << "\n";
    return 0;
}