/* random outputs */
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(int argc, char** argv)
{
	unsigned ri;
	float rf;

	printf("%i\n", time(NULL));
	srandom(time(NULL));
	ri = random();
	rf = 1.0 * ri / RAND_MAX;

	printf("%u, %f\n", ri, rf);

	unsigned i;
	for (i = 0; i < 10; i++) {
		printf("%i\n", random());
	}

	return 0;
}
