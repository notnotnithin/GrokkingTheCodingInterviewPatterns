package com.dawn.grokking.patterns;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeInEveryWindowSizeK004 {

  public static void main(String[] args) {
    int[] arr = new int[] {12, -1, -7, 8, -15, 30, 16, 28};
    int k = 3;
    System.out.println(
        "First negative in every window size of k in brute force are: "
            + FirstNegativeInEveryWindowSizeK004.findFirstNegativeBruteForce(arr, k));

    System.out.println(
        "First negative in every window size of k in efficient solution are: "
            + FirstNegativeInEveryWindowSizeK004.findFirstNegativeEfficientSolution(arr, k));
  }

  public static List<Integer> findFirstNegativeBruteForce(int[] arr, int k) {
    int size = arr.length;
    List<Integer> negativeList = new ArrayList<>();
    for (int i = 0; i <= size - k; i++) {
      for (int j = i; j < i + k; j++) {
        if (arr[j] < 0) {
          negativeList.add(arr[j]);
          break;
        } else if (arr[j] > 0 && i == j) {
          negativeList.add(0);
        }
      }
    }
    return negativeList;
  }

  public static List<Integer> findFirstNegativeEfficientSolution(int[] arr, int k) {
    int size = arr.length;
    int windowStart = 0, windowEnd = 0;
    int windowSize;
    List<Integer> firstNegatives = new ArrayList<>();

    while (windowEnd < size) {
      windowSize = windowEnd - windowStart + 1;
      if (windowSize < k) {
        windowEnd++;
      } else if (windowEnd - windowStart + 1 == k) {
        for (int i = windowStart; i <= windowEnd; i++) {
          if (arr[i] < 0) {
            firstNegatives.add(arr[i]);
            break;
          } else if (arr[i] > 0 && i == windowEnd) {
            firstNegatives.add(0);
          }
        }
        windowStart++;
        windowEnd++;
      }
    }
    return firstNegatives;
  }
}
