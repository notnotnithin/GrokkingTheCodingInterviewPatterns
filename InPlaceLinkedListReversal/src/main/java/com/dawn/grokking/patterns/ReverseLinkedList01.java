package com.dawn.grokking.patterns;

public class ReverseLinkedList01 {

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(8);
    head.next.next.next.next = new ListNode(10);

    System.out.print("Nodes of the original LinkedList are: ");
    ListNode res = head;
    while (res != null) {
      System.out.print(res.value + " ");
      res = res.next;
    }
    System.out.println();

    ListNode result = ReverseLinkedList01.reverse(head);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }

  private static ListNode reverse(ListNode head) {
    ListNode current = head;
    ListNode previous = null;
    ListNode next = null;

    while (current != null) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    return previous;
  }
}
