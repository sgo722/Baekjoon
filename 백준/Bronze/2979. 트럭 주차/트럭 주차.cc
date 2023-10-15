#include <bits/stdc++.h>
using namespace std;

int a,b,c;
int park[104];
int s,e, ret;
int main(){
    cin >> a >> b >> c;
    for(int i=0; i < 3; i++){
        cin >> s >> e;
        for(int j=s; j<e; j++){
            park[j]++;
        }
    }

    for(int i=0; i<100; i++){
        if(park[i] == 3) ret += c * 3;
        else if(park[i] == 2) ret += b * 2;
        else if(park[i] == 1) ret += a;
    }

    cout << ret << '\n';

    return 0;
}