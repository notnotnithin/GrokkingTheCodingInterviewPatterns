package com.dawn.grokking.patterns;

import java.util.Arrays;

public class PairWithTargetSum001 {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 6};
    int target = 6;
    System.out.println(
        "Pair adding up to the target sum is: "
            + Arrays.toString(PairWithTargetSum001.findPair(arr, target)));
  }

  public static int[] findPair(int[] arr, int targetSum) {
    int left = 0, right = arr.length - 1;

    while (left < right) {
      int currentSum = arr[left] + arr[right];
      if (currentSum < targetSum) {
        left++;
      } else if (arr[left] + arr[right] > targetSum) {
        right--;
      } else {
        return new int[] {left, right};
      }
    }
    return new int[] {-1, -1};
  }
}
