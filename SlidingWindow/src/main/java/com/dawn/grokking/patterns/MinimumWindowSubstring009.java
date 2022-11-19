package com.dawn.grokking.patterns;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring009 {

  public static void main(String[] args) {
    String s = "totmtaptat";
    String t = "pt";

    System.out.println(
        "Minimum window substring length is : "
            + MinimumWindowSubstring009.findMinWindowSubstring(s, t));
  }

  public static Map<Character, Integer> transformStringToMap(String t) {
    Map<Character, Integer> tStrMap = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      tStrMap.put(t.charAt(i), tStrMap.getOrDefault(t.charAt(i), 0) + 1);
    }
    return tStrMap;
  }

  public static int findMinWindowSubstring(String s, String t) {
    Map<Character, Integer> tStrMap;
    int count;
    int windowStart = 0, windowEnd = 0, minLength = Integer.MAX_VALUE;

    tStrMap = transformStringToMap(t);
    count = tStrMap.size();

    while (windowEnd < s.length()) {
      char rightChar = s.charAt(windowEnd);

      if (tStrMap.containsKey(rightChar)) {
        tStrMap.put(rightChar, tStrMap.get(rightChar) - 1);
        if (tStrMap.get(rightChar) == 0) {
          count--;
        }
      }
      if (count == 0) {
        minLength = Math.min(minLength, windowEnd - windowStart + 1);
      }
      /*
       * Once count is 0, we need to see if we can shrink the string by removing duplicate
       * characters from the left side of the string.
       *
       * We increment windowStart until count is 0 and as and when count becomes greater than
       * 0, we increment windowEnd to find a different minimum window substring.
       */
      while (count == 0) {
        char leftChar = s.charAt(windowStart);
        windowStart++;
        if (tStrMap.containsKey(leftChar)) {
          // map is in negative, so until we find occurrences of a character, we increment the count.
          tStrMap.put(leftChar, tStrMap.get(leftChar) + 1);
          if (tStrMap.get(leftChar) > 0) {
            count++;
          } else {
            minLength = Math.min(minLength, windowEnd - windowStart + 1);
          }
        } else {
          minLength = Math.min(minLength, windowEnd - windowStart + 1);
        }
      }
      windowEnd++;
    }
    return minLength;
  }
}
