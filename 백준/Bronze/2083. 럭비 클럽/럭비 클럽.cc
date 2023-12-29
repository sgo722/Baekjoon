#include <bits/stdc++.h>
using namespace std;

string s;
int a, b;
int main(){
    while(1) {
        cin >> s >> a >> b;
        if(s == "#" && a == 0 && b == 0) {
            break;
        }
        else if(a > 17 || b >= 80){
            cout << s << " Senior\n";
        }
        else{
            cout << s << " Junior\n";
        }

    }
    return 0;
}