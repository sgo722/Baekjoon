#include <bits/stdc++.h>
using namespace std;

const long long INF = 1e10;
long long n, num, max_num = -INF;
long long  sum = 0;
vector<int> v;
int main(){
    cin >> n;

    for(int i=0; i<n; i++){
        cin >> num;
        v.push_back(num);
    }

    int pt,qt;
    pt = 0;
    qt = 0;
    sum = v[pt];
    while(1){
        if(pt < qt){
            sum += v[qt];
        }
        max_num = max(max_num, sum);
        qt++;
        if(qt == n) break;
        if(sum < 0){
            pt = qt;
            sum = v[pt];
        }
    }

    cout << max_num << "\n";
    return 0;
}