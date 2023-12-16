#include <bits/stdc++.h>
using namespace std;
#define INF 2000000004

int n, kcal, myCost, temp, my, cost;
int dp[10004];
vector<pair<int,int>> candy;

int main(){

    while(1) {
        candy.clear();
        scanf("%d %d.%d", &n, &my, &temp);
        if(n == 0 && my == 0 && temp == 0) break;
        myCost = my * 100 + temp;
        fill(&dp[0], &dp[0]+10004, 0);
        for(int i=0; i<n; i++){
            scanf("%d %d.%d", &kcal, &cost, &temp);
            int loadCost = cost * 100 + temp;
//            cout << kcal << " " << loadCost << "\n";
            candy.push_back({kcal, loadCost});
        }

        for(int i=1; i<=myCost; i++){
            for(int j=0; j<n; j++){
                if(i-candy[j].second < 0) continue;
                dp[i] = max(dp[i], dp[i-candy[j].second] + candy[j].first);
            }
        }
        cout << dp[myCost] << "\n";
    }
    return 0;
}