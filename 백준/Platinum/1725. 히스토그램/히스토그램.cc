#include <bits/stdc++.h>
using namespace std;

int n, num, ans;
stack<int> stk;
vector<int> v;

int main(){
    cin >> n;
    v.push_back(0);
    for(int i=0; i<n; i++){
        cin >> num;
        v.push_back(num);
    }
    v.push_back(0);

    for(int i=0; i<=n+1; i++){
        if(!stk.empty() && v[stk.top()] > v[i]) {
            while (v[stk.top()] > v[i]) {
                int top = stk.top();
                stk.pop();
                ans = max(ans, v[top] * (i-stk.top()-1));
                if(stk.empty()) break;
            }
        }
        stk.push(i);
    }
    cout << ans << "\n";

    return 0;
}