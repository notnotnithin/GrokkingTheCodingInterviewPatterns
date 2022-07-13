package com.dawn.grokking.patterns;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithDistinctCharacters007 {

  public static void main(String[] args) {
    String s = "abccde";
    System.out.println(
        "Length of the longest substring with distinct characters is: "
            + LongestSubstringWithDistinctCharacters007.findLongestSubstring(s));
  }

  public static int findLongestSubstring(String s) {
    int windowStart = 0, windowEnd = 0, maxLength = Integer.MIN_VALUE;
    Map<Character, Integer> frequencyMap = new HashMap<>();

    while (windowEnd < s.length()) {
      char rightChar = s.charAt(windowEnd);
      frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar, 0) + 1);

      if (frequencyMap.size() == windowEnd - windowStart + 1) {
        maxLength = Math.max(maxLength, (windowEnd - windowStart + 1));
        windowEnd++;
      } else {
        while (frequencyMap.size() < windowEnd - windowStart + 1) {
          char leftChar = s.charAt(windowStart);
          frequencyMap.put(leftChar, frequencyMap.get(leftChar) - 1);

          if (frequencyMap.get(leftChar) == 0) {
            frequencyMap.remove(leftChar);
          }
          windowStart++;
        }
      }
    }
    return maxLength;
  }
}
