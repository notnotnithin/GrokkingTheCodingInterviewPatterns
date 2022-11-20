package com.dawn.grokking.patterns;

public class SubstringsOfSizeKWithDistinctCharacters {

  public static void main(String[] args) {
    String s = "aababcabc";
    System.out.println(
        "Good strings count is: " + SubstringsOfSizeKWithDistinctCharacters.countGoodStrings(s, 3));
  }

  private static int countGoodStrings(String s, int k) {
    int n = s.length();
    if (n < k) return 0;
    int goodStringCount = 0;

    char a = s.charAt(0), b = s.charAt(1), c = s.charAt(2);
    for (int i = 3; i < n; i++) {
      if (a != b && b != c && c != a) goodStringCount++;

      a = b;
      b = c;
      c = s.charAt(i);
    }
    if (a != b && b != c && c != a) goodStringCount++;

    return goodStringCount;
  }
}
