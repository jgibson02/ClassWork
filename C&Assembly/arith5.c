/* fun with numeric inputs
 * 2016-09-08
 */
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv)
{
	int a, b, c;
	unsigned i;

	for (i = 0; i < 100; i++) {
		printf("Enter 3 values:\n");
		scanf( "%d %x %d", &a, &b, &c);

		printf("%d / %d = %f\n", a, b, (float) a/b);
		printf("%d / %d = %f\n", b, c, (float) b/c);
		printf("%d / %d = %f\n", c, a, (float) c/a);
		printf("\n");
	}

	return 0;
}
