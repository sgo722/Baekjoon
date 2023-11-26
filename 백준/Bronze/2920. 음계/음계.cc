#include <bits/stdc++.h>
using namespace std;

string s;
char ch;
int main(){

    for(int i=0; i<8; i++){
        cin >> ch;
        s += ch;
    }
    string temp;

    temp = s;

    sort(temp.begin(),temp.end());

    if(temp == s){
        cout << "ascending" << "\n";
        return 0;
    }
    sort(temp.begin(),temp.end(),greater<>());
    if(temp == s){
        cout << "descending" << "\n";
        return 0;
    }
    cout << "mixed" << "\n";


    return 0;
}