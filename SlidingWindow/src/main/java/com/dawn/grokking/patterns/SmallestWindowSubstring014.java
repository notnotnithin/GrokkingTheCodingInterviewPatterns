package com.dawn.grokking.patterns;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowSubstring014 {

  public static void main(String[] args) {
    String str = "adobecodebanc";
    String pattern = "abc";
    System.out.println(
        "Smallest window substring exists in index: "
            + SmallestWindowSubstring014.findSmallestWindowSubstring(str, pattern));
  }

  public static String findSmallestWindowSubstring(String str, String pattern) {
    if (str == null
        || pattern == null
        || str.length() == 0
        || pattern.length() == 0
        || str.length() < pattern.length()) return "";

    Map<Character, Integer> mainStrMap = new HashMap<>();
    Map<Character, Integer> patternStrMap;
    Map<Integer, Integer> res = new HashMap<>();
    int resLen = Integer.MAX_VALUE;

    patternStrMap = transformStrToMap(pattern);

    int windowStart = 0, windowEnd = 0;
    int have = 0, need = patternStrMap.size();

    while (windowEnd < str.length()) {
      char rightChar = str.charAt(windowEnd);
      if (mainStrMap.containsKey(rightChar)) {
        mainStrMap.put(rightChar, mainStrMap.getOrDefault(rightChar, 0) + 1);
      }

      // Compare the new character read from the actual string against the pattern string,
      // increment have by 1.
      if (mainStrMap.get(rightChar).equals(patternStrMap.get(rightChar))) {
        have += 1;
      }

      while (have == need) {
        if (windowEnd - windowStart + 1 < resLen) {
          res.put(windowStart, windowEnd);
          resLen = windowEnd - windowStart + 1;
        } else {
          char leftChar = str.charAt(windowStart);
          mainStrMap.put(leftChar, mainStrMap.get(leftChar) - 1);
          if (mainStrMap.get(rightChar) <= patternStrMap.get(rightChar)) {
            have -= 1;
          }
          windowStart++;
        }
      }
      windowEnd++;
    }
    return resLen != Integer.MAX_VALUE ? str.substring(windowStart, windowEnd + 1) : "";
  }

  public static Map<Character, Integer> transformStrToMap(String patternStr) {
    Map<Character, Integer> patternStrMap = new HashMap<>();
    for (char ch : patternStr.toCharArray()) {
      patternStrMap.put(ch, patternStrMap.getOrDefault(ch, 0) + 1);
    }
    return patternStrMap;
  }
}
