package com.dawn.grokking.patterns;

public class LinkedListCycle001 {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);

    System.out.println("LinkedList has cycle: " + LinkedListCycle001.hasCycle(head));

    head.next.next.next.next.next.next = head.next.next;
    System.out.println("LinkedList has cycle: " + LinkedListCycle001.hasCycle(head));

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("LinkedList has cycle: " + LinkedListCycle001.hasCycle(head));

    System.out.println("LinkedList cycle length: " + LinkedListCycle001.cycleLength(head));
  }

  public static boolean hasCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  public static int cycleLength(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (slow == fast) {
        return calculateCycleLength(slow);
      }
    }
    return 0;
  }

  public static int calculateCycleLength(ListNode slow) {
    ListNode currentNode = slow;
    int cycleLength = 0;

    do {
      currentNode = currentNode.next;
      cycleLength++;
    } while (currentNode != slow);
    return cycleLength;
  }
}
