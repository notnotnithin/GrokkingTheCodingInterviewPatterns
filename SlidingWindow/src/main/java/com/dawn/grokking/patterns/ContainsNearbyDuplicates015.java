package com.dawn.grokking.patterns;

import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicates015 {

  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 3, 4};
    int k = 3;
    System.out.println(
        "Does the array contain duplicates? " + ContainsNearbyDuplicates015.isDuplicate(arr, k));
  }

  public static boolean isDuplicate(int[] nums, int k) {
    Set<Integer> uniqueSet = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      if (i > k) {
        uniqueSet.remove(nums[i - k - 1]);
      }
      if (!uniqueSet.add(nums[i])) {
        return true;
      }
    }
    return false;
  }
}
