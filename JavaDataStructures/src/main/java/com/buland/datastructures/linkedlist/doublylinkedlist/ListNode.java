package com.buland.datastructures.linkedlist.doublylinkedlist;

public class ListNode<T> {

    T data;

    ListNode<T> previous;

    ListNode<T> next;

    public ListNode(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}
