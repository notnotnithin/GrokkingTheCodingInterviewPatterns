package com.dawn.grokking.patterns;

public class SubarraySizeKAndAverageGreaterThanThreshold {

  public static void main(String[] args) {
    int[] arr = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
    int k = 3;
    int t = 4;
    System.out.println(
        "Subarray count with average greater than the threshold are: "
            + SubarraySizeKAndAverageGreaterThanThreshold.numberOfSubarrayBasedOnACondition(
                arr, k, t));
  }

  private static int numberOfSubarrayBasedOnACondition(int[] arr, int k, int threshold) {
    int n = arr.length;
    int count = 0, avg = 0, windowSum = 0;

    for (int i = 0; i < k; i++) {
      windowSum += arr[i];
    }
    if (windowSum / k >= threshold) count++;

    for (int i = 0; i < (n - k); i++) {
      windowSum = windowSum - arr[i] + arr[i + k];
      avg = windowSum / k;
      if (avg >= threshold) count++;
    }
    return count;
  }
}
