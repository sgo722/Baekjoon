#include <stdio.h>

int main() {
    int N;
    int cnt = 1, result = 1;
    scanf("%d", &N);

    for(int i=0; ; i++){
        result = result + 6*i;
        if(result < N){
            cnt++;
        }
        else{
            break;
        }
    }

    printf("%d", cnt);

    return 0;
}