package com.dawn.grokking.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubarrayWithProductLessThanTarget007 {

  public static void main(String[] args) {
    int[] arr = new int[] {2, 5, 3, 10};
    int targetSum = 30;

    System.out.println(
        "Subarray's whose product is less than the target are: "
            + SubarrayWithProductLessThanTarget007.searchSubarraysLessThanTarget(arr, targetSum));
  }

  public static List<List<Integer>> searchSubarraysLessThanTarget(int[] arr, int targetSum) {
    Arrays.sort(arr);
    List<List<Integer>> subarrays = new ArrayList<>();
    double product = 1;
    int left = 0;
    for (int right = 0; right < arr.length; right++) {
      product *= arr[right];

      while (product >= targetSum && left < arr.length) {
        product /= arr[left++];

        List<Integer> tempList = new LinkedList<>();
        for (int j = right; j >= left; j--) {
          tempList.add(0, arr[j]);
          subarrays.add(new ArrayList<>(tempList));
        }
      }
    }
    return subarrays;
  }
}
