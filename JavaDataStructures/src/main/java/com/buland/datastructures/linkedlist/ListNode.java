package com.buland.datastructures.linkedlist;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode() {}

    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}