#include <stdio.h>

int main(){
    int T;
    int H,W,N;
    int floor, count;
    int client[10000];
    scanf("%d", &T);

    for(int i=0; i<T; i++){
        scanf("%d %d %d", &H, &W, &N);

        if(N % H == 0){
            floor = H;
            count = (N/H);
        }
        else {
            floor = N % H;
            count = (N/H)+1;
        }
        client[i] = floor * 100 + count;
    }

    for(int i=0; i<T; i++){
        printf("%d\n", client[i]);
    }
    return 0;
}