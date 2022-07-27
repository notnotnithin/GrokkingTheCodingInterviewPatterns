package com.dawn.grokking.patterns;

public class HappyNumber003 {

  public static void main(String[] args) {
    int num = 23;
    System.out.println("Is " + num + " a happy number? " + HappyNumber003.find(num));

    num = 12;
    System.out.println("Is " + num + " a happy number? " + HappyNumber003.find(num));
  }

  public static boolean find(int num) {
    int slow = num, fast = num;

    do {
      slow = findSquaredSum(slow);
      fast = findSquaredSum(findSquaredSum(fast));
    } while (slow != fast);

    return slow == 1;
  }

  public static int findSquaredSum(int num) {
    int sum = 0, digit;
    while (num > 0) {
      digit = num % 10;
      sum += digit * digit;
      num /= 10;
    }
    return sum;
  }
}
