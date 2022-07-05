package com.dawn.grokking.patterns.introduction;

import java.util.Arrays;

public class SlidingWindowIntroExample {

  public static void main(String[] args) {
    int[] arr = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2};
    int k = 5;
    double[] res = SlidingWindowIntroExample.averageSubarrayBruteForce(arr, k);
    System.out.println("Averages of subarrays of size K using brute force: " + Arrays.toString(res));

    res = SlidingWindowIntroExample.averageSubarrayEfficientSolution(arr, k);
    System.out.println("Averages of subarrays of size K using efficient solution: " + Arrays.toString(res));
  }

  // brute force
  public static double[] averageSubarrayBruteForce(int[] arr, int k) {
    double[] res = new double[arr.length - k + 1];

    for (int i = 0; i <= arr.length - k; i++) {
      double sum = 0;
      for (int j = i; j < i + k; j++) {
        sum += arr[j];
      }
      res[i] = sum / k;
    }
    return res;
  }

  // efficient solution
  public static double[] averageSubarrayEfficientSolution(int[] arr, int k) {
    double[] res = new double[arr.length - k + 1];

    int windowStart = 0;
    double windowSum = 0;
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      windowSum += arr[windowEnd];

      if (windowEnd >= k - 1) {
        res[windowStart] = windowSum / k;
        windowSum -= arr[windowStart];
        windowStart++;
      }
    }
    return res;
  }
}
