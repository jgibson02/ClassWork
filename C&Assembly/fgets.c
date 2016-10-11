/* fgets() versus gets()
 * 2016-08-20
 */
#include <stdio.h>

int main(int argc, char **argv)
{
	char dest[10];
	
	fgets(dest, 10, stdin);
	fputs(dest, stdout);
	fputs("<--\n", stdout);
	
	fputs("\n*********\n", stdout);

	gets(dest);
	fputs(dest, stdout);
	fputs("<--\n", stdout);
	
	return 0;
}
