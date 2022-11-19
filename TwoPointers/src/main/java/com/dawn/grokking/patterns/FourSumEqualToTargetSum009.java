package com.dawn.grokking.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumEqualToTargetSum009 {

  public static void main(String[] args) {
    int[] arr = new int[] {2, 0, -1, 1, -2, 2};
    int targetSum = 2;
    System.out.println("Quadruplets in the given array are: " + searchQuadruplets(arr, targetSum));
  }

  public static List<List<Integer>> searchQuadruplets(int[] arr, int targetSum) {
    if (arr.length < 4) {
      throw new IllegalArgumentException(
          "Array length must be greater than or equal to 4 at least");
    }
    Arrays.sort(arr); // O(n.logn)
    List<List<Integer>> quadruplets = new ArrayList<>();
    for (int i = 0; i < arr.length - 3; i++) { // O(n)
      if (i > 0 && arr[i] == arr[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < arr.length - 2; j++) { // O(n)
        if (j > i + 1 && arr[j] == arr[j - 1]) {
          continue;
        }
        int left = j + 1;
        int right = arr.length - 1;

        while (left < right) { // O(n)
          int currentSum = arr[i] + arr[j] + arr[left] + arr[right];

          if (currentSum == targetSum) {
            quadruplets.add(0, Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
            left++;
            right--;
            while (left < right && arr[left] == arr[left - 1]) {
              left++;
            }
            while (left < right && arr[right] == arr[right + 1]) {
              right--;
            }
          } else if (currentSum < targetSum) {
            left++;
          } else {
            right--;
          }
        }
      }
    }
    // Time complexity: O(n.logn) + O(n^3) = O(n^3)
    return quadruplets;
  }
}
