/*
 * JOHN GIBSON
 * 2016-09-15
 * "basic input" program
 * Prompts ther user to enter a name, an integer, and a real number, and prints
 * them back out.
 */
#include <stdio.h>

int main(int argc, char** argv)
{
    char name[15];
    int integer;
    float real;

    printf("Enter your name: ");
    scanf("%s", name);
    printf("Enter an integer and a real number: ");
    scanf("%i %g", &integer, &real);
    printf("name: %s; integer: %i; real: %g", name, integer, real);

    return 0;
}
