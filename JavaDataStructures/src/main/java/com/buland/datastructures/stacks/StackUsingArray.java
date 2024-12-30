package com.buland.datastructures.stacks;

/**
 * To implement a stack using arrays in Java, we need to follow the principles of a stack data structure, which operates on a
 * LIFO (Last In First Out) principle. The basic operations of a stack are:
 *
 *     push: Adds an element to the top of the stack.
 *     pop: Removes and returns the top element from the stack.
 *     peek: Returns the top element of the stack without removing it.
 *     isEmpty: Checks if the stack is empty.
 *     isFull: Checks if the stack is full (for an array-based implementation).
 *     size: Returns the current number of elements in the stack.
 *
 * Steps for Array-Based Stack Implementation:
 *
 *     Define an array to hold the stack elements.
 *     Use a pointer (often called top) to track the index of the top element in the stack.
 *     Implement methods to perform stack operations.
 *
 * Explanation:
 *
 *     Stack Structure:
 *         We define an array stackArray to hold the elements of the stack.
 *         The top variable keeps track of the index of the last element added to the stack (the top of the stack).
 *         The capacity variable holds the maximum number of elements the stack can store.
 *
 *     Push Operation:
 *         First, we check if the stack is full using the isFull() method.
 *         If not, we increment top and add the element to the array at the new top position.
 *
 *     Pop Operation:
 *         We check if the stack is empty using the isEmpty() method.
 *         If the stack is not empty, we return the element at the top index and decrement top.
 *
 *     Peek Operation:
 *         We check if the stack is empty.
 *         If not, we simply return the element at the top index without modifying the stack.
 *
 *     Utility Methods:
 *         isEmpty() checks if top == -1, indicating that no elements are in the stack.
 *         isFull() checks if top == capacity - 1, indicating the stack is full.
 *         size() returns top + 1 to get the current number of elements.
 *
 *     Main Method:
 *         Demonstrates the usage of the stack by performing push, pop, peek, and display operations.
 *
 * Time Complexity:
 *
 *     Push operation: O(1) (Constant time insertion).
 *     Pop operation: O(1) (Constant time removal).
 *     Peek operation: O(1) (Constant time access).
 *
 * Space Complexity:
 *
 *     O(n): The space used is proportional to the size of the stack array (n being the capacity of the stack).
 */
public class StackUsingArray {
    private int[] stackArray;  // Array to store stack elements
    private int top;           // Pointer to the top element in the stack
    private int capacity;      // Maximum capacity of the stack

    // Constructor to initialize the stack
    public StackUsingArray(int size) {
        stackArray = new int[size];  // Allocate memory for the stack
        capacity = size;             // Set the stack size
        top = -1;                    // Initialize the top pointer to -1 (empty stack)
    }

    // Function to push an element onto the stack
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + x);
            return;
        }
        stackArray[++top] = x;  // Increment the top and add the element
        System.out.println(x + " pushed to stack.");
    }

    // Function to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop.");
            return -1;
        }
        return stackArray[top--];  // Return the top element and decrement the top
    }

    // Function to peek at the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No element to peek.");
            return -1;
        }
        return stackArray[top];  // Return the top element
    }

    // Function to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Function to check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Function to get the current size of the stack
    public int size() {
        return top + 1;  // Since top starts at -1, add 1 to get the actual size
    }

    // Function to display the stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }


    public void displayInLIFOOrder() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }
    
    // Main function to demonstrate stack operations
    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(5);  // Create a stack of size 5

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.display();  // Show stack contents

        System.out.println("Top element is: " + stack.peek());  // Peek the top element

        stack.pop();
        stack.pop();

        stack.display();  // Show stack contents after popping

        System.out.println("Stack size is: " + stack.size());  // Get the size of the stack

        stack.push(60);  // Pushing when the stack is full should trigger an overflow
        stack.push(70);  // Demonstrating overflow condition

        stack.display();  // Show stack contents after popping
        stack.displayInLIFOOrder();  // Show stack contents after popping in LIFO Order
    }
}
