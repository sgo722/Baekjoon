#include <stdio.h>

int main()
{
    int a, b, cnt, i = 1;

    scanf("%d",&cnt);

    do
    {
        scanf("%d %d", &a, &b);
        printf("Case #%d: %d\n", i,a+b);
        i++;
    }while (i <= cnt);
    return 0;
}