#include <bits/stdc++.h>
using namespace std;

int n, num;
priority_queue<int> pq;
/**
 * 문제시작 - 23:47
 * 아이디어
 * 우선순위큐를 사용하면 되지않나?
 * 자바로 우선순위큐를 선언하고 사용할줄 몰라서 C++로 풀어봄.
 * 다른 방법 생각 안나서 입출력속도 향상 추가
 * */
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> n;

    for(int i=0; i<n; i++){
        cin >> num;
        if(num == 0) {
            if (pq.size() == 0) {
                cout << 0 << "\n";
            } else {
                cout << pq.top() << "\n";
                pq.pop();
            }
        }else{
            pq.push(num);
        }
    }
    return 0;
}