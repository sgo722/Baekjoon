#include <stdio.h>

int main()
{
    int n, sum=0;
    scanf("%d", &n);
    char num[n];
    scanf("%s", num);

    for(int i=0; i<n; i++){
        sum = sum + num[i] - '0';
    }

    printf("%d", sum);


    return 0;
}