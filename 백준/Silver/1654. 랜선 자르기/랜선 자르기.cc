#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

ll a[10004];
ll n,k, maxNum, ans;
int main(){
    cin >> k >> n;

    for(int i=0; i<k; i++){
        cin >> a[i];
        maxNum = max(maxNum, a[i]);
    }

    ll l = 1, r = maxNum;
    while(l <= r){
        ll mid = (l+r)/2;
        ll cnt = 0;
        for(int i=0; i<k; i++){
            cnt += a[i]/mid;
        }

        if(cnt >= n){ // 만든개수가 만들어야하는 개수보다 많으면?
            ans = max(ans, mid);
            l = mid + 1;
        }else{
            r = mid - 1;
        }
    }

    cout << ans << "\n";
    return 0;
}