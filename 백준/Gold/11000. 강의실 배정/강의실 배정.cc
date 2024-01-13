#include <bits/stdc++.h>
using namespace std;

int n,s,e, cnt, ans;
vector<pair<int,int>> vec;
priority_queue<int> pq;
int main(){
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> s >> e;
        vec.push_back({s,e});
    }
    sort(vec.begin(),vec.end());
    for(int i=0; i<vec.size(); i++){
        while(pq.size() && -pq.top() <= vec[i].first){
            pq.pop();
            cnt--;
        }
        pq.push(-vec[i].second);
        cnt++;
        ans = max(ans,cnt);
    }

    cout << ans << "\n";

    return 0;
}

/**
 * 시작 : 15:32
 * 문제점 :
 * 1. 어떻게 빈 강의실이라고 할 수 있는
 * 아이디어 :
 * 1. 시작시간대로 정렬한다.
 * 2. 끝나는 시간을 우선순위 큐에 넣고 다음 차례에 잇는 시작시간보다 작으면 큐에서 뺀다.
 * 3. 최대값을 업데이트한다.
 */
