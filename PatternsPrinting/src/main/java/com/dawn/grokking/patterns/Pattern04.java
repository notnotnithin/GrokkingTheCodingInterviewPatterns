package com.dawn.grokking.patterns;

public class Pattern04 {

  public static void main(String[] args) {
    int num = 5;
    Pattern04.printPattern04(num);
  }

  /*
    Prints the pattern
    * * * * *
      * * * *
        * * *
          * *
            *
  **/
  private static void printPattern04(int num) {
    for (int i = 1; i <= num; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("  ");
      }
      for (int k = i; k <= num; k++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}
