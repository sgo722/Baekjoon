#include <bits/stdc++.h>
using namespace std;

string a, ans, sortA;
int b, flag;

void go(string s, int cnt, int start){
    if(cnt == b){
        ans = max(ans, s);
        return;
    }

    for(int i=start; i<s.size(); i++){
        for(int j=i+1; j<s.size(); j++){
            swap(s[i],s[j]);
            go(s,cnt+1,i);
            swap(s[j], s[i]);
        }
    }
}

int main(int argc, char** argv)
{
    int test_case;
    int T;

    cin>>T;
    for(test_case = 1; test_case <= T; ++test_case){
        flag = 0;
        ans.clear();
        cin >> a >> b;
        sortA = a;
        sort(sortA.rbegin(),sortA.rend());
        b = b > 6 ? 6 : b;
        go(a,0, 0);
        if(flag == 0) {
            cout << "#" << test_case << " " + ans << "\n";
        }
    }
    return 0;
}