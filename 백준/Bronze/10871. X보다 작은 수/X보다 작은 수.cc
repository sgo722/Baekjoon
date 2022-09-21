#include <stdio.h>

int main()
{
    int cnt, num1, num2[10000];

    scanf("%d %d",&cnt, &num1);

    for(int i = 0; i < cnt; i++)
    {
        scanf("%d",&num2[i]);
    }

    for(int i = 0; i < cnt; i++)
    {
        if(num1 > num2[i])
        {
            printf("%d ",num2[i]);
        }
    }


    return 0;
}