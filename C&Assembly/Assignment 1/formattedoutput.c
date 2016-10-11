/*
 * JOHN GIBSON
 * 2016-09-15
 * "formatted output" program
 */
#include <stdio.h>
#include <math.h>

 int main(int argc, char** argv) {
     float pi = M_PI;
     int prime = 1500450271;
     char letter = 'A';
     double avogadro = 6.0221409e+23;
     char string[12] = "John Gibson";

     printf("==CONSTANT==: |== 25 spaces ============| |===15 spaces ==| |==5==|\n");
     printf("%12s: |%25lf| |%15lf| |%5lf|\n", "%lf pi", pi, pi, pi);
     printf("%12s: |%25lu| |%15lu| |%5lu|\n", "%lu pi", (long)(unsigned) pi, (long)(unsigned) pi, (long)(unsigned) pi);
     printf("%12s: |%25lx| |%15lx| |%5lx|\n", "%lx pi", (long) pi, (long) pi, (long) pi);
     printf("%12s: |%25c| |%15c| |%5c|\n", "%c pi", (char) pi, (char) pi, (char) pi);
     printf("============: |=========================| |===============| |=====|\n");
     printf("%12s: |%25lf| |%15lf| |%5lf|\n", "%lf prime", (double) prime, (double) prime, (double) prime);
     printf("%12s: |%25lu| |%15lu| |%5lu|\n", "%lu prime", (long)(unsigned) prime, (long)(unsigned) prime, (long)(unsigned) prime);
     printf("%12s: |%25lx| |%15lx| |%5lx|\n", "%lx prime", (long)(unsigned) prime, (long)(unsigned) prime, (long)(unsigned) prime);
     printf("%12s: |%25c| |%15c| |%5c|\n", "%c prime", (char) prime, (char) prime, (char) prime);
     printf("============: |=========================| |===============| |=====|\n");
     printf("%12s: |%25lf| |%15lf| |%5lf|\n", "%lf letter", (double) letter, (double) letter, (double) letter);
     printf("%12s: |%25lu| |%15lu| |%5lu|\n", "%lu letter", (long)(unsigned) letter, (long)(unsigned) letter, (long)(unsigned) letter);
     printf("%12s: |%25lx| |%15lx| |%5lx|\n", "%lx letter", (long)(unsigned) letter, (long)(unsigned) letter, (long)(unsigned) letter);
     printf("%12s: |%25c| |%15c| |%5c|\n", "%c letter", (char) letter, (char) letter, (char) letter);
     printf("============: |=========================| |===============| |=====|\n");
     printf("%12s: |%25le| |%15le| |%5le|\n", "%le avogadro", (double) avogadro, (double) avogadro, (double) avogadro);
     printf("%12s: |%25lu| |%15lu| |%5lu|\n", "%lu avogadro", (long)(unsigned) avogadro, (long)(unsigned) avogadro, (long)(unsigned) avogadro);
     printf("%12s: |%25lx| |%15lx| |%5lx|\n", "%lx avogadro", (long)(unsigned) avogadro, (long)(unsigned) avogadro, (long)(unsigned) avogadro);
     printf("%12s: |%25c| |%15c| |%5c|\n", "%c avogadro", (char) avogadro, (char) avogadro, (char) avogadro);
     printf("============: |=========================| |===============| |=====|\n");
     printf("%12s: |%25lu|\n", "%lu string", string);
     printf("%12s: |%25lx|\n", "%lx string", string);
     printf("%12s: |%25c|\n", "%c string", string);
     printf("%12s: |%25s|\n", "%s string", string);
     printf("%12s: |%25p|\n", "%p string", string);
     printf("============: |=========================| |===============| |=====|\n");

     return 0;
 }
