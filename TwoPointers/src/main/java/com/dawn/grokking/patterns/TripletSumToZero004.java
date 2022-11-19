package com.dawn.grokking.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero004 {

  public static void main(String[] args) {
    int[] arr = {-2, -2, 0, 0, 2, 2};
    System.out.println(
        "Triplets whose sum equal to zero using brute force approach are: "
            + TripletSumToZero004.searchTripletsBruteForce(arr));
    System.out.println(
        "Triplets whose sum equal to zero using two pointers approach are: "
            + TripletSumToZero004.searchTripletsUsingTwoPointersApproach(arr));
  }

  public static List<List<Integer>> searchTripletsBruteForce(int[] arr) {
    Arrays.sort(arr);
    List<List<Integer>> triplets = new ArrayList<>();
    int targetSum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (i > 0 && arr[i] == arr[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < arr.length; j++) {
        if (j > 0 && arr[j] == arr[j - 1]) {
          continue;
        }
        for (int k = j + 1; k < arr.length; k++) {
          if (k > 0 && arr[k] == arr[k - 1]) {
            continue;
          }
          if (arr[i] + arr[j] + arr[k] == targetSum) {
            triplets.add(Arrays.asList(arr[i], arr[j], arr[k]));
          }
        }
      }
    }
    return triplets;
  }

  public static List<List<Integer>> searchTripletsUsingTwoPointersApproach(int[] arr) {
    Arrays.sort(arr);
    List<List<Integer>> triplets = new ArrayList<>();
    int targetSum = 0;

    for (int i = 0; i < arr.length; i++) {
      int left = i + 1;
      int right = arr.length - 1;

      while (left < right) {
        int threeSum = arr[i] + arr[left] + arr[right];
        if (threeSum == targetSum) {
          triplets.add(Arrays.asList(arr[i], arr[left], arr[right]));
          left++;
          while (arr[left] == arr[left - 1] && left < right) {
            left++;
          }
        } else if (threeSum < targetSum) {
          left++;
        } else {
          right--;
        }
      }
    }
    return triplets;
  }
}
