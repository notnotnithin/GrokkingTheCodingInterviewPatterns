package com.dawn.grokking.patterns;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAfterReplacement011 {

  public static void main(String[] args) {
    String str = "abbcb";
    int k = 1;

    System.out.println(
        "Longest substring count after replacing exactly "
            + k
            + " characters is: "
            + LongestSubstringAfterReplacement011.findLongestSubstringCount(str, k));
  }

  public static int findLongestSubstringCount(String str, int k) {
    Map<Character, Integer> frequencyMap = new HashMap<>();
    int windowStart = 0, windowEnd = 0, maxRepeatingCharCount = 0, maxLength = 0;

    while (windowEnd < str.length()) {
      char rightChar = str.charAt(windowEnd);
      frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar, 0) + 1);

      if ((windowEnd - windowStart + 1 - maxRepeatingCharCount) < k) {
        windowEnd++;
      } else if ((windowEnd - windowStart + 1 - maxRepeatingCharCount) == k) {
        maxRepeatingCharCount = Math.max(maxRepeatingCharCount, frequencyMap.get(rightChar));
        windowEnd++;
      } else {
        char leftChar = str.charAt(windowEnd);
        frequencyMap.put(leftChar, frequencyMap.get(leftChar) - 1);
        windowStart++;
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    return maxLength;
  }
}
