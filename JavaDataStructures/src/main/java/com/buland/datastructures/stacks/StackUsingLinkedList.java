package com.buland.datastructures.stacks;

import java.util.EmptyStackException;

public class StackUsingLinkedList {

    ListNode top;
    int length;

    public StackUsingLinkedList() {
        this.top = null;
        length = 0;
    }

    public Boolean isEmpty() {
        return length==0;
    }

    public void push(int data) {
        ListNode newTop = new ListNode(data);
        newTop.next = top; //insert at the start/top
        top = newTop;
        length++;
    }

    public ListNode pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        ListNode takenOutNode = top;
        top = top.next;
        length--;
        return takenOutNode;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public void print() {
        System.out.println("\nPrinting data......");
        ListNode tmpNode = top;
        while (tmpNode!=null) {
            System.out.printf("%d -> ", tmpNode.data);
            tmpNode = tmpNode.next;
        }
    }

    public static void main(String[] args) {
        StackUsingLinkedList ssll = new StackUsingLinkedList();
        ssll.push(10);
        ssll.push(15);
        ssll.print();

        ListNode poppedNode = ssll.pop();
        System.out.printf("\nPoppedOut Node Data: %d ->", poppedNode.data);
        ssll.print();

        System.out.printf("\nPeek Stack Data: %d", ssll.peek());
    }

}

class ListNode {
    ListNode next;
    int data;

    public ListNode(int data) {
        this.data = data;
    }
}
