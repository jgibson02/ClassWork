#include <stdio.h>
#include <math.h>

int main(int argc, char** argv) {
    float v;
    float p;

    printf("Enter value, and power: ");
    scanf(" %f %f", &v, &p);

    printf("%f to %f power is %lf\n", pow(v, p));
    return 0;
}
