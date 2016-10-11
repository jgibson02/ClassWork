/* field-width demo
 * 2016-09-13
 */
#include <stdio.h>

int main(int argc, char** argv) {
    unsigned i;
    for (i = 0; i < 10; i++) {
        printf("%*.2f\n", i, 1.33333);
    }
    return 0;
}
