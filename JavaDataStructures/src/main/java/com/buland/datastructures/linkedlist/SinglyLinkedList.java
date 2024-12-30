package com.buland.datastructures.linkedlist;

import java.time.Duration;
import java.time.Instant;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;

// Implementation for Singly Linked List
public class SinglyLinkedList {
    ListNode head;
    ListNode tail;

    public SinglyLinkedList() {
        //head = new ListNode(-1);
        //tail = head;
    }

    public void insertEnd(int val) {
        if (tail!=null) {
            tail.next = new ListNode(val);
            tail = tail.next;
        } else {
            //tail= new ListNode(val, null);
            tail= new ListNode(val);
            head=tail;
        }

    }

    public void insertAt(int val, int index) {
        int i =0;
        ListNode curr = head;
        ListNode previous = null;
        while (i < index && curr != null) {
            i++;
            previous = curr;
            curr = curr.next;
        }

        //if cur is null means index is out of bound
        if (curr == null) throw new IndexOutOfBoundsException("provided index is out of bound");

        // insert the node at the given index
        ListNode ln = new ListNode(val);
        ln.next = curr;
        if (previous!=null) {
            previous.next = ln;
        } else {
            head = ln; //seems like the 1st index operation so need to adjust the header
        }
    }

    public void remove(int index) {
        int i = 0;
        ListNode curr = head;
        while (i < index && curr != null) {
            i++;
            curr = curr.next;
        }
        
        // Remove the node ahead of curr
        if (curr != null && curr.next != null) {
            if (curr.next == tail) {
                tail = curr;
            }
            curr.next = curr.next.next;
        }
    }

    public void print() {
        //ListNode curr = head.next;
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println(); //next line
    }

    public void print(ListNode ln) {
        //ListNode curr = head.next;
        ListNode curr = ln;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println(); //next line
    }

    /**
     * Reversing a Singly LinkedList
     * 1. Check if head is null than return
     * 2. Create two variables to store the nextNode and previousNode
     * 3. Loop through till head is null
     *  3.1 nextNode = head.next
     *  3.2 head.next = previousNode
     *  3.3 previousNode = head
     *  3.4 head = NextNode
     * 4. Return previousNode
     *
    *          * [0,1,2,3]
    *          * head = [0->1], nextNode = null, previousNode = null
    *          * head=[0->null], nextNode = [1->2], head=[1->2], previousNode = [0->null]
    *          * head=[1->2], nextNode = [2->3], head=[1->0], previousNode = [1->0]
    *          * head=[2->3], nextNode = [3->null], head=[2->1], previousNode = [2->1]
    *          * head=[3->null], nextNode = [null], head=[3->2], previousNode = [3->2]
    *          * head=[null], nextNode = [null], head=[3->2], previousNode = [3->2]
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        Instant start = Instant.now();
        if (head==null || head.next==null)
            return head;

        ListNode nextNode = null;
        ListNode previousNode = null;
        while (head!=null) {
            nextNode = head.next;
            head.next = previousNode;
            previousNode = head;
            head = nextNode;
        }
/*
            System.out.print("\n\n\nNextNode::");
            print(nextNode);
            System.out.print("HeadNode::");
            print(head);
            System.out.print("PreviousNode::");
            print(previousNode);
 */
        Instant end = Instant.now();
        System.out.println("Elapsed Time: "+ Duration.between(start, end).toString());
        return previousNode;
    }

    public ListNode reverseList1(ListNode head) {
        Instant start = Instant.now();
        //System.out.print(head);
        if (head==null || head.next==null)
            return head;

        ListNode previousNode = null;
        ListNode nextNode = null;
        while (head!=null) {
            //System.out.print("----"+head);
            nextNode = head.next;
            head.next = previousNode;
            previousNode = head;
            head = nextNode;
/*
            if ( previousNode != null ) {
                newNode = head.next;
                newNode.next = previousNode;
                previousNode = newNode;
            }
            else {
                newNode = head.next;
                newNode.next = head;
                newNode.next.next = null;
                previousNode = newNode;
            }
            head = head.next;
 */
        }
        Instant end = Instant.now();
        System.out.println("Elapsed Time: "+ Duration.between(start, end).toString());
        return previousNode;
    }

    /**
     *
     * @param head
     * @return
     */

    public ListNode reverseListWithStacks(ListNode head) {
        if (head==null || head.next==null)
            return head;

        ListNode reverseListNode = null;
        ListNode curr = head;
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head.next!=null) {
            stack.push(head);
            head = head.next;
        }
        stack.push(head);
        /*
        stack.forEach( li -> {
                if (reverseListNode == null) {
                    reverseListNode = new ListNode(li);
                } else {
                }
        });*/
        System.out.println("Pooping val from Stack ......: "+stack.pop().val);
        //stack.forEach( node -> System.out.println( node.val) );
        return reverseListNode;
    }
    
}
