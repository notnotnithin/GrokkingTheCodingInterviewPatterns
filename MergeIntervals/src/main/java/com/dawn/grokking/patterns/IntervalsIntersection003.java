package com.dawn.grokking.patterns;

public class IntervalsIntersection003 {

  public static void main(String[] args) {
    Interval[] input1 = new Interval[] {new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
    Interval[] input2 = new Interval[] {new Interval(2, 3), new Interval(5, 7)};

    input1 = new Interval[] {new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)};
    input2 = new Interval[] {new Interval(5, 10)};
  }
}
