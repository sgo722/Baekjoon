#include <stdio.h>

int main()
{
    int first,second,third, max, money;

    scanf("%d %d %d", &first, &second, &third);

    max = first > second ? (first > third ? first : third) : (second > third ? second : third);

    if(first==second && second == third)
    {
        money = 10000 + (first) * 1000; 
        printf("%d",money);
    }
    else if(first != second && second != third && first != third)
    {
        money = max * 100;
        printf("%d",money);
    }
    else
    {
        if(first == second)
        {
            money = 1000 + first * 100;
            printf("%d",money);
        }
        else if(first == third)
        {
            money = 1000 + first * 100;
            printf("%d",money);
        }
        else if(second == third)
        {
            money = 1000 + second * 100;
            printf("%d",money);
        }
    }
    return 0;
}