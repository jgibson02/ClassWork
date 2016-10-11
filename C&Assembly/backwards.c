/* backwards
*  Display a text string backwards.
*  2016-08-17
*/
#include<stdio.h>   // for printf(), fgets()
#include<string.h>  // for strlen()

int main(int argc, char **argv)
{
   int i;              // a loop counter
   char *errmsg        // pointer; used to mark errors
   char buffer[1000];  // 1000-character array of single characters, a.k.a. "textstring"

   printf("Enter text: "); // a prompting message
   errmsg = fgets(buffer, 1000, stdin);
   if (errmsg != NULL) {
      for (i = strlen(buffer) - 1; i >= 0; i--) {
         printf("%c", buffer[i]);
      }
      printf("\n");
   }

   return 0;
}
//--------
