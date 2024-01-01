#include <bits/stdc++.h>
using namespace std;

int a, b, flag;
vector<string> v = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
int main(){
    cin >> a >> b;
    int cnt = 0;
    for(int i=1; i<=12; i++){
        for(int j=1; j<=31; j++){
            cnt = (cnt + 1) % 7;
            if(i == a && j == b){
                flag = 1;
                break;
            }
            if(i == 4 || i == 6 || i == 9 || i == 11){
                if(j == 30){
                    break;
                }
            }
            else if(i == 2){
                if(j == 28){
                    break;
                }
            }
        }
        if(flag) break;
    }
    cout << v[cnt] << "\n";
    return 0;
}