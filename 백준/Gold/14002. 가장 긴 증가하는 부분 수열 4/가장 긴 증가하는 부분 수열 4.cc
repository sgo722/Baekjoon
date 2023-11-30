#include<bits/stdc++.h>
using namespace std;
int n, len, num;
stack<int> stk;
int main(){
    cin >> n;
    vector<int> v(n,1004);
    vector<pair<int,int>> a(n);
    for(int i=0; i<n; i++){
        cin >> num;
        auto lowerPos = lower_bound(v.begin(),v.end(),num);
        int _pos = lower_bound(v.begin(),v.end(),num) - v.begin();
        if(*lowerPos == 1004) len++;
        *lowerPos = num;
        a[i].first = _pos;
        a[i].second = num;
    }

    cout << len << "\n";
    for(int i=n-1; i>=0; i--){
        if(a[i].first == len-1) {
            stk.push(a[i].second);
            len--;
        }
    }

    while(stk.size()){
        cout << stk.top() << " ";
        stk.pop();
    }


    return 0;
}