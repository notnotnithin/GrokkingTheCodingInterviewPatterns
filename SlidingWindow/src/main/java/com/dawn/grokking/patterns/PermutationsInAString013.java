package com.dawn.grokking.patterns;

import java.util.HashMap;
import java.util.Map;

public class PermutationsInAString013 {

  public static void main(String[] args) {
    String str = "oidbcafbhabc", pattern = "abc";
    System.out.println(
        "Permutations count in a string is: "
            + PermutationsInAString013.findPermutationsCount(str, pattern));
  }

  public static Map<Character, Integer> transformStrToMap(String str) {
    Map<Character, Integer> frequencyMap = new HashMap<>();
    for (char ch : str.toCharArray()) {
      frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
    }
    return frequencyMap;
  }

  public static int findPermutationsCount(String str, String pattern) {
    Map<Character, Integer> frequencyMap;
    int windowStart = 0, uniqueCharCountInMap, permutationsCount = 0;

    frequencyMap = transformStrToMap(pattern);
    uniqueCharCountInMap = frequencyMap.size();
    int k = pattern.length();

    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      if (frequencyMap.containsKey(rightChar)) {
        frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar, 0) - 1);
        if (frequencyMap.get(rightChar) == 0) uniqueCharCountInMap++;
      }

      if (uniqueCharCountInMap == frequencyMap.size()) {
        permutationsCount += 1;
        windowEnd++;
      }

      if ((windowEnd - windowStart + 1) < k) {
        windowEnd++;
      } else {
        char leftChar = str.charAt(windowStart++);
        if (frequencyMap.containsKey(leftChar)) {
          if (frequencyMap.get(leftChar) == 0) {
            uniqueCharCountInMap--;
          }
          frequencyMap.put(leftChar, frequencyMap.get(leftChar) + 1);
        }
      }
    }
    return permutationsCount;
  }
}
