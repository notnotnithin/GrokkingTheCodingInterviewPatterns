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

    Map<Character, Integer> frequencyMap = transformStrToMap(pattern);

    int windowStart = 0, windowEnd = 0;
    int mainStrLen = str.length();
    int count = pattern.length();
    int minLeft = 0, minRight = 0;
    boolean flag = false;

    while (windowEnd < str.length()) {
      char rightChar = str.charAt(windowEnd);

      if (frequencyMap.containsKey(rightChar)) {
        frequencyMap.put(rightChar, frequencyMap.get(rightChar) - 1);
        if (frequencyMap.get(rightChar) >= 0) count--;
      }

      while (count == 0 && windowStart <= windowEnd) {
        flag = true;
        int windowLen = (windowEnd - windowStart + 1);
        if (windowLen < mainStrLen) {
          minLeft = windowStart;
          minRight = windowEnd;
          mainStrLen = windowLen;
        }

        char leftChar = str.charAt(windowStart);

        if (frequencyMap.containsKey(leftChar)) {
          frequencyMap.put(leftChar, frequencyMap.get(leftChar) + 1);
          if (frequencyMap.get(leftChar) >= 1) count++;
        }
        windowStart++;
      }
      windowEnd++;
    }
    return flag ? str.substring(minLeft, minRight + 1) : "";
  }

  public static Map<Character, Integer> transformStrToMap(String patternStr) {
    Map<Character, Integer> patternStrMap = new HashMap<>();
    for (char ch : patternStr.toCharArray()) {
      patternStrMap.put(ch, patternStrMap.getOrDefault(ch, 0) + 1);
    }
    return patternStrMap;
  }
}
