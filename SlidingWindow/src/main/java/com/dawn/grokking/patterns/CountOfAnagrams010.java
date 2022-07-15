package com.dawn.grokking.patterns;

import java.util.HashMap;
import java.util.Map;

public class CountOfAnagrams010 {

  public static void main(String[] args) {
    String str = "forxxorfxdofr";
    String pattern = "for";
    int k = pattern.length();

    System.out.println(
        "Count of anagram occurrences is: " + CountOfAnagrams010.findOccurrences(str, pattern, k));
  }

  public static Map<Character, Integer> transformStringToMap(String pattern) {
    Map<Character, Integer> patternStrMap = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      patternStrMap.put(pattern.charAt(i), patternStrMap.getOrDefault(pattern.charAt(i), 0) + 1);
    }
    return patternStrMap;
  }

  public static int findOccurrences(String str, String pattern, int k) {
    Map<Character, Integer> patternStrMap;
    int windowStart = 0, windowEnd = 0;
    int count, anagramsCount = 0;

    patternStrMap = transformStringToMap(pattern);
    count = patternStrMap.size();

    while (windowEnd < str.length()) {
      char rightChar = str.charAt(windowEnd);

      if (patternStrMap.containsKey(rightChar)) {
        patternStrMap.put(rightChar, patternStrMap.get(rightChar) - 1);
        if (patternStrMap.get(rightChar) == 0) {
          count--;
        }
      }

      if ((windowEnd - windowStart + 1) < k) {
        windowEnd++;
      } else if ((windowEnd - windowStart + 1) == k) {
        if (count == 0) {
          anagramsCount = anagramsCount + 1;
        } else {
          char leftChar = str.charAt(windowStart);
          if (patternStrMap.containsKey(leftChar)) {
            patternStrMap.put(leftChar, patternStrMap.get(leftChar) + 1);
            if (patternStrMap.get(leftChar) == 1) {
              count++;
            }
            windowStart++;
          }
        }
        windowEnd++;
      }
    }
    return anagramsCount;
  }
}
