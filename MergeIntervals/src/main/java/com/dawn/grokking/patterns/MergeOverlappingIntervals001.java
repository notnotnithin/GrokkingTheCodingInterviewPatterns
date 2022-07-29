package com.dawn.grokking.patterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MergeOverlappingIntervals001 {

  public static void main(String[] args) {
    List<Interval> input = new ArrayList<>();
    input.add(new Interval(1, 5));
    input.add(new Interval(4, 8));
    input.add(new Interval(7, 9));

    System.out.print("Merged intervals: ");
    for (Interval interval : MergeOverlappingIntervals001.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }

  public static List<Interval> merge(List<Interval> intervals) {
    if (intervals.size() < 2) {
      return intervals;
    }
    Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
    List<Interval> mergedIntervals = new ArrayList<>();
    Iterator<Interval> iteratorPtr = intervals.iterator();
    Interval interval = iteratorPtr.next();
    int start = interval.start;
    int end = interval.end;

    while (iteratorPtr.hasNext()) {
      interval = iteratorPtr.next();
      if (interval.start <= end) {
        end = Math.max(interval.end, end);
      } else {
        mergedIntervals.add(new Interval(start, end));
        start = interval.start;
        end = interval.end;
      }
    }
    mergedIntervals.add(new Interval(start, end));
    return mergedIntervals;
  }
}
