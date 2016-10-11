/* Memory address demo
 * 2016-10-06
 */
#include <stdio.h>

int main(int argc, char** argv) {
    int myInt1, myInt2;
    double myDouble1, myDouble2;

    printf("&myInt1: %p   &myDouble1: %p\n", &myInt1, &myDouble1);
    printf("&myInt1: %p   &myDouble1: %p\n", &myInt1, &myDouble1);

    return 0;
}
