package com.dawn.grokking.patterns;

public class DietaryPlanPerformance18 {

  public static void main(String[] args) {
    int[] calories = {3, 2};
    int k = 2;
    int lower = 0, upper = 1;
    System.out.println(
        "Diet Plan Performance Count is: "
            + DietaryPlanPerformance18.dietPlanPointsCount(calories, k, lower, upper));
  }

  private static int dietPlanPointsCount(int[] calories, int k, int lower, int upper) {
    int n = calories.length;
    int windowSum = 0;
    int dietCount = 0;

    for (int i = 0; i < k; i++) {
      windowSum += calories[i];
    }

    if (windowSum < lower) dietCount -= 1;
    if (windowSum > upper) dietCount += 1;

    for (int i = 0; i < n - k; i++) {
      windowSum = windowSum - calories[i] + calories[i + k];
      if (windowSum < lower) dietCount -= 1;
      if (windowSum > upper) dietCount += 1;
    }
    return dietCount;
  }
}
