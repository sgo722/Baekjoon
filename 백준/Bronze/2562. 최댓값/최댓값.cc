#include <stdio.h>

int main()
{
    int a[9], max=0,cnt;
    for(int i=0;i<9;i++)
    {
        scanf("%d", &a[i]);
        if(a[i] > max)
        {
        max = a[i];
        cnt = i+1;
        }
    }
    printf("%d\n%d", max, cnt);
    return 0;
}