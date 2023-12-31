#include <bits/stdc++.h>
using namespace std;

string s;
vector<char> m = {'a','i','y','e','o','u'};
vector<char> M = {'A','I','Y','E','O','U'};

vector<char> j = {'b','k','x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm','f'};
vector<char> J = {'B','K','X', 'Z', 'N', 'H', 'D', 'C', 'W', 'G', 'P', 'V', 'J', 'Q', 'T', 'S', 'R', 'L', 'M','F'};

int check(char ch){
    if(ch == 'a' || ch == 'e' || ch == 'y' || ch == 'i' || ch == 'o' || ch == 'u'){
        return 1;
    }
    else if(ch == 'A' || ch == 'E' || ch == 'Y' || ch == 'I' || ch == 'O' || ch == 'U'){
        return 2;
    }
    else if(ch >= 'a' && ch <= 'z'){
        return 3;
    }
    else if(ch >= 'A' && ch <= 'Z'){
        return 4;
    }
    return 0;
}
int main(){
    while(getline(cin,s)) {

        for (int i = 0; i < s.size(); i++) {
            int temp = check(s[i]);
            if (temp == 0) continue;
            if (temp == 1) {
                s[i] = m[(find(m.begin(), m.end(), s[i]) - m.begin() + 3) % 6];
            } else if (temp == 2) {
                s[i] = M[(find(M.begin(), M.end(), s[i]) - M.begin() + 3) % 6];
            } else if (temp == 3) {
                s[i] = j[(find(j.begin(), j.end(), s[i]) - j.begin() + 10) % 20];
            } else {
                s[i] = J[(find(J.begin(), J.end(), s[i]) - J.begin() + 10) % 20];
            }
        }

        cout << s << "\n";
    }
    return 0;
}