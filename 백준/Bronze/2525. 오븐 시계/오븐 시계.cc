#include <stdio.h>

int main()
{
    int h, m;
    int plus;
    int plush, plusm;

    scanf("%d %d", &h, &m);
    scanf("%d", &plus);

    plush = plus / 60;
    plusm = plus % 60;
    h = h  + plush;
    m = m + plusm;

    if(m >= 60)
    {
        h = h + 1;
        m = m % 60;
        if ( h >= 24 )
        {
            h = h % 24;
            printf("%d %d", h, m);
        }
        else
        {
            printf("%d %d",h, m);
        }
    }
    else if(m >= 0)
    {
        if ( h >= 24 )
        {
            h = h % 24;
            printf("%d %d", h, m);
        }
        else
        {
            printf("%d %d",h, m);
        }
    }
    return 0;
}