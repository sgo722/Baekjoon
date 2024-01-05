#include <bits/stdc++.h>
using namespace std;

int n;
int v[100004];
int main(){
    while(cin >> n){
        if(n == -1) break;
        memset(v,0,sizeof(v));
        int sum = 0, cnt = 0;
        for(int i=1; i<n; i++){
            if(n % i == 0) {
                v[i] = 1;
                sum += i;
                cnt++;
            }
        }
        if(n == sum){
            int count = 0;
            cout << n << " = ";
            for(int i=1; i<n; i++){
                if(v[i] == 1){
                    cout << i;
                    count++;
                    if(count == cnt) {
                        cout << "\n";
                        break;
                    }
                    cout << " + ";
                }
            }
        }
        else{
            cout << n << " is NOT perfect.\n";
        }
    }
    return 0;
}