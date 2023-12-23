#include <bits/stdc++.h>
using namespace std;

int n,k;
int block[14];
int ans;

bool check(int num) {
    string number = to_string(num);
    for(int i=0; i<number.length(); i++){
        if(block[number[i] - '0']) return false;
    }
    return true;
}
int main(){
    cin >> n >> k;

    int tmp;
    for(int i=0; i<k; i++){
        cin >> tmp;
        block[tmp] = 1;
    }

    ans = abs(n - 100);
    for(int i=0; i<1000000; i++){
        if(check(i)){
            int cmp = abs(n-i)+ to_string(i).length();
            ans = min(ans, cmp);
        }
    }

    cout << ans << "\n";
    return 0;
}