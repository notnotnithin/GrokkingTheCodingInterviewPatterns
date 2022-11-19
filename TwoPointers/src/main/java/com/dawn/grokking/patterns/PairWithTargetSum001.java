package com.dawn.grokking.patterns;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairWithTargetSum001 {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 6};
    int target = 6;
    System.out.println(
        "Pair adding up to the target sum using two pointer approach is: "
            + Arrays.toString(PairWithTargetSum001.findPairByTwoPointersApproach(arr, target)));
    System.out.println(
        "Pair adding up to the target sum using a hash map approach is: "
            + Arrays.toString(PairWithTargetSum001.findPairByHashMapApproach(arr, target)));
  }

  public static int[] findPairByTwoPointersApproach(int[] arr, int targetSum) {
    if (arr.length < 2) {
      System.out.println("Array should contain more than 2 data elements.");
      return new int[] {};
    }
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

  public static int[] findPairByHashMapApproach(int[] arr, int targetSum) {
    if (arr.length < 2) {
      System.out.println("Array should contain more than 2 data elements.");
      return new int[] {};
    }
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(targetSum - arr[i])) {
        return new int[] {map.get(targetSum - arr[i]), i};
      } else {
        map.put(arr[i], i);
      }
    }
    return new int[] {-1, -1};
  }
}
