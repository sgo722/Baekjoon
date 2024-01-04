#include <bits/stdc++.h>
using namespace std;


int t, n;
int main(){
    cin >> t;

    for(int i=1; i<=t; i++) {
        cin >> n;
        int num = 0;
        int cnt = 0;
        int ans = 0;
        int v[104] = {0,};
        for (int j = 0; j < 1000; j++) {
            cin >> num;
            v[num]++;
            if (cnt <= v[num]) {
                cnt = v[num];
                ans = num;
            }
        }
        cout << "#" << i << " " << ans << "\n";
    }
    return 0;
}