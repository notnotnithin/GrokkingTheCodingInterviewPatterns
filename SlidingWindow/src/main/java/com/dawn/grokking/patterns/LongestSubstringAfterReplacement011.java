package com.dawn.grokking.patterns;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAfterReplacement011 {

  public static void main(String[] args) {
    String str = "abccde";
    int k = 1;

    System.out.println(
        "Longest substring count after replacing exactly "
            + k
            + " characters using efficient solution is: "
            + LongestSubstringAfterReplacement011.findLongestSubstringCountEfficient(str, k));
  }

  public static int findLongestSubstringCountEfficient(String str, int k) {
    Map<Character, Integer> fMap = new HashMap<>();
    int windowStart = 0, maxRepeatCharCount = 0, maxLen = 0;

    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      fMap.put(rightChar, fMap.getOrDefault(rightChar, 0) + 1);

      maxRepeatCharCount = Math.max(maxRepeatCharCount, fMap.get(rightChar));

      if (windowEnd - windowStart + 1 - maxRepeatCharCount > k) {
        char leftChar = str.charAt(windowStart);
        fMap.put(leftChar, fMap.get(leftChar) - 1);
        windowStart++;
      }
      maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
    }
    return maxLen;
  }
}
