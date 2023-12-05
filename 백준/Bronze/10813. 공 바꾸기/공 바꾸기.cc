#include <bits/stdc++.h>
using namespace std;

int n,m,a,b;
int arr[104];
int main(){
    cin >> n >> m;
    for(int i=0; i<n; i++){
        arr[i] = i+1;
    }

    for(int i=0; i<m; i++){
        cin >> a >> b;
        int tmp = arr[a-1];
        arr[a-1] = arr[b-1];
        arr[b-1] = tmp;
    }

    for(int i=0; i<n; i++){
        cout << arr[i] << " ";
    }
    return 0;
}