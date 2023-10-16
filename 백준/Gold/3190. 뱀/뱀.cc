#include <bits/stdc++.h>
using namespace std;

int a[104][104];
int visited[104][104];
int v[104][104];
int n,k,r,c,x,l;
char cmd;
pair<int,int> head, tail;

queue<pair<int,char>> snake;
int turn = 0;

int dy[] = {0,1,0,-1};
int dx[] = {1,0,-1,0};
// 오른쪽으로 갑니다.

int main(){
    cin >> n;
    cin >> k;
    for(int i=0; i<k; i++){
        cin >> r >> c;
        a[r-1][c-1] = 1;
    }
    cin >> l;
    for(int i=0; i<l; i++){
        cin >> x >> cmd;
        snake.push({x,cmd});
    }
    int cnt = 0;
    head = {0,0};
    tail = {0,0};
    visited[0][0] = 1;
    while(1){
        int ty = tail.first;
        int tx = tail.second;
        int hy = head.first + dy[turn];
        int hx = head.second + dx[turn];
        head.first = hy;
        head.second = hx;

        cnt++;
        if(hy < 0 || hx < 0 || hy >= n || hx >= n) break;
        if(visited[hy][hx]) break;
        visited[hy][hx] = 1;
        if(a[hy][hx] == 0) { //사과가 아니면 이동한다.
            visited[tail.first][tail.second] = 0;
            ty = ty + dy[v[tail.first][tail.second]];
            tx = tx + dx[v[tail.first][tail.second]];
//            cout << tail.first << " " << tail.second << "\n";
            tail.first = ty;
            tail.second = tx;
        }
        else if(a[hy][hx] == 1){
            a[hy][hx] = 0;
        }

//        cout << hy << " " <<  hx <<  " " << ty << " " << tx << "\n";
        if(snake.size() && snake.front().first == cnt){
            if(snake.front().second == 'L'){
                turn -= 1;
                if(turn == -1) {
                    turn = 3;
                }
            }
            else if(snake.front().second == 'D'){
                turn += 1;
                if(turn == 4) turn = 0;
            }
            snake.pop();
        }
        v[hy][hx] = turn;
//        cout << hy << " " << hx << " " << turn << "\n";
    }

    cout << cnt << "\n";
    return 0;
}

// 머리 이동, 사과있으면 몸길이 증가, 없으면 꼬리칸이동