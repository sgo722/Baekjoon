#include <bits/stdc++.h>
using namespace std;

int n,m, a,b;
vector<int> v[32004];
int visited[32004];
int first[32004];
int inDegree[32004];
queue<int> ret;

int main(){

    cin >> n >> m;

    for(int i=0; i<m; i++){
        cin >> a >> b;
        v[a].push_back(b);
        inDegree[b]++;
    }


    queue<int> q;
    for(int i=1; i<=n; i++) {
        if (inDegree[i] == 0) {
            ret.push(i);
            q.push(i);
        }
    }
    while(1){

        int Qsize = q.size();
        for(int i=0; i<Qsize; i++) {
            int here = q.front();
            q.pop();
            for (int there: v[here]) {
                inDegree[there]--;
                if(inDegree[there] == 0) {
                    q.push(there);
                    ret.push(there);
                }
            }
        }
        if(q.size() == 0) break;
    }

    while(ret.size()){
        cout << ret.front() << " ";
        ret.pop();
    }
    return 0;
}

//나보다 앞서있다면 내가 찾아가서 뒤로 이동하면되지않나?