/*
 * John Gibson
 * 2016-09-22
 * Wind Chill
 * Prompts the user for a range of temperatures (F) and a range of wind speeds (mph),
 * and displays a corresponding table of the computed wind chills.
 */
#include <stdio.h>
#include <math.h>

float windChill(float temp, float speed)
{
    return 35.74 + (0.6215 * temp) - (35.75 * pow(speed, 0.16)) + (0.4275 * temp * pow(speed, 0.16));
}

int main(int argc, char** argv)
{
    float i, j;
    float minTemp, maxTemp;
    float minSpeed, maxSpeed;

    printf("Enter minimum and maximum temperatures: ");
    scanf("%f %f", &minTemp, &maxTemp);
    printf("Enter minimum and maximum wind speed: ");
    scanf("%f %f", &minSpeed, &maxSpeed);


    printf("  T \\ W ");
    for (i = minSpeed; i <= maxSpeed; i = i + 5) {
	printf(" %6.1f", i);
    }
    printf("\n");

    printf("          ");
    for (i = minSpeed; i <= maxSpeed; i = i + 5) {
        printf("------ ");
    }
    printf("\n");

    for (i = maxTemp; i >= minTemp; i = i - 4) {
        printf("%6.1f | ", i);
        for (j = minSpeed; j <= maxSpeed; j = j + 5) {
            printf(" %6.1f", windChill(i, j));
        }
	printf("\n");
    }

    printf("          ");
    for (i = minSpeed; i <= maxSpeed; i = i + 5) {
	printf("------ ");
    }
    printf("\n");

    return 0;
}
