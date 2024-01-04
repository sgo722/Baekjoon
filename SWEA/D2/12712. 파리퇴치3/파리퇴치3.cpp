#include <bits/stdc++.h>
using namespace std;


int t,maxNum;
int n,m;
int a[19][19];

int checkPlus(int y, int x){
    int cnt = a[y][x];

    for(int i=1; i<m; i++){
        if(x-i >= 0 && x-i < n) cnt += a[y][x-i];
        if(x+i >= 0 && x+i < n) cnt += a[y][x+i];
        if(y-i >= 0 && y-i < n) cnt += a[y-i][x];
        if(y+i >= 0 && y+i < n) cnt += a[y+i][x];
    }
    return cnt;
}

int checkX(int y, int x){
    int cnt = a[y][x];

    for(int i=1; i<m; i++){
        if(y-i >= 0 && y-i < n && x-i >= 0 && x-i < n) cnt += a[y-i][x-i];
        if(y-i >= 0 && y-i < n && x+i >= 0 && x+i < n) cnt += a[y-i][x+i];
        if(y+i >= 0 && y+i < n && x+i >= 0 && x+i < n) cnt += a[y+i][x+i];
        if(y+i >= 0 && y+i < n && x-i >= 0 && x-i < n) cnt += a[y+i][x-i];
    }

    return cnt;
}

int main(){
    cin >> t;

    for(int test_case = 1; test_case <= t; test_case++){
        maxNum = 0;
        cin >> n >> m;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                cin >> a[i][j];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                maxNum = max(maxNum,checkX(i,j));
                maxNum = max(maxNum,checkPlus(i,j));
            }
        }

        cout << "#" << test_case << " " <<  maxNum << "\n";
    }
    return 0;
}