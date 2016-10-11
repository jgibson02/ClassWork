/*
 * John Gibson
 * 2016-09-22
 * Heat Index
 * Prompts the user for a range of temperatures (F) and a range of RH values,
 * and displays a corresponding table of the computed heat indexes.
 */
#include <stdio.h>
#include <math.h>

float heatIndex(float temp, float rh)
{
    return -42.379 + (2.04901523 * temp) + (10.14333127 * rh) - (0.22475541 * temp * rh) - (0.00683783 * pow(temp, 2)) - (0.05481717 * pow(rh, 2)) + (0.00122874 * pow(temp, 2) * rh) + (0.00085282 * temp * pow(rh, 2)) - (0.00000199 * pow(temp, 2) * pow(rh, 2));
}

int main(int argc, char** argv)
{
    float i, j;
    float minTemp, maxTemp;
    float minRH, maxRH;

    printf("Enter minimum and maximum temperatures: ");
    scanf("%f %f", &minTemp, &maxTemp);
    printf("Enter minimum and maximum RH values: ");
    scanf("%f %f", &minRH, &maxRH);


    printf("  RH \\ T ");
    for (i = minTemp; i <= maxTemp; i = i + 2) {
	printf(" %6.1f", i);
    }
    printf("\n");

    printf("          ");
    for (i = minTemp; i <= maxTemp; i = i + 2) {
        printf("------ ");
    }
    printf("\n");

    for (i = minRH; i <= maxRH; i = i + 2) {
        printf("%6.1f | ", i);
        for (j = minTemp; j <= maxTemp; j = j + 2) {
            printf(" %6.1f", heatIndex(j, i));
        }
	printf("\n");
    }

    printf("          ");
    for (i = minTemp; i <= maxTemp; i = i + 2) {
	printf("------ ");
    }
    printf("\n");

    return 0;
}
