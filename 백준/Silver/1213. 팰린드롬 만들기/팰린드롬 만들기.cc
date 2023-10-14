#include <bits/stdc++.h>
using namespace std;

int cnt[26];
string s, ret, temp;
int main(){
    cin >> s;
    for(int i=0; i<s.length(); i++){
        cnt[s[i]-'A']++;
    }

    for(int i=0; i<26; i++){
        if(cnt[i] % 2 == 1){
            ret += (char)(i+'A');
            cnt[i]--;
        }
    }

    for(int i=25; i>=0; i--){
        if(cnt[i] == 0) continue;
        while(1){
            ret = (char)(i+'A') + ret + (char)(i+'A');
            cnt[i]-=2;
            if(cnt[i] == 0) break;
        }
    }

    temp = ret;
    reverse(temp.begin(),temp.end());
//    cout << temp << "\n";
    if(temp == ret) cout << ret << "\n";
    else cout << "I'm Sorry Hansoo" << "\n";

    return 0;
}