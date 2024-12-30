package com.buland.datastructures.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A stack is a data structure that works according to the LIFO principle: Elements that are placed on the stack last are taken out first – and vice versa.
 * A deque (pronounced "deck"), on the other hand, is a data structure where elements can be inserted into and removed from two sides (enqueue/dequeue with front/back)
 *
 * Stack is a class (→ all details about the Stack class), so it is a concrete implementation of the stack data type.
 * Deque, on the other hand, is an interface (→ all details about the Deque interface) and has several implementations with different characteristics. Therefore, you can choose a suitable deque implementation based on your requirements.
 *
 * In the Stack class, all methods are marked with the synchronized keyword. Therefore, you can safely use Stack in a multithreaded application.
 * For a single-threaded application, however, this synchronization is superfluous and would hurt performance. Furthermore, synchronization by pessimistic locking is only useful in situations with many access conflicts ("thread contention"). Otherwise, optimistic locking makes more sense.
 * The JDK offers, on the one hand, non-thread-safe implementations that work without locks (ArrayDeque and LinkedList) – and, on the other hand, thread-safe implementations that use a pessimistic lock (LinkedBlockingDeque) or optimistic locking (ConcurrentLinkedDeque).
 */
public class DequeExample {

    public static void main(String[] args) {
        Deque<String> fruits = new ArrayDeque<String>(); //it is not
        fruits.push("Apples");
        fruits.push("Oranges");
        fruits.push("Kiwis");

        System.out.println("All Fruits: "+fruits); //shows in the LIFO order which is how Stack behaves
        System.out.println("Last Fruit Added: "+fruits.peek());
        System.out.println("Last Fruit Added: "+fruits.pop());
        System.out.println("All Fruits: "+fruits); //shows in same order as created which is not how Stack behaves so confusing
        System.out.println("All Fruits: "+fruits.poll()); //pops the top most stack element
        System.out.println("All Fruits: "+fruits); //shows in same order as created which is not how Stack behaves so confusing
        fruits.push("Oranges");
        fruits.push("Kiwis");
        System.out.println("All Fruits: "+fruits); //shows in same order as created which is not how Stack behaves so confusing
        System.out.println("All Fruits: "+fruits.pollLast()); //pops the last most stack element (1st element that was added)
        System.out.println("All Fruits: "+fruits); //shows in same order as created which is not how Stack behaves so confusing

        /**
         * Difference b/w pop & poll
         * 1. Pop on empty queue throws an error
         * 2. Pool on empty queue returns null
         */
    }
}
