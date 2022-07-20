package com.dawn.grokking.patterns;

public class SquaringSortedArray003 {

  public static void main(String[] args) {
    int[] result = SquaringSortedArray003.makeSquares(new int[] {-2, -1, 0, 2, 3});
    for (int num : result) System.out.print(num + " ");
    System.out.println();
  }

  public static int[] makeSquares(int[] arr) {
    int n = arr.length;
    int[] squares = new int[n];
    int highestSquareIdx = n - 1;
    int left = 0, right = n - 1;
    /*
     * we are checking for all numbers whose squares are the greatest and hence we save
     * the squares at the end of the array (i.e., int highestSquareIdx = n - 1).
     */
    while (left <= right) {
      int leftSquare = arr[left] * arr[left];
      int rightSquare = arr[right] * arr[right];

      if (leftSquare > rightSquare) {
        squares[highestSquareIdx--] = leftSquare;
        left++;
      } else {
        squares[highestSquareIdx--] = rightSquare;
        right--;
      }
    }
    return squares;
  }
}
