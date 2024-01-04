#include <bits/stdc++.h>
using namespace std;
#define prev asdf

int cnt = 1, a, b;
int sum[1004];
int main(){
    cin >> a >> b;
    int value = 1;
    int prev = 0;
    for(int i=1; cnt < 1001; i++){
        value = i;
        for(int j=1; j<=i; j++){
            sum[cnt] = prev + value;
            prev = sum[cnt];
            cnt++;
            if(cnt == 1001) break;
        }
    }

    cout << sum[b] - sum[a-1] << "\n";

    return 0;
}