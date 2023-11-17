#include <bits/stdc++.h>
using namespace std;

int cnt;
string s;
string ch[12][12];
int n;

int check(string s){
    string temp;
    temp = s;
    std::reverse(temp.begin(), temp.end());
    if(s == temp) return 1;
    return 0;
}

int main(){
    int test_case;

    int t;

    for(test_case = 1; test_case <= 10; ++test_case) {
        cin >> n;
        cnt = 0;

        for(int i=0; i<8; i++){
            cin >> s;
            for(int j=0; j<8; j++){
                ch[i][j] = s[j];
            }
        }

        for(int i=0; i<=7; i++){
            for(int j=0; j<=8-n; j++){
                string temp = "";
                for(int k=0; k<n; k++)
                temp += ch[i][j+k];
                if(check(temp)){
                    cnt++;
                }
            }
        }

        for(int i=0; i<=8-n; i++){
            for(int j=0; j<=7; j++){
                string temp = "";
                for(int k=0; k<n; k++)
                temp += ch[i+k][j];
                if(check(temp)){
                    cnt++;
                }
            }
        }

        cout << "#" << test_case << " " << cnt << "\n";
    }
    return 0;
}