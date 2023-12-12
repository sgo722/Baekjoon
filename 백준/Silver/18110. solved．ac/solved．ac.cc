#include <bits/stdc++.h>
using namespace std;

int n, num, sum;
double avg;
vector<int> v;
int main(){
    cin >> n;
    if(n == 0) { 
        cout << 0 << "\n";
        return 0;
    }
    for(int i=0; i<n; i++){
        cin >> num;
        v.push_back(num);
    }

    sort(v.begin(),v.end());
    int l = round(n * 0.15);
    int r = n-round(n*0.15);
    r--;

    for(int i=0; i<n; i++){
        if(i < l) continue;
        if(i > r) continue;
        sum += v[i];
    }
    avg = (double)sum / (r-l+1);
//    cout << avg << "\n";

    cout << round(avg) << "\n";
    return 0;
}