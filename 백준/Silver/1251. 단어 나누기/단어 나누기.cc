#include <bits/stdc++.h>
using namespace std;


string s, s1,s2,s3, ans="zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";

int main(){
    cin >> s;

    for(int i=1; i<s.size()-2; i++){
        s1 = s.substr(0,i);
        reverse(s1.begin(),s1.end());
        for(int j=1; i+j<s.size(); j++){
            s2 = s.substr(i,j);
            s3 = s.substr(i+j);
            reverse(s2.begin(),s2.end());
            reverse(s3.begin(),s3.end());
            ans = min(ans,s1+s2+s3);

//            cout << s1 << " " << s2 << " " << s3 << "\n";
        }
    }
    cout << ans << "\n";

//    cout << ans << "\n";
    return 0;
}

/**
* 단어 나누기
 * 시작 - 21:27
 * 단어를 나누고 뒤집고 붙인다.
 * 0부터 i-1까지 1구간
 * i부터 j-1까지 2구간
 * j부터 끝까지 3구간
 * 각각의 단어들을 뒤집어서 붙인다.
 *
 *
*/