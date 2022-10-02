package com.dawn.grokking.patterns;

public class Pattern05 {

  public static void main(String[] args) {
    int num = 5;
    Pattern05.printPattern05(num);
  }

  /*
    Prints the pattern
    * * * * *
    * * * *
    * * *
    * *
    *
  **/
  private static void printPattern05(int num) {
    for (int i = 1; i <= num; i++) {
      for (int j = i; j <= num; j++) {
        System.out.print("* ");
      }
      for (int k = 1; k <= i; k++) {
        System.out.print("  ");
      }
      System.out.println();
    }
  }
}
