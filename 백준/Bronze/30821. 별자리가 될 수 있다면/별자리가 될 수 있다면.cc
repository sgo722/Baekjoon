#include <bits/stdc++.h>
using namespace std;

long long n, sum=1;
long long factorial(int num){
    if(num == 0 || num == 1) return 1;
    return num * factorial(num - 1);
}
int main(){
    cin >> n;
    for(int i=0; i<5; i++){
        sum *=  (n-i);
    }

    for(int i=1; i<=5; i++){
        sum /= i;
    }

    cout << sum << "\n";
    return 0;
}