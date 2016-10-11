/* rot-N demo
 * 2016-09-22
 */
#include <stdio.h>
#include <stdlib.h>  // atol()

#define MAXSIZE 200

int main(int argc, char** argv)
{
    char input[MAXSIZE], output[MAXSIZE];
    char c;
    char *retval;
    unsigned i, rotate;
    int isLower, isUpper;

    if (argc != 2) {
        rotate = 13;
    } else {
        rotate = atol(argv[1]);
    }
    printf("Rotating by %u\nEnter plaintexts.\nEnd with empty line.\n", rotate);
    do {
        retval = fgets(input, MAXSIZE, stdin);
        if (retval == NULL) {
            break;
        }
        for (i = 0; input[i] != '\0'; i++) {
            c = input[i];
            isLower = ((c >= 'a') & (c <= 'z'));
            isUpper = ((c >= 'A') & (c <= 'Z'));
            if (isLower) {
                c -= 'a';
                c = (c + rotate) % 26;
                c += 'a';
            } else if (isUpper) {
                c -= 'A';
                c = (c + rotate) % 26;
                c += 'A';
            }
            output[i] = c;
        }
        output[i] = '\0';

        printf("Encoded: \n%s\n", output);
    } while (1);

    return 0;
}
