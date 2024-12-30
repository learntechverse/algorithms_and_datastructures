package com.buland.datastructures.linkedlist.doublylinkedlist;

public class DoublyLinkedListTest {

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        ListNode<Integer> node1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        ListNode<Integer> node4 = new ListNode<>(4);

        node1.next = node2;
        node2.previous = node1;
        node2.next = node3;
        node3.previous = node2;
        node3.next = node4;
        node4.previous = node3;

        dll.head = node1;
        dll.tail = node4;

        dll.printForward();
        dll.printBackward();

        dll = new DoublyLinkedList();
        dll.insertAtStart(5);
        dll.insertAtStart(4);
        dll.insertAtStart(3);
        dll.insertAtStart(2);
        dll.insertAtStart(1);
        dll.printForward();
        dll.printBackward();

        dll.insertAtEnd(7);
        dll.printForward();
        dll.printBackward();

        ListNode<Integer> removedNode = dll.deleteFirstNode();
        System.out.printf("\nRemovedNode: %s\n", (removedNode==null) ? "null" : (removedNode.data + " -> " + removedNode.next) );
        dll.printForward();
        dll.printBackward();

        removedNode = dll.deleteLastNode();
        System.out.printf("\nRemovedNode: %s\n", (removedNode==null) ? "null" : (removedNode.data + " -> " + removedNode.next) );
        dll.printForward();
        dll.printBackward();

        /*dll = new DoublyLinkedList();
        dll.insertAtStart(15);
        removedNode = dll.deleteLastNode();
        System.out.printf("\nRemovedNode: %s\n", (removedNode==null) ? "null" : (removedNode.data + " -> " + removedNode.next) );
        dll.printForward();
        dll.printBackward();*/


    }
}
