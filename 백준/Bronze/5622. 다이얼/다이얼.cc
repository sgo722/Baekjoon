#include <stdio.h>
#include <string.h>

int main() {
    char word[15];
    int len, cnt = 0;
    scanf("%s", word);
    len = strlen(word);

    for(int i=0; i<len; i++){
        switch(word[i]){
            case 'A' : cnt += 3; break;
            case 'B' : cnt += 3; break;
            case 'C' : cnt += 3; break;
            case 'D' : cnt += 4; break;
            case 'E' : cnt += 4; break;
            case 'F' : cnt += 4; break;
            case 'G' : cnt += 5; break;
            case 'H' : cnt += 5; break;
            case 'I' : cnt += 5; break;
            case 'J' : cnt += 6; break;
            case 'K' : cnt += 6; break;
            case 'L' : cnt += 6; break;
            case 'M' : cnt += 7; break;
            case 'N' : cnt += 7; break;
            case 'O' : cnt += 7; break;
            case 'P' : cnt += 8; break;
            case 'Q' : cnt += 8; break;
            case 'R' : cnt += 8; break;
            case 'S' : cnt += 8; break;
            case 'T' : cnt += 9; break;
            case 'U' : cnt += 9; break;
            case 'V' : cnt += 9; break;
            case 'W' : cnt += 10; break;
            case 'X' : cnt += 10; break;
            case 'Y' : cnt += 10; break;
            case 'Z' : cnt += 10; break;
        }
    }
    printf("%d", cnt);


    return 0;
}