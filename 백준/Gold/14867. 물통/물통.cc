#include <bits/stdc++.h>
using namespace std;
int a,b,c,d;
map<pair<int,int>, int> m;
queue<pair<int,int>> q;

//map을 사용해서 구현하는 부분도 놀랍고
// enqueue부분이 visited[ny][nx] = visited[y][x] + 1 이런 식으로 구현되어있는 것이라는 것도 신기하다.
// 그리고 29,30번째 라인을 보면 물통의 양의 합이 각 물통의 최대값을 넘어가는 경우의 로직을 익혀야겟다.
void enqueue(int x, int y, int d){
    if(m[{x,y}]) return;
    m[{x,y}] = d+1;
    q.push({x,y});
}

int bfs(int x, int y){
    m[{x,y}] = 1;
    q.push({x,y});
    while(!q.empty()){
        x = q.front().first;
        y = q.front().second;
        q.pop();

        enqueue(a,y,m[{x,y}]);
        enqueue(x,b,m[{x,y}]);
        enqueue(0,y,m[{x,y}]);
        enqueue(x,0,m[{x,y}]);
        enqueue(min(x+y,a), max(0,x+y-a),m[{x,y}]);
        enqueue(max(0,x+y-b), min(x+y,b),m[{x,y}]);

    }
    if(m[{c,d}]) return m[{c,d}] - 1;
    else return -1;
}
int main(){
    cin >> a >> b >> c >> d;

    cout << bfs(0,0);
    return 0;
}
