#include <stdio.h>

int main()
{
    int a, b, c, d, e;

    scanf("%d %d", &a, &b);

    c = b % 10;
    d = (b/10)%10;
    e = b / 100;

    printf("%d\n",a*c);
    printf("%d\n",a*d);
    printf("%d\n",a*e);
    printf("%d\n",a*b);
    
    return 0;
}