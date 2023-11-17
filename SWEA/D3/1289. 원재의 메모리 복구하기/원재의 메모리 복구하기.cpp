#include <bits/stdc++.h>
using namespace std;

int ans, flag, cnt;
string s;
int main(){
    int test_case;

    int t;
    cin >> t;
    for(test_case = 1; test_case <= t; ++test_case) {
        cin >> s;
        cnt = 0;
        flag = 1;
        for(int i=0; i<s.size(); i++){
            if((s[i]-'0') == flag){
                flag = !flag;
                cnt++;
            }
        }

        cout << "#" << test_case << " " << cnt << "\n";
    }
    return 0;
}