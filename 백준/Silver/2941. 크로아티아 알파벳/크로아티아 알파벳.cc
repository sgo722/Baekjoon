#include <stdio.h>
#include <string.h>

int main() {
    char word[100];
    int cnt=0, len;

    scanf("%s", word);
    len = strlen(word);

    for(int i=0; i<len ;i++) {
        if (word[i] == 'c' || word[i] == 'd' || word[i] =='l' || word[i] =='n' || word[i] =='s' || word[i] == 'z') {
            if (word[i] == 'l') {
                if (word[i + 1] == 'j') {
                    cnt++;
                    i = i + 1;
                } else {
                    cnt++;
                }
            }
            if (word[i] == 'n') {
                if (word[i + 1] == 'j') {
                    cnt++;
                    i = i + 1;
                } else {
                    cnt++;
                }
            }

            if (word[i] == 'c') {
                if (word[i + 1] == '-') {
                    cnt++;
                    i = i + 1;
                }
                else if(word[i + 1] == '='){
                    cnt++;
                    i = i+1;
                }
                else {
                    cnt++;
                }
            }

            if (word[i] == 'd') {
                if (word[i + 1] == 'z' && word[i + 2] == '=') {
                    cnt++;
                    i = i + 2;
                } else if (word[i + 1] == '-') {
                    cnt++;
                    i = i + 1;
                } else cnt++;
            }

            if (word[i] == 's') {
                if (word[i + 1] == '=') {
                    cnt++;
                    i = i + 1;
                } else cnt++;
            }

            if (word[i] == 'z') {
                if (word[i + 1] == '=') {
                    cnt++;
                    i = i + 1;
                } else {
                    cnt++;
                }
            }
        }
        else {
            cnt++;
        }
    }

    printf("%d", cnt);
    return 0;
}