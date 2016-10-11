/* drawline() function */
#include <stdio.h>

void drawline(double f, int max)
{
    double fscaled = (f + 1) / 2.0 * max;
    int c;
    for (c = 0; c < fscaled; c++) {
        putchar('-');
    }
    printf("%4.2f\n", f);
}
