package com.dawn.grokking.patterns;

import java.util.Arrays;

public class AverageSubarrayIntroExample001 {

  public static void main(String[] args) {
    int[] arr = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2};
    int k = 5;
    double[] res = AverageSubarrayIntroExample001.averageSubarrayBruteForce(arr, k);
    System.out.println(
        "Averages of subarrays of size K using brute force: " + Arrays.toString(res));

    res = AverageSubarrayIntroExample001.averageSubarrayEfficientSolution(arr, k);
    System.out.println(
        "Averages of subarrays of size K using efficient solution: " + Arrays.toString(res));

    double result = AverageSubarrayIntroExample001.findMaxAverage(arr, 2);
    System.out.println("Max average of subarrays of size K is : " + result);

    double[] avgArr = AverageSubarrayIntroExample001.findMaxAverageAlgoLabs(arr, k);
    System.out.println();
    System.out.println(":::Sliding window solution:::");
    for (double el : avgArr) {
      System.out.print(el + "\t");
    }
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

  public static double findMaxAverage(int[] nums, int k) {
    double windowSum = 0;
    double maxAvgSum = Double.NEGATIVE_INFINITY;

    for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
      windowSum += nums[windowEnd];

      if (windowEnd >= k - 1) {
        maxAvgSum = Math.max(windowSum, maxAvgSum);
        windowSum -= nums[windowEnd - (k - 1)];
      }
    }
    return maxAvgSum / k;
  }

  public static double[] findMaxAverageAlgoLabs(int[] nums, int k) {
    int n = nums.length;
    double[] avg = new double[n - k + 1];
    double winSum = 0.0;

    for (int i = 0; i < k; i++) {
      winSum += nums[i];
    }
    avg[0] = winSum / k;
    for (int i = 0; i < (n - k); i++) {
      winSum = winSum - nums[i] + nums[i + k];
      avg[i + 1] = winSum / k;
    }
    return avg;
  }
}
