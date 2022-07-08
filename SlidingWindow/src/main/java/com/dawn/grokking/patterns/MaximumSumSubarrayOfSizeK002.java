package com.dawn.grokking.patterns;

public class MaximumSumSubarrayOfSizeK002 {

  public static void main(String[] args) {
    int[] arr = new int[] {2, 1, 5, 1, 3, 2};
    int k = 3;

    System.out.println(
        "Maximum subarray sum of size K using brute force solution is: "
            + MaximumSumSubarrayOfSizeK002.maxSubarraySumBruteForce(arr, k));

    System.out.println(
        "Maximum subarray sum of size K using efficient solution is: "
            + MaximumSumSubarrayOfSizeK002.maxSubarraySumEfficient(arr, k));
  }

  // brute force - TC - O(N * K) and SC - O(1)
  public static int maxSubarraySumBruteForce(int[] arr, int k) {
    int windowSum, maxSum = 0;

    for (int i = 0; i <= arr.length - k; i++) {
      windowSum = 0;
      for (int j = i; j < i + k; j++) {
        windowSum += arr[j];
      }
      maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
  }

  // Efficient solution - TC - O(N) and SC - O(1)
  public static int maxSubarraySumEfficient(int[] arr, int k) {
    int windowSum = 0, maxSum = 0;
    int windowStart = 0;

    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      windowSum += arr[windowEnd];

      if (windowEnd >= k - 1) {
        maxSum = Math.max(maxSum, windowSum);
        windowSum -= arr[windowStart];
        windowStart++;
      }
    }
    return maxSum;
  }
}
