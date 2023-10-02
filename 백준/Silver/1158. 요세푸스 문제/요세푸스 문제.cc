#include <bits/stdc++.h>
using namespace std;

int n, k;
queue<int> q1,q2;
int main(){
    cin >> n >> k;

    for(int i=1; i<=n; i++){
        q1.push(i);
    }

    while(q1.size()){
        for(int i=1; i<k; i++){
            q1.push(q1.front());
            q1.pop();
        }
        q2.push(q1.front());
        q1.pop();
    }
    int Qsize = q2.size();

    cout << "<";
    for(int i=0; i<Qsize-1; i++){
        cout << q2.front() << ", ";
        q2.pop();
    }
    cout << q2.front() << ">";


    return 0;
}