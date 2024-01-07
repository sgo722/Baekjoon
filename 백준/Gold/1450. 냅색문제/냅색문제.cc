#include <bits/stdc++.h>
using namespace std;

int n,c;
int a[34];
vector<int> v1,v2;

void go(int start, int end, vector<int> &v, long long sum){
    if(sum > c) return;
    if(start == end){
        v.push_back(sum);
        return;
    }
    go(start+1,end,v,sum+a[start]);
    go(start+1,end,v,sum);
    return;
}

int main(){
    cin >> n >> c;
    for(int i=0; i<n; i++){
        cin >> a[i];
    }

    go(0,n/2,v1,0);
    go(n/2,n,v2,0);
    sort(v1.begin(),v1.end());
    sort(v2.begin(),v2.end());

    int cnt = 0;
    for(int it : v2){
        int temp = c - it;
        if(temp >= 0) {
            cnt += upper_bound(v1.begin(), v1.end(), temp) - v1.begin();
        }
    }

    cout << cnt << "\n";
    return 0;
}