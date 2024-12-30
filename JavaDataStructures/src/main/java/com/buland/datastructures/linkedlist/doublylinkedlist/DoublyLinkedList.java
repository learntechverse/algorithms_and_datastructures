package com.buland.datastructures.linkedlist.doublylinkedlist;

public class DoublyLinkedList {

    ListNode<Integer> head;

    ListNode<Integer> tail;

    int length;

    public DoublyLinkedList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    public Boolean isEmpty() {
        return length == 0; //head == null
    }

    public int length() {
        return this.length;
    }


    public void printForward(){
        System.out.println("\nSTART ------- printForward");
        ListNode<Integer> tmp = head;
        while (tmp!=null) {
            System.out.printf("%d -> ", tmp.data);
            tmp = tmp.next;
        }
        System.out.printf("null");
        System.out.println("\nEND ------- printForward");
    }

    public void printBackward(){
        System.out.println("\nSTART ------- printBackward");
        ListNode<Integer> tmp = tail;
        while (tmp!=null) {
            System.out.printf("%d -> ", tmp.data);
            tmp = tmp.previous;
        }
        System.out.printf("null");
        System.out.println("\nEND ------- printBackward");
    }

    public void insertAtStart(int data) {
        ListNode<Integer> newNode = new ListNode<Integer>(data);
        if (head==null || isEmpty() ) {
            head = newNode;
            tail = newNode;
        } else {
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public void insertAtEnd(int data) {
        ListNode<Integer> newNode = new ListNode<Integer>(data);
        if (head==null || isEmpty() ) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        length++;
    }

    public ListNode<Integer> deleteFirstNode() {
        if ( head==null || isEmpty()) return null;

        ListNode<Integer> removedNode = head;
        if ( head == tail ) tail = null;
        head = head.next;
        head.previous = null;
        removedNode.next = null;
        length--;
        return removedNode;
    }


    public ListNode<Integer> deleteLastNode() {
        if ( head==null || isEmpty()) return null;

        ListNode<Integer> removedNode = tail;
        if ( head == tail ) {
            head = tail = null;
        } else {

            tail = tail.previous;
            tail.next = null;
        }
        length--;
        return removedNode;
    }

}
