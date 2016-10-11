/* look at datatype sizes
 * 2016-09-15
 */
#include <stdio.h>
#include <limits.h>

int main(int argc, char** argv) {
    char line[] = "----";
    char blank[] = "    ";
    int i;
    unsigned u;

    printf("%4s   %20s   %20s\n", "type", "minimum", "maximum");
    printf("%4s   %20s   %20s\n", line, line, line);

    printf("%4lu  %#20x   %#20x\n", sizeof(i), INT_MIN, INT_MAX);
    printf("%4s   %20l     %20l\n", blank, INT_MIN, INT_MAX);
}
