/* printf example */
#include <stdio.h>

int main(int argc, char **argv)
{
	int i = -37;
	float f = 3.141592653;

	char msg[30] = "abcdefg";

	printf("%s, %i, %f\n", msg, i, f);

	return 0;
}
