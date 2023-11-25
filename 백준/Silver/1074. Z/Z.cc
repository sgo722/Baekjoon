#include <bits/stdc++.h>
using namespace std;

int n, r, c;
int ans;


void go(int y, int x, int size){
    if(y == r && x == c){
        cout << ans << "\n";
        return;
    }

    if(r >= y && r < y+size && c >= x && c < x+size){
        go(y,x,size/2);
        go(y,x+size/2, size/2);
        go(y+size/2 ,x, size/2);
        go(y+size/2, x+size/2, size/2);
    }
    else{
        ans += (size * size);
    }

}
int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);
    cin >> n >> r >> c;

    go(0,0,pow(2,n));
    return 0;
}