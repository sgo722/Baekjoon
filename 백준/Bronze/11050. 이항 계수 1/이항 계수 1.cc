#include <bits/stdc++.h>
using namespace std;


int n,k;

int factorial(int num){
    if(num == 1 || num == 0) return 1;
    return num * factorial(num-1);
}
int main(){
    cin >> n >> k;
    cout << factorial(n) / (factorial(k) * factorial(n-k));
    return 0;
}