/* sine-cosine */
#include <stdio.h>
#include <math.h>
#include <stdlib.h>

#define NPOINTS 1000

//void drawline(double f, int max);
void drawrows(double *y, unsigned npts, unsigned cols, unsigned rows);

int main(int argc, char** argv)
{
    unsigned npoints, i;
    unsigned linelength, nrows;
    double beat;
    double x, y[NPOINTS];

    if (argc < 5) {
        printf("usage: %s <npoints> <beat> <linelength> <nrows> \n", argv[0]);
        return -1;
    }
    npoints = strtol(argv[1], NULL, 10);
    beat = strtod(argv[2], NULL);
    linelength = strtol(argv[3], NULL, 10);
    nrows = strtol(argv[4], NULL, 10);

    for (i = 0; i <= npoints - 1 && i < NPOINTS; i++) {
        x = i / 5.0;
        y[i] = sin(x) * cos(beat * x);
    }
    printf("\n");
    drawrows(y, (npoints <= NPOINTS ? npoints : NPOINTS), linelength, nrows);

    return 0;
}
