package com.buland.datastructures.linkedlist;

import java.util.Stack;

public class TestLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        /*
        sll.insertEnd(1);
        sll.insertEnd(10);
        sll.insertEnd(5);
        sll.print();
        System.out.println("Inserting at specific indexes..........");
        sll.insertAt(15,1);
        sll.insertAt(6,0);
*/
        sll.insertEnd(0);
        sll.insertEnd(1);
        sll.insertEnd(2);
        sll.insertEnd(3);
        sll.print();

        ListNode ln = sll.reverseList(sll.head);
        sll.print(ln);
        System.out.println("-------------");

        sll = new SinglyLinkedList();
        sll.insertEnd(0);
        sll.insertEnd(1);
        sll.insertEnd(2);
        sll.insertEnd(3);
        ListNode ln1 = sll.reverseList1(sll.head);
        sll.print(ln1);

    }
}
