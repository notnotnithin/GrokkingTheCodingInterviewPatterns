package com.dawn.grokking.patterns;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters005 {

  public static void main(String[] args) {
    String s = "cbbebi";
    int k = 3;
    System.out.println(
        "Length of the longest substring with no more than "
            + k
            + " unique characters is: "
            + LongestSubstringWithKDistinctCharacters005.findLongestSubstringEfficientSolution(
                s, k));
  }

  public static int findLongestSubstringEfficientSolution(String s, int k) {
    if (s == null || s.length() == 0 || s.length() < k) {
      throw new IllegalArgumentException();
    }

    Map<Character, Integer> frequencyMap = new HashMap<>();
    int windowStart = 0, windowEnd = 0, maxLength = Integer.MIN_VALUE;
    while (windowEnd < s.length()) {
      // do calculations
      char rightChar = s.charAt(windowEnd);
      frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar, 0) + 1);

      if (frequencyMap.size() < k) {
        windowEnd++;
      } else if (frequencyMap.size() == k) {
        // we calculate the window size and update any previous window length
        maxLength = Math.max(maxLength, (windowEnd - windowStart + 1));
        windowEnd++;
      } else {
        // Window size is greater than k, so we need to loop to decrement from the left
        while (frequencyMap.size() > k) {
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
