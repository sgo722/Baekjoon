#include <bits/stdc++.h>
using namespace std;
#define INF 2000000000

int a[129][129];
int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};
int dist[129][129];
int n;

void dijkstra(){
    priority_queue<pair<int,pair<int,int>>> pq;
    pq.push(make_pair(-1 * a[0][0], make_pair(0,0)));
    dist[0][0] = a[0][0];

    while(!pq.empty()){
        int y = pq.top().second.first;
        int x = pq.top().second.second;
        pq.pop();

        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            int ncost = a[ny][nx];

            if(ny >= 0 && ny < n && nx >= 0 && nx < n){
                int before_v = dist[ny][nx];
                int current_v = dist[y][x] + ncost;
                if(before_v > current_v){
                    dist[ny][nx] = current_v;
                    pq.push(make_pair(-1 * current_v, make_pair(ny,nx)));
                }
            }
        }
    }
}
int main(){
    int cnt = 1;
    while(1) {
        memset(a, 0, sizeof(a));
        fill(&dist[0][0], &dist[0][0] + 129 * 129, INF);
        cin >> n;
        if (n == 0) break;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> a[i][j];
            }
        }
        dijkstra();
        cout << "Problem " << cnt++ << ": " << dist[n - 1][n - 1] << "\n";
    }
    return 0;
}