#include <bits/stdc++.h>
using namespace std;

int n,m,s,e,value;
int a[104];
int main(){
    cin >> n >> m;

    for(int i=0; i<m; i++){
        cin >> s >> e >> value;
        for(int i=s; i<=e; i++){
            a[i] = value;
        }
    }

    for(int i=1; i<=n; i++){
        cout << a[i] << " ";
    }
    return 0;
}