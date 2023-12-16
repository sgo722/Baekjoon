#include <bits/stdc++.h>
using namespace std;

int dy[] = {-1,-1,-1,0,0,1,1,1};
int dx[] = {-1,0,1,-1,1,-1,0,1};
int n,m,k,y,x,z;

int curYang[14][14];
int plusYang[14][14];
vector<int> mp[14][14];
struct tree{
    int y;
    int x;
    int age;
};
queue<tree> dead;

void spring(){

    for(int r=1; r<=n; r++){
        for(int c=1; c<=n; c++){
            sort(mp[r][c].begin(),mp[r][c].end());
        }
    }

    for(int r=1; r<=n; r++){
        for(int c=1; c<=n; c++){
            for(int i=0; i < mp[r][c].size(); i++){
                if(curYang[r][c] >= mp[r][c][i]){
                    curYang[r][c] -= mp[r][c][i];
                    mp[r][c][i]++;
                }
                else{
                    dead.push({r,c,mp[r][c][i]});
                    mp[r][c].erase(mp[r][c].begin()+i);
                    i--;
                }
            }
        }
    }
}

void summer(){
    while(dead.size()){
        curYang[dead.front().y][dead.front().x] += (dead.front().age / 2);
        dead.pop();
    }
}

void fall(){
    for(int r=1; r<=n; r++){
        for(int c=1; c<=n; c++){
            for(int i=0; i<mp[r][c].size(); i++){
                if(mp[r][c][i] > 0 && mp[r][c][i] % 5 == 0){
                    for(int j=0; j<8; j++){
                        int ny = r + dy[j];
                        int nx = c + dx[j];
                        if(ny < 1 || nx < 1 || ny > n || nx > n) continue;
                        mp[ny][nx].push_back(1);
                    }
                }
            }
        }
    }
}

void winter(){
    for(int r=1; r<=n; r++){
        for(int c=1; c<=n; c++){
            curYang[r][c] += plusYang[r][c];
        }
    }
}

int main(){
    cin >> n >> m >> k;
    fill(&curYang[0][0], &curYang[0][0]+14*14, 5);

    // 1년마다 보충될 N*N 만큼 양분의 양을 입력받는다.
    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            cin >> plusYang[i][j];
        }
    }

    // M개만큼 나무에 대해서 입력받는다.
    // x, y는 나무의 위치를 의미하고, z는 나무의 나이를 의미한다.
    for(int i=0; i<m; i++){
        cin >> y >> x >> z;
        mp[y][x].push_back(z);
    }
    while(k > 0){
        k--;
        spring();
        summer();
        fall();
        winter();
    }
    int answer = 0;
    for(int r = 1; r<=n; r++){
        for(int c=1; c<=n; c++){
            answer += mp[r][c].size();
        }
    }
    cout << answer << "\n";

    return 0;
}