#include <bits/stdc++.h>
using namespace std;

int n, m, ret;
string s;
int a[54];

void check(int learn){
    int cnt = 0;
    for(int i=0; i<n; i++){
        if((a[i] & learn) == a[i]) cnt++;
    }
    ret = max(ret,cnt);
    return;
}

void go(int idx, int count, int learn){
    if(count < 0) return;
    if(idx == 26) {
        check(learn);
        return;
    }
    go(idx+1, count-1, learn | (1<<idx));
    if(idx != 'a'-'a' && idx != 'n'-'a' && idx != 't'-'a' && idx != 'i'-'a' && idx != 'c'-'a'){
        go(idx+1,count,learn);
    }
    return;
}
int main(){
    cin >> n >> m;
    for(int i=0; i<n; i++){
        cin >> s;
        for(char str : s){
            a[i] |= (1<<(str-'a'));
        }
    }

    go(0,m,0);

    cout << ret << "\n";
    return 0;
}

// a. 단어마다 하나의 숫자로 저장하고
// b. 단어 학습
//  1. 바로학습
//  2. a,n,t,i,c 제외하 경우는 안배울수있음.
// c. idx == 26인 경우는 z까지 오면서 배울단어를 모두 고른상태에서 check해서 배운것과 단어들의 값을 비교