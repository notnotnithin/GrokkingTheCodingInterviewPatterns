package com.dawn.grokking.patterns;

public class DutchNationalFlag008 {

  public static void main(String[] args) {
    int[] arr = new int[] {1, 0, 2, 1, 0};
    DutchNationalFlag008.sort(arr);
    System.out.println("After sorting the array is: ");
    for (int num : arr) {
      System.out.println(num + " ");
    }
  }

  public static void sort(int[] arr) {
    int low = 0, high = arr.length - 1;
    int i;
    for (i = 0; i <= high; ) {
      if (arr[i] == 0) {
        swap(arr, i, low);
        i++;
        low++;
      } else if (arr[i] == 1) {
        i++;
      } else {
        swap(arr, i, high);
        high--;
      }
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
