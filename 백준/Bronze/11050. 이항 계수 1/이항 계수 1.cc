#include <bits/stdc++.h>
using namespace std;


int n,k, ret, a;

int factorial(int k){
    if(k == 1) return 1;
    return k* factorial(k-1);
}
int main(){
    cin >> n >> k;
    ret = 1, a=1;
    for(int i=n; i>n-k; i--){
        ret *= i;
        a *= (n-i+1);
    }
    ret /= a;
    cout << ret << "\n";
    return 0;
}