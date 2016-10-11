/*
 * John Gibson
 * 2016-09-27
 * Provides analytics for text input by the user.
 */
 #include <stdio.h>
 #include <limits.h>

 int main(int argc, char** argv) {

     unsigned counts[256];

     unsigned total = 0;
     unsigned distinct = 0;
     unsigned alphabetic = 0;
     unsigned whitespace = 0;
     unsigned digits = 0;
     unsigned most = 0;
     unsigned fewest = 0;

     printf("Enter text. Press <CTRL>-D to signal EOF when done.\n");

     unsigned i;
     for (i = 0; i < 256; i++) {
         counts[i] = 0;
     }

     char c;
     while (EOF != (c = getchar())) {
         if ((c >= '0') & (c <= '9')) {
             digits++;
         }
         if (c == '\n' || c == ' ' || c == '\t' || c == '\v') {
             whitespace++;
         }
         if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
             alphabetic++;
         }
         counts[(int) c]++;
         total++;
     }

     for(i = 0; i < 256;i++)
 	 {
 		// Distinct characters
 		if(counts[i] > 0)
 		{
 			distinct++;
 		}

 		// Most occurrences
 		if(counts[i] > most)
 		{
 			most = counts[i] ;
 		}

 		// Fewest occurrences
 		if(counts[i] > fewest && fewest == 0)
 		{
 			fewest = counts[i];
 		}
 		else if (fewest > counts[i] && counts[i] > 0) {
            fewest = counts[i];
 		}
 	}

     printf("-------------------- --------------\n");
 	 printf(" %19s %8i chars \n", "Total :", total );
 	 printf(" %19s %8i chars\n", "Distinct :", distinct );
 	 printf(" %19s %8i chars\n", "Alphabetic :", alphabetic);
 	 printf(" %19s %8i chars\n", "Whitespace :", whitespace );
 	 printf(" %19s %8i chars\n", "Digits:", digits);
 	 printf(" %19s %8i chars\n", "Most occurrences :", most );
 	 printf("%s %8i chars\n", "Fewest occurrences :", fewest );
 	 printf("-------------------- --------------\n");

     return 0;
 }
