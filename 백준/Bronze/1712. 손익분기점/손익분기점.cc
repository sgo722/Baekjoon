#include <stdio.h>

int main() {
    int A, B, C, N;

    scanf("%d %d %d", &A, &B, &C);

    if(C-B > 0) {
        N = A / (C-B) + 1;
        printf("%d", N);
    }
    else{
        printf("-1");
    }
    return 0;
}