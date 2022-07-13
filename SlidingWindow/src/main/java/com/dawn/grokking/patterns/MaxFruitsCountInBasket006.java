package com.dawn.grokking.patterns;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitsCountInBasket006 {

  public static void main(String[] args) {
    char[] treeArr = new char[] {'A', 'B', 'C', 'B', 'B', 'C'};
    int k = 2;
    System.out.println(
        "Maximum number of fruits are: " + MaxFruitsCountInBasket006.maxFruitsInBasket(treeArr, k));
  }

  public static int maxFruitsInBasket(char[] treeArr, int k) {
    int windowStart = 0, maxLength = Integer.MIN_VALUE;
    Map<Character, Integer> frequencyMap = new HashMap<>();

    for (int windowEnd = 0; windowEnd < treeArr.length; windowEnd++) {
      frequencyMap.put(treeArr[windowEnd], frequencyMap.getOrDefault(treeArr[windowEnd], 0) + 1);

      if (frequencyMap.size() == k) {
        maxLength = Math.max(maxLength, (windowEnd - windowStart + 1));
      } else {
        while (frequencyMap.size() > k) {
          char leftChar = treeArr[windowStart];
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
