#include <stdio.h>

int main()
{
    int hour, minute;

    scanf("%d %d", &hour, &minute);

    if(minute >= 45)
    {
        minute -= 45;
        printf("%d %d", hour, minute);
    }
    else if(minute >= 0)
    {
        minute -= 45;
        hour = hour - 1;
        minute = 60 + minute;
        if (hour < 0)
        {
            hour = 24 + hour;
            printf("%d %d",hour, minute);
        }
        else
        {
            printf("%d %d", hour, minute);
        }

    }

    return 0;
}