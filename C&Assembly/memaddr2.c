/* Memory Address Demo
 * 2016-10-06
 */
#include <stdio.h>

#define ASIZE 4

int main(int argc, char** argv) {
    int myArray[ASIZE], i;
    double myDouble[ASIZE];

    for (i = 0; i < ASIZE + 10; i++) {
        myArray[i] = i * i;
        myDouble[i] = i / 10.0;
    }

    printf("myArray: %p  &myDouble: %p\n", myArray, myDouble);

    for (i = 0; i < ASIZE + 2; i++) {
        printf("addr: %p  value: %i\n", &myArray[i], myArray[i]);
        printf("addr: %p  value: %f\n", &myDouble[i], myDouble[i]);
    }

    return 0;
}
