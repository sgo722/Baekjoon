#include <bits/stdc++.h>
using namespace std;

int n, r, c;
int ans;

bool in(int y, int x, int cnt){
    if(r >= y - cnt+1 && r <= y && c >= x -cnt+1 && c <= x){
        return true;
    }
    return false;
}


void go(int y, int x, int cnt){
    if(!in(y, x, cnt)){
        ans += (cnt * cnt);
        return;
    }
    if(cnt == 1){
        if(y == r && x == c){
            cout << ans << "\n";
            exit(0);
        }
        ans++;
        return;
    }
    go(y-cnt/2,x-cnt/2,cnt/2);
    go(y-cnt/2,x,cnt/2);
    go(y,x-cnt/2,cnt/2);
    go(y,x,cnt/2);

}
int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);
    cin >> n >> r >> c;
//    cout << pow(2,3) << '\n';

    go(pow(2,n)-1, pow(2,n)-1,pow(2,n));
    return 0;
}