package com.dawn.grokking.patterns;

import java.util.Arrays;

public class TripletSumCloseToTarget005 {

  public static void main(String[] args) {
    int[] arr = {0, 0, 1, 1, 2, 6};
    int targetSum = 5;
    /*System.out.println(
    "Triplets whose sum equal to zero using brute force approach are: "
        + TripletSumCloseToTarget005.searchTripletsCloseToTarget(arr, targetSum));*/

    System.out.println(
        "Triplets whose sum equal to zero using brute force approach are: "
            + TripletSumCloseToTarget005.searchTripletsCloseToTargetSolution2(arr, targetSum));
  }

  public static int searchTripletsCloseToTarget(int[] arr, int targetSum) {
    Arrays.sort(arr); // O(n logn)
    int closestSumToTarget = arr[0] + arr[1] + arr[arr.length - 1];

    for (int i = 0; i < arr.length - 2; i++) { // O(n)
      int left = i + 1;
      int right = arr.length - 1;

      while (left < right) { // O(n)
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
    // time complexity: O(n log) + O(n^2) = O(n^2)
  }

  public static int searchTripletsCloseToTargetSolution2(int[] arr, int targetSum) {
    Arrays.sort(arr); // O(n * logn)
    int smallestDiff = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length - 2; i++) { // O(n)
      int left = i + 1;
      int right = arr.length - 1;

      while (left < right) { // O(n)
        int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
        if (targetDiff == 0) return targetSum;

        if (Math.abs(targetDiff) < Math.abs(smallestDiff)
            || Math.abs(targetDiff) == Math.abs(smallestDiff) && targetDiff > smallestDiff) {
          smallestDiff = targetDiff;
        }

        if (targetDiff > 0) {
          left++;
        } else {
          right--;
        }
      }
    }
    return targetSum - smallestDiff;
  }
}
