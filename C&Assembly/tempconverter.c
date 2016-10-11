/* F to C converter */
#include <stdio.h>
#include <stdlib.h>  // srtof()

float FtoC(float f);

int main(int argc, char** argv) {
    float fahr;
    float cels;

    printf("Enter temperature in F: ");
    scanf("%f", &fahr); // address of fahr
    //fgets (fstr, 200, stdin);
    //fahrenheit = strtof(fstr, NULL);

    cels = FtoC(fahr);
    printf("%.1f F equals %.1fC", fahr, cels);
}
