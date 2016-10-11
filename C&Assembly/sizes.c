/* sizes
 * 2015-10-04
 */
#include <stdio.h>
#include <limits.h>

int main(int argc, char** argv) {
    char c;

    printf("          char: %lu\n", sizeof(c));
    printf("          char: %lu\n", sizeof(char));
    printf("          char: %lu\n", sizeof('a'));

    printf("           int: %lu\n", sizeof(int));
    printf("           int: %lu\n", sizeof(97));

    printf("         short: %lu\n", sizeof(short));
    printf("           min: %#x  %d\n", (unsigned short) SHRT_MIN, SHRT_MIN);
    printf("           max: %#x  %d\n", SHRT_MAX, SHRT_MAX);
    printf("unsigned short: %lu\n", sizeof(unsigned short));

    printf("          long: %lu\n", sizeof(long));
    printf("     long long: %lu\n", sizeof(long long));

    return 0;
}
