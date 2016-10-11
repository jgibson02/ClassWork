/* ptr-arithmetic demo
 * 2016-10-11
 */
#include <stdio.h>

#define ASIZE 8

int main(int argc, char** argv) {
    double ary[ASIZE];
    int i;
    double *pa;

    for (i = 0; i < ASIZE; i++) ary[i] = i/(1.0 + i);
    printf("ary: %p\n", ary);
    for (i = 0; i < ASIZE; i++) printf("%p   %lf\n", &ary[i], ary[i]);

    return 0;
}
