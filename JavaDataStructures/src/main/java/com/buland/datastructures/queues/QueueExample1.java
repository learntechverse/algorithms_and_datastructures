package com.buland.datastructures.queues;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample1 {

    public static void main(String[] args) {

        System.out.println("---------------- Queues Using ArrayDeque --------------");
        Queue<String> personsQueue1 = new ArrayDeque<String>(); //will act as a queue rather then deque/stack
        personsQueue1.offer("Person One");
        personsQueue1.offer("Person Two");
        personsQueue1.offer("Person Three");
        System.out.printf("Total Persons in Queue: %s\n", personsQueue1);
        System.out.printf("Peeking in the Queue: %s\n", personsQueue1.peek());
        System.out.printf("Pooling from the Queue: %s\n", personsQueue1.poll()); //no pop method like stack so pool will remove the 1st item from queue
        System.out.printf("Total Persons in Queue: %s\n", personsQueue1);

        System.out.println("\n---------------- Queues Using LinkedList --------------");
        Queue<String> personsQueue2 = new LinkedList<String>();
        personsQueue2.offer("Person One");
        personsQueue2.offer("Person Two");
        personsQueue2.offer("Person Three");
        System.out.printf("Total Persons in Queue: %s\n", personsQueue2);
        System.out.printf("Peeking in the Queue: %s\n", personsQueue2.peek());
        System.out.printf("Pooling from the Queue: %s\n", personsQueue2.poll());
        System.out.printf("Total Persons in Queue: %s\n", personsQueue2);

        System.out.println("\n---------------- Queues Using PriorityQueue --------------");

        /**
         * What's happening here is with a priority queue,  the retrieval order is the natural order.  So for strings, it's done alphabetically.
         * So person one is still first  because it's first alphabetically,  but person three comes before person two alphabetically.
         * So the order's actually person one person three person two.  So when I remove the first element,  it removes person one,
         * but it leaves person three  and then person two, because it's done it alphabetically.
         *
         * If it was a queue of numbers,  even if you put the numbers in a random order,  the first ones to be retrieved will be the lowest.
         * And the last one will be the highest number.
         *
         * A PriorityQueue is used when the objects are supposed to be processed based on the priority. It is known that a Queue follows the
         * First-In-First-Out algorithm, but sometimes the elements of the queue are needed to be processed according to the priority, that’s
         * when the PriorityQueue comes into play.
         *
         * The PriorityQueue is based on the priority heap. The elements of the priority queue are ordered according to the natural ordering, or
         * by a Comparator provided at queue construction time, depending on which constructor is used.
         *
         * A few important points on Priority Queue are as follows:
         *
         *  PriorityQueue doesn’t permit null.
         *  We can’t create a PriorityQueue of Objects that are non-comparable
         *  PriorityQueue are unbound queues.
         *  The head of this queue is the least element with respect to the specified ordering. If multiple elements are tied for the least value, the head is one of those elements — ties are broken arbitrarily.
         *  Since PriorityQueue is not thread-safe, java provides PriorityBlockingQueue class that implements the BlockingQueue interface to use in a java multithreading environment.
         *  The queue retrieval operations poll,  remove,  peek, and element access the element at the head of the queue.
         *  It provides O(log(n)) time for add and poll methods.
         *
         *  Java PriorityQueue Time Complexity
         *
         *     For enqueing and dequeing methods, the time complexity is O(log(n))
         *     For the remove(Object) and contains(Object) methods, the time complexity is linear
         *     For the retrieval methods, it has constant time complexity
         */
        Queue<String> personsQueue3 = new PriorityQueue<String>();
        personsQueue3.offer("Person One");
        personsQueue3.offer("Person Two");
        personsQueue3.offer("Person Three");
        System.out.printf("Total Persons in Queue: %s\n", personsQueue3);
        System.out.printf("Peeking in the Queue: %s\n", personsQueue3.peek());
        System.out.printf("Pooling from the Queue: %s\n", personsQueue3.poll()); //remove in specific order and for string its alphabetically
        System.out.printf("Total Persons in Queue: %s\n", personsQueue3);

        System.out.println("\n---------------- Queues Using PriorityQueue with Numbers --------------");
        Queue<Integer> personsQueue4 = new PriorityQueue<Integer>();
        personsQueue4.offer(5);
        personsQueue4.offer(11);
        personsQueue4.offer(1);
        personsQueue4.offer(-1);
        System.out.printf("personsQueue4 Comparator: %s\n", ((PriorityQueue)personsQueue4).comparator());
        System.out.printf("Total Persons in Queue: %s\n", personsQueue4);
        System.out.printf("Peeking in the Queue: %s\n", personsQueue4.peek());
        System.out.printf("Pooling from the Queue: %s\n", personsQueue4.poll()); //remove in specific order and for string its alphabetically
        System.out.printf("Total Persons in Queue: %s\n", personsQueue4);

    }

}
