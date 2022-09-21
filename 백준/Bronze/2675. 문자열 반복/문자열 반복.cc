#include <stdio.h>

int main() {
    char str[20] = {0};
    int T,R;
    scanf("%d", &T);

    for(int i=0; i<T; i++){
        scanf("%d %s", &R, str);

        for(int j = 0; j < 20; j++){
            if(str[j] == 0) break;
            else {
                for(int k=0; k<R; k++){
                    printf("%c",str[j]);
                }
            }
        }
        printf("\n");
    }
    return 0;
}