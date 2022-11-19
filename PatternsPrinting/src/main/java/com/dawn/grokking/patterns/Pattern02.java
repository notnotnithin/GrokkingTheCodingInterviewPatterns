package com.dawn.grokking.patterns;

public class Pattern02 {

  public static void main(String[] args) {
    int num = 5;
    Pattern02.printPattern02(num);
  }

  /*
    Prints the pattern
    *
    * *
    * * *
    * * * *
    * * * * *
  **/
  private static void printPattern02(int num) {
    for (int i = 1; i <= num; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}
