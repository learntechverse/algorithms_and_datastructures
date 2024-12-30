package com.buland.datastructures.linkedlist.singltlinkedlist;

import java.util.List;

/**
 * 1 -> 2 -> 3 -> null (Singly Linked List)
 * 1 -> 2 -> 3 -> 1 (Circular Singly Linked List, Tail points to head)
 *
 * In singly linked list we use head to track the nodes but for circular singly linked list we use last to track the nodes
 */
public class CircularSinglyLinkedList {

    ListNode<Integer> last;

    int length;

    public CircularSinglyLinkedList() {
        last = null;
        length = 0;
    }

    public int length() {
        return this.length;
    }

    public Boolean isEmpty() {
        return (last == null || length == 0);
    }

    public void insertAtStart(int data) {
        ListNode<Integer> newNode = new ListNode<Integer>(data);
        if ( isEmpty() ) {
            last = newNode;
            newNode.next = newNode;
        } else {
            ListNode<Integer> tmpNode = last.next;
            newNode.next = tmpNode;
            last.next = newNode;
        }
        length++;
    }

    public void insertAtEnd(int data) {
        ListNode<Integer> newNode = new ListNode<Integer>(data);
        if ( isEmpty() ) {
            newNode.next = newNode;
        } else {
            ListNode<Integer> tmpNode = last.next;
            newNode.next = tmpNode;
            last.next = newNode;
        }
        last = newNode;
        length++;
    }

    public ListNode<Integer> removeFirstNode() {
        ListNode<Integer> removedNode = null;
        if ( isEmpty() ) return null;
        if (length == 1) {
            last = null;
        } else {
            removedNode = last.next;
            last.next = last.next.next;
        }
        length--;
        return removedNode;
    }


    public ListNode<Integer> removeLastNode() {
        ListNode<Integer> removedNode = null;
        if ( isEmpty() ) return null;
        if (length == 1) {
            last = null;
        } else {
            removedNode = last;
            ListNode<Integer> head = last.next;
            ListNode<Integer> newLast = last.next;
            while (newLast.next!=last) {
                newLast = newLast.next;
            }
            last = newLast;
            last.next = head;
        }
        length--;
        return removedNode;
    }

    public void printForward() {
        ListNode<Integer> head = last.next;
        while (head!=last) {
            System.out.printf("%s -> ", head.data);
            head = head.next;
        }
        System.out.printf("%s -> ....\n", head.data);
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        ListNode<Integer> first = new ListNode<>(0);
        ListNode<Integer> second = new ListNode<>(1);
        ListNode<Integer> third = new ListNode<>(2);
        
        first.next = second;
        second.next = third;
        third.next = first;
        csll.last = third;
        csll.length = 3;

        csll.printForward();

        csll.insertAtStart(-1);
        csll.printForward();

        csll.insertAtEnd(3);
        csll.printForward();
        csll.insertAtEnd(4);
        csll.printForward();

        ListNode<Integer> removedNode = csll.removeFirstNode();
        System.out.printf("\nRemoved First Node: %d\n", removedNode.data);
        csll.printForward();

        removedNode = csll.removeFirstNode();
        System.out.printf("\nRemoved First Node: %d\n", removedNode.data);
        csll.printForward();

        removedNode = csll.removeLastNode();
        System.out.printf("\nRemoved Last Node: %d\n", removedNode.data);
        csll.printForward();

        removedNode = csll.removeLastNode();
        System.out.printf("\nRemoved Last Node: %d\n", removedNode.data);
        csll.printForward();

    }
}
