package com.dawn.grokking.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class InsertInterval002 {

  public static void main(String[] args) {
    List<Interval> input = new ArrayList<>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval :
        Objects.requireNonNull(InsertInterval002.insert(input, new Interval(4, 6))))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval002.insert(input, new Interval(4, 10)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<>();
    input.add(new Interval(2, 3));
    input.add(new Interval(5, 7));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval002.insert(input, new Interval(1, 4)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }

  public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    if (intervals == null && intervals.isEmpty()) {
      return Arrays.asList(newInterval);
    }
    List<Interval> mergedIntervals = new ArrayList<>();

    // skip all intervals that come before the new interval and add to the resultant list.
    int i = 0;
    for (; i < intervals.size() && intervals.get(i).end < newInterval.start; ) {
      mergedIntervals.add(intervals.get(i++));
    }

    // merge all intervals which overlaps to the output
    for (; i < intervals.size() && intervals.get(i).start <= newInterval.end; ) {
      newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
      newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
      i++;
    }

    // insert whatever we added in newInterval to the resultant list
    mergedIntervals.add(newInterval);

    // add all the remaining intervals to the output
    for (; i < intervals.size(); ) {
      mergedIntervals.add(intervals.get(i++));
    }

    return mergedIntervals;
  }
}
