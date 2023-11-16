
#include <bits/stdc++.h>

using namespace std;

int main(int argc, char** argv)
{
    int test_case;
    int T;

    for(test_case = 1; test_case <= 10; ++test_case){
        int length;
        int cnt, t;
        cnt = 0;
//        memset(a,0,sizeof(a));
        int a[2000];
        cin >> length;

        for (int j = 0; j < length; j++) {
            cin >> a[j];
        }

        for (int j = 2; j < length - 2; j++) {
            int retA = max(a[j-2],a[j-1]);
            int retB = max(a[j+1],a[j+2]);
            int ret = max(retA, retB);
            if(a[j] - ret <= 0) continue;
            cnt += (a[j]-ret);
        }
        cout << "#" << test_case << " " << cnt << "\n";
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}