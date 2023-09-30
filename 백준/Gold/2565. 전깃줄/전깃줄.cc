#include <bits/stdc++.h>
using namespace std;
#define prev asdf

int n, len, ret, a,b;
vector<pair<int,int>> v;

int prev;

int main(){
    cin >> n;

    for(int i=0; i<n; i++){
        cin >> a >> b;
        v.push_back({a,b});
    }

    sort(v.begin(),v.end());

    vector<int> vv(n,504);
    for(int i=0; i<n; i++){
        auto lowerPos = lower_bound(vv.begin(),vv.end(),v[i].second);
        if(*lowerPos == 504) len++;
        *lowerPos = v[i].second;
    }

    cout << n - len << "\n";


    return 0;
}

