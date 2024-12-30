package com.buland.datastructures.linkedlist;// Java Program to Demonstrate
// Implementation of LinkedList
// class

// Importing required classes
import java.util.*;

// Main class
public class LinkedListUsageExample1 {

    // Driver code
    public static void main(String args[]) {
        // Creating object of the
        // class linked list
        LinkedList<String> ll = new LinkedList<String>();

        // Adding elements to the linked list
        ll.add("A");
        ll.add("B");
        ll.addLast("D");
        ll.addFirst("E");
        ll.add(2, "C");
        ll.set(1, "BB");

        System.out.println(ll);

        ll.remove("B");
        ll.remove(3);
        ll.removeFirst();
        ll.removeLast();

        System.out.println(ll);

        ll.clear();

        ll.add("B");
        ll.add("C");
        ll.addLast("E");
        ll.addFirst("A");
        ll.add(2, "D");

        // Using the Get method and the
        // for loop
        for (int i = 0; i < ll.size(); i++) {
            System.out.print(ll.get(i) + " ");
        }

        System.out.println();

        // Using the for each loop
        for (String str : ll)
            System.out.print(str + " ");

        //LinkedList to Array
        Object[] a = ll.toArray();
        System.out.print("\nAfter converted LinkedList to Array: ");
        for (Object element : a)
            System.out.print(element + " ");

    }
}