package com.dawn.grokking.patterns;

public class LongestSubarrayOfOnesAfterReplacement012 {

  public static void main(String[] args) {
    int[] arr = {0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1};
    int k = 2;

    System.out.println(
        "Longest subarray count of ones after replacement using efficient solution is: "
            + LongestSubarrayOfOnesAfterReplacement012.findLongestSubarrayOfOnesEfficient(arr, k));

    System.out.println(
        "Longest subarray count of ones after replacement is: "
            + LongestSubarrayOfOnesAfterReplacement012.findLongestSubarrayOfOnes(arr, k));
  }

  public static int findLongestSubarrayOfOnesEfficient(int[] arr, int k) {
    int windowStart = 0, maxLen = 0, maxOnesCount = 0;

    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      if (arr[windowEnd] == 1)
        maxOnesCount++;

      if (windowEnd - windowStart + 1 - maxOnesCount > k) {
        if (arr[windowStart] == 1)
          maxOnesCount--;
        windowStart++;
      }
      maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
    }
    return maxLen;
  }

  public static int findLongestSubarrayOfOnes(int[] arr, int k) {
    int windowEnd = 0, windowStart = 0, maxOnesCount = 0, maxLength = 0;

    while (windowEnd < arr.length) {
      if ((windowEnd - windowStart + 1 - maxOnesCount) < k) {
        windowEnd++;
      } else if ((windowEnd - windowStart + 1 - maxOnesCount) == k) {
        if (arr[windowEnd] == 1) maxOnesCount++;
        windowEnd++;
      } else {
        if (arr[windowStart] == 1) maxOnesCount--;
        windowStart++;
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    return maxLength;
  }
}
