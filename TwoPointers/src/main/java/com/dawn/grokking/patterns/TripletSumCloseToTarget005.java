package com.dawn.grokking.patterns;

import java.util.Arrays;

public class TripletSumCloseToTarget005 {

  public static void main(String[] args) {
    int[] arr = {-2, 0, 1, 2};
    int targetSum = 2;
    System.out.println(
        "Triplets whose sum equal to zero using brute force approach are: "
            + TripletSumCloseToTarget005.searchTripletsCloseToTarget(arr, targetSum));
  }

  public static int searchTripletsCloseToTarget(int[] arr, int targetSum) {
    Arrays.sort(arr);
    int closestSumToTarget = arr[0] + arr[1] + arr[arr.length - 1];

    for (int i = 0; i < arr.length - 2; i++) {
      int left = i + 1;
      int right = arr.length - 1;

      while (left < right) {
        int currentSum = arr[i] + arr[left] + arr[right];
        if (currentSum > targetSum) {
          right--;
        } else {
          left++;
        }
        if (Math.abs(currentSum - targetSum) < Math.abs(closestSumToTarget - targetSum)) {
          closestSumToTarget = currentSum;
        }
      }
    }
    return closestSumToTarget;
  }
}
