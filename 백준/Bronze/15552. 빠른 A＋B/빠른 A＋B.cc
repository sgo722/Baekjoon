#include <stdio.h>

int main()
{
    int cnt, a, b;
    scanf("%d",&cnt);

    for(int i = 1; i <= cnt ; i++)
    {
        scanf("%d %d", &a, &b);
        printf("%d\n",a+b);
    }
    return 0;
}