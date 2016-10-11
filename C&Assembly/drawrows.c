/* draw a horizontal x-y graph in ASCII
 * 2016-09-20
 */
#include <stdio.h>
#include <math.h>   // round()

void drawrows(double *y, unsigned npts, unsigned cols, unsigned rows)
{
    unsigned c, r;
    unsigned point;
    float threshold;

    for (r = 0; r < rows; r++)
    {
        threshold = 1.0 - 2.0 * ((float) r / (float) rows);
        for (c = 0; c < cols; c++)
        {
            point = round((float) npts * ((float) c / (float) cols));

            if (r == rows / 2) {
                putchar('-');
            } else if (threshold > 0) {
                putchar(y[point] < 0 || threshold > y[point] ? ' ' : '*');
            } else if (threshold < 0) {
                putchar(y[point] > 0 || threshold < y[point] ? ' ' : '*');
            } else {
                putchar('+');
            }
        }
        putchar('\n');
    }
}
