#include <bits/stdc++.h>
using namespace std;

int n, m, true_cnt, num, cnt, partyCnt, join;
int visited[54];
int ans;
vector<int> v[54], truePerson;

int main(){
    cin >> n >> m;

    cin >> true_cnt;

    for(int i=0; i<true_cnt; i++){
        cin >> num;
        truePerson.push_back(num);
        visited[num] = 1;
    }

    for(int i=0; i<m; i++){
        cin >> partyCnt;
        for(int j=0; j<partyCnt; j++){
            cin >> join;
            v[i].push_back(join);
        }
    }

    for(int x=0; x<m; x++) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < v[i].size(); j++) {
                if (std::find(truePerson.begin(), truePerson.end(), v[i][j]) != truePerson.end()) {
                    for (int k = 0; k < v[i].size(); k++) {
                        visited[v[i][k]] = 1;
                        truePerson.push_back(v[i][k]);
                    }
                }
            }
        }
    }

    for(int i=0; i<m; i++){
        int flag = 0;
        for(int j=0; j<v[i].size(); j++){
            if(visited[v[i][j]] == 1){
                flag = 1;
                break;
            }
        }
        if(flag == 0) cnt++;
    }

    cout << cnt << "\n";


    return 0;
}