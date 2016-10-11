/*
 * JOHN GIBSON
 * 2016-09-15
 * "character strings" program
 * Receives line(s) of input from the user, either until the user enters an
 * empty line or has already entered 255 characters. When this has happened,
 * the program outputs the string of characters.
 */
 #include <stdio.h>
 #include <string.h>

 int main(int argc, char** argv)
 {
     char string[255];
     char input[255];

     while (1) {
         printf("Your input: ");
         fgets(input, 255, stdin);
         if (strlen(string) >= 255 || input[0] == '\n') {
             break;
         } else {
             if (input[strlen(input) - 1] == '\n') {
                 input[strlen(input) - 1] = '\0';
             }
             strcat(string, input);
         }
     }
     printf("%s", string);

     return 0;
 }
