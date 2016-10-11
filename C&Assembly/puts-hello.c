/* minimal output */
#include <stdio.h>

int main(int argc, char **argv)
{
	puts("hello");
	puts("goodbye");
	fputs("hello", stdout);
	fputs("goodbye", stdout);
	return 0;
}
