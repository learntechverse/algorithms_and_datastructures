package com.buland.datastructures.linkedlist.singltlinkedlist;

import java.util.LinkedList;

public class ListNode <T> implements Cloneable {

    public T data;
    public ListNode<T> next;

    ListNode(T data) {
        this.data = data;
        this.next = null;
    }
}
