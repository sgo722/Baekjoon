#include <bits/stdc++.h>
using namespace std;

int n,m, num;
vector<int> v;


// 구글링으로 본 코드
// 1. 이진탐색 로직이 궁금했습니다.
// 2. 원래 작성한 코드와 시간차이를 확인해보고 싶었습니다.
void binarySearch(int key){
    int start = 0;
    int end = n-1;
    int mid;

    while(end >= start){
        mid = (start+end)/2;
        if(v[mid] == key){
            cout << 1 << "\n";
            return;
        }
        if(v[mid] > key){
            end = mid - 1;
        }
        else if(v[mid] <= key){
            start = mid + 1;
        }
    }
    cout << 0 << "\n";
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> num;
        v.push_back(num);
    }

    sort(v.begin(),v.end());

    cin >> m;
    for(int i=0; i<m; i++){
        cin >> num;
        binarySearch(num);
    }
    return 0;
}