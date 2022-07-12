package com.dawn.grokking.patterns;

public class SmallestSubarrayWithGreaterSum003 {

  public static void main(String[] args) {
    System.out.println(
        "Smallest subarray length is: "
            + SmallestSubarrayWithGreaterSum003.findMinSubArray(16, new int[] {2, 1, 5, 2, 3, 2}));
  }

  private static int findMinSubArray(int sum, int[] arr) {
    int windowStart = 0, windowSum = 0;
    int minLength = Integer.MAX_VALUE;

    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      windowSum += arr[windowEnd];

      while (windowSum >= sum) {
        minLength = Math.min(minLength, windowEnd - windowStart + 1);
        windowSum -= arr[windowStart];
        windowStart++;
      }
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }
}
