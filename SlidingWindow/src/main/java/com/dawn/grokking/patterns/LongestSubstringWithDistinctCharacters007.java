package com.dawn.grokking.patterns;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithDistinctCharacters007 {

  public static void main(String[] args) {
    String s = "aabccbbdef";

    System.out.println(
        "Length of the longest substring with distinct characters is: "
            + LongestSubstringWithDistinctCharacters007.findLongestSubstringEfficient(s));
  }

  public static int findLongestSubstringEfficient(String s) {
    int windowStart = 0, windowEnd = 0, maxLen = 0;
    Map<Character, Integer> fMap = new HashMap<>();
    for (windowEnd = 0; windowEnd < s.length(); windowEnd++) {
      char rightChar = s.charAt(windowEnd);
      fMap.put(rightChar, fMap.getOrDefault(rightChar, 0) + 1);

      if (fMap.get(s.charAt(windowEnd)) > 1) {
        windowStart = windowEnd;
      }
      maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
    }
    return maxLen;
  }
}
