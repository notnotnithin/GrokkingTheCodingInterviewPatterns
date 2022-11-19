package com.dawn.grokking.patterns;

public class Pattern01 {

  public static void main(String[] args) {
    int num = 5;
    Pattern01.printPattern01(num);
  }

  /*
    Prints the pattern
    * * * * *
    * * * * *
    * * * * *
    * * * * *
    * * * * *
  **/
  private static void printPattern01(int num) {
    for (int i = 0; i < num; i++) {
      for (int j = 0; j < num; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}
