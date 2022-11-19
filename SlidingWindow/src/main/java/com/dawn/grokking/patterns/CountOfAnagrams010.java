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
    for (char ch : pattern.toCharArray()) {
      patternStrMap.put(ch, patternStrMap.getOrDefault(ch, 0) + 1);
    }
    return patternStrMap;
  }

  public static int findOccurrences(String str, String pattern, int k) {
    Map<Character, Integer> patternStrMap;
    int windowStart = 0, count, anagramsCount = 0;

    patternStrMap = transformStringToMap(pattern);
    count = patternStrMap.size();

    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);

      if (patternStrMap.containsKey(rightChar)) {
        patternStrMap.put(rightChar, patternStrMap.getOrDefault(rightChar, 0) - 1);
        if (patternStrMap.get(rightChar) == 0) count++;
      }

      if (count == patternStrMap.size()) {
        anagramsCount += 1;
        windowEnd++;
      }

      if ((windowEnd - windowStart + 1) < k) {
        windowEnd++;
      } else {
        char leftChar = str.charAt(windowStart++);
        if (patternStrMap.containsKey(leftChar)) {
          if (patternStrMap.get(leftChar) == 0) {
            count--;
          }
          patternStrMap.put(leftChar, patternStrMap.get(leftChar) + 1);
        }
      }
    }
    return anagramsCount;
  }
}
