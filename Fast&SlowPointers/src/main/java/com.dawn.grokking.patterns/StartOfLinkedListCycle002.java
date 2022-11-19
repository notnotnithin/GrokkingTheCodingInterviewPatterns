package com.dawn.grokking.patterns;

public class StartOfLinkedListCycle002 {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);

    head.next.next.next.next.next.next = head.next.next;
    System.out.println(
        "LinkedList cycle start: " + StartOfLinkedListCycle002.findCycleStart(head).value);

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println(
        "LinkedList cycle start: " + StartOfLinkedListCycle002.findCycleStart(head).value);

    head.next.next.next.next.next.next = head;
    System.out.println(
        "LinkedList cycle start: " + StartOfLinkedListCycle002.findCycleStart(head).value);
  }

  public static ListNode findCycleStart(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    int cycleLength = 0;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        cycleLength = lengthOfLinkedListCycle(slow);
        break;
      }
    }
    return findStart(head, cycleLength);
  }

  public static int lengthOfLinkedListCycle(ListNode slow) {
    ListNode currentNode = slow;
    int cycleLength = 0;

    do {
      currentNode = currentNode.next;
      cycleLength += 1;

    } while (currentNode != slow);
    return cycleLength;
  }

  public static ListNode findStart(ListNode head, int cycleLength) {
    ListNode first = head;
    ListNode second = head;
    while (cycleLength > 0) {
      first = first.next;
      cycleLength--;
    }

    while (first != second) {
      first = first.next;
      second = second.next;
    }
    return first;
  }
}
