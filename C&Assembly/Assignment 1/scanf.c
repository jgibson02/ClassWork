/*
 * JOHN GIBSON
 * 2016-09-15
 * "scanf" program
 * Asks the user for a temperature and its corresponding degree scale, reports
 * the conversion of the temperature to the other degree scales in the set
 * "Fahrenheit, Celsius, Kelvin".
 */
#include <stdio.h>

int main(int argc, char** argv) {
    float temp;
    char scale;
    float f;
    float c;
    float k;

    printf("Temperature, scale? ");
    scanf(" %f %c", &temp, &scale);

    switch(scale) {
        case 'c': printf("Here?");
        case 'C':
            c = temp;
            f = c * 9.0/5.0 + 32;
            k = c - 273;
            printf("\nF: %.1f   C: %.1f   K: %.1f", f, c, k);
            break;
        case 'f' :
        case 'F' :
            f = temp;
            c = (f - 32) * 5.0/9.0;
            k = c + 273;
            printf("\nF: %.1f   C: %.1f   K: %.1f", f, c, k);
            break;
        case 'k' :
        case 'K' :
            k = temp;
            c = k + 273;
            f = c * 9.0/5.0 + 32;
            printf("\nF: %.1f   C: %.1f   K: %.1f", f, c, k);
            break;
            default:
            printf("PLez");
    }

    return 0;
}
