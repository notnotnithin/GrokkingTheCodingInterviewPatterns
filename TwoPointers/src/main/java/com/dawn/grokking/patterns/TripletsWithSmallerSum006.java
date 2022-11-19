package com.dawn.grokking.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsWithSmallerSum006 {

  public static void main(String[] args) {
    int[] arr = {-1, 4, 2, 1, 3};
    int targetSum = 5;
    System.out.println(
        "Triplets count whose sum is less than the target are: "
            + TripletsWithSmallerSum006.searchTripletsCountWithSmallerSum(arr, targetSum));

    System.out.println(
        "Triplets whose sum is less than the target are: "
            + TripletsWithSmallerSum006.searchTripletsWithSmallerSum(arr, targetSum));
  }

  public static int searchTripletsCountWithSmallerSum(int[] arr, int targetSum) {
    Arrays.sort(arr); // O(n.logn)
    int tripletsCount = 0;

    for (int i = 0; i < arr.length - 2; i++) { // O(n)
      int left = i + 1;
      int right = arr.length - 1;

      while (left < right) { // O(n)
        int currentSum = arr[i] + arr[left] + arr[right];

        if (currentSum < targetSum) {
          tripletsCount += right - left;
          left++;
        } else {
          right--;
        }
      }
    }
    // time complexity: O(n.logn)+O(n^2) = O(n^2)
    return tripletsCount;
  }

  public static List<List<Integer>> searchTripletsWithSmallerSum(int[] arr, int targetSum) {
    Arrays.sort(arr); // O(n.logn)
    List<List<Integer>> triplets = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) { // O(n)
      int left = i + 1;
      int right = arr.length - 1;

      while (left < right) { // O(n)
        int currSum = arr[i] + arr[left] + arr[right];

        if (currSum < targetSum) {
          for (int j = right; j > left; j--) // O(n)
            triplets.add(Arrays.asList(arr[right], arr[left], arr[i]));
          left++;
        } else {
          right--;
        }
      }
    }
    // time complexity: O(n.logn)+O(n^3) = O(n^3)
    return triplets;
  }
}
