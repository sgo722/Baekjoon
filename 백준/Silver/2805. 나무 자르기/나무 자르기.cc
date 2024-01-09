#include <bits/stdc++.h>
using namespace std;

int n,m, num, ans;
vector<int> v;
int main(){
    cin >> n >> m;

    for(int i=0; i<n; i++){
        cin >> num;
        v.push_back(num);
    }

    int l = 0, r = 2000000000;

    while(l <= r){
        int mid = (l + r) / 2;
        long long sum = 0;

        for(int i=0; i<n; i++){
            if(v[i] > mid){
                sum += (v[i] - mid);
            }
            if(sum > m) break;
        }

        if(sum >= m){
            l = mid+1;
            ans = mid;
        }else{
            r = mid-1;
        }
    }

    cout << ans << "\n";
    return 0;
}