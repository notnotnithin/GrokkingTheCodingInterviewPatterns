package com.dawn.grokking.patterns;

public class ReverseLinkedList02 {

  public static void main(String[] args) {
    int left = 3, right = 6;

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(30);
    head.next.next.next = new ListNode(40);
    head.next.next.next.next = new ListNode(50);
    head.next.next.next.next.next = new ListNode(60);
    head.next.next.next.next.next.next = new ListNode(7);

    System.out.print("Original LinkedList is: ");
    ListNode res = head;
    while (res != null) {
      System.out.print(res.value + " ");
      res = res.next;
    }
    System.out.println();

    ListNode result = ReverseLinkedList02.reverseBetween(head, left, right);
    System.out.print("Reversed LinkedList between two specific nodes is: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }

  private static ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode previous = dummy;

    for (int i = 0; i < left - 1; ++i) {
      previous = previous.next;
    }

    ListNode current = previous.next;

    for (int i = 0; i < right - left; ++i) {
      ListNode NEXT = current.next;
      current.next = NEXT.next;
      NEXT.next = previous.next;
      previous.next = NEXT;
    }
    return dummy.next;
  }
}
