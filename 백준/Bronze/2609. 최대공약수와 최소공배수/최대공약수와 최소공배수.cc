#include <bits/stdc++.h>
using namespace std;

int a,b;

int gcd(int a, int b){
    if(a==0) return b;
    return gcd(b%a,a);
}

int lcm(int a, int b){
    return a*b / gcd(a,b);
}
int main(){
    cin >> a >> b;

    cout << gcd(a,b) << "\n" << lcm(a,b) << "\n";
    return 0;
}