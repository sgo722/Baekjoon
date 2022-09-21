#include <stdio.h>

int main() {
    int a, b, xa=0, xb=0;


    scanf("%d %d", &a, &b);

    while(a>0){
        xa = xa * 10 + a % 10;
        a /= 10;
    }

    while(b>0){
        xb = xb * 10 + b%10;
        b /= 10;
    }
    if(xa > xb){
        printf("%d", xa);
    }
    else {
        printf("%d", xb);
    }
    return 0;
}

//734 893