package com.dawn.grokking.patterns;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates002 {

  public static void main(String[] args) {
    int[] arr = new int[] {2, 2, 3, 3, 3, 6, 9, 9};
    System.out.println(
        "After removing duplicates array is: " + RemoveDuplicates002.removeDuplicates(arr));

    arr = new int[] {3, 2, 3, 6, 3, 10, 9, 3};
    System.out.println(
        "After removing instances of key the array is: "
            + RemoveDuplicates002.removeInstancesOfKey(arr, 3));
  }

  public static List<Integer> removeDuplicates(int[] arr) {
    int nextNonDuplicate = 1;

    List<Integer> res = new ArrayList<>();
    res.add(arr[0]);

    for (int i = 0; i < arr.length; i++) {
      if (arr[nextNonDuplicate - 1] != arr[i]) {
        arr[nextNonDuplicate] = arr[i];
        res.add(arr[nextNonDuplicate]);
        nextNonDuplicate++;
      }
    }
    return res;
  }

  public static List<Integer> removeInstancesOfKey(int[] arr, int key) {
    int nextElement = 0;

    List<Integer> res = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != key) {
        arr[nextElement] = arr[i];
        res.add(arr[nextElement]);
        nextElement++;
      }
    }
    return res;
  }
}
