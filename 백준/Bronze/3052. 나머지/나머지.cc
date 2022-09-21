#include <stdio.h>

int main()
{
    int num[10]={0};
    int mod[42]={0};
    int cnt = 0;

    for(int i=0; i<10; i++)
    {
        scanf("%d", &num[i]);
        mod[num[i]%42]++;
    }

    for(int j=0; j<42; j++)
    {
        if(mod[j]!=0)
        {
            cnt++;
        }
    }

    printf("%d",cnt);
    return 0;
}