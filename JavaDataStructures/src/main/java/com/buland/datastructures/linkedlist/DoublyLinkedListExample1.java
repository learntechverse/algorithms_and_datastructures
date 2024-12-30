package com.buland.datastructures.linkedlist;

// Define the Node class
class Node {
    int data; // Data stored in the node
    Node next; // Pointer to the next node
    Node prev; // Pointer to the previous node

    // Constructor to initialize the node with data
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// Class to manage the doubly linked list
public class DoublyLinkedListExample1 {

    // Function to traverse the doubly linked list 
    // in forward direction
    static void forwardTraversal(Node head) {
      
        // Start traversal from the head of the list
        Node curr = head;

        // Continue until the current node is 
        // null (end of the list)
        while (curr != null) {
          
            // Output data of the current node
            System.out.print(curr.data + " ");
          
            // Move to the next node
            curr = curr.next;
        }

        // Print newline after traversal
        System.out.println();
    }

    // Function to traverse the doubly linked list in backward direction
    static void backwardTraversal(Node tail) {
      
        // Start traversal from the tail of the list
        Node curr = tail;

        // Continue until the current node is 
        // null (end of the list)
        while (curr != null) {
          
            // Output data of the current node
            System.out.print(curr.data + " ");
          
            // Move to the previous node
            curr = curr.prev;
        }

        // Print newline after traversal
        System.out.println();
    }

    static int FindLength(Node head) {
        int count = 0;
        for (Node cur = head; cur != null; cur = cur.next)
            count++;
        return count;
    }

    // Insert a node at the beginning
    static Node insertBegin(Node head, int data) {

        // Create a new node
        Node new_node = new Node(data);

        // Make next of it as head
        new_node.next = head;

        // Set previous of head as new node
        if (head != null) {
            head.prev = new_node;
        }

        // Return new node as new head
        return new_node;
    }

    /** Function to insert a new node at a given position
     *
     * First look is its at pos 1 than deal it like insertBegin(..) function above
     *  1. Set the new Node
     *  2. Set New Node.next = currentHead
     *  3. if currentHead != null than currentHead.prev = New Node
     *
     * If not at Position #1 (At start/head)
     *  1. Loop through till (Position -1) to get to the node after which we will insert new Node (save visiting node to insertAfterNode)
     *  2. If insertAfterNode after the loop is null, it means Position is not within bounds hence throw error/exception
     *  3. Create the new Node
     *  4. Set new Node.next = insertAfterNode.next
     *  5. Set new Node.prev = insertAfterNode
     *  6. set insertAfterNode.next.prev = New Node
     *  7. set insertAfterNode.next = New Node
     *
     * @param head
     * @param pos
     * @param new_data
     * @return
     */
    public static Node insertAtPosition(Node head, int pos, int new_data) {
        // Create a new node
        Node new_node = new Node(new_data);

        // Insertion at the beginning
        if (pos == 1) {
            new_node.next = head;

            // If the linked list is not empty, set the prev of head to new node
            if (head != null) {
                head.prev = new_node;
            }

            // Set the new node as the head of linked list
            head = new_node;
            return head;
        }

        Node curr = head;

        // Traverse the list to find the node before the insertion point
        for (int i = 1; i < pos - 1 && curr != null; ++i) {
            curr = curr.next;
        }

        // If the position is out of bounds
        if (curr == null) {
            System.out.println("Position is out of bounds.");
            return head;
        }

        // Set the prev of new node to curr
        new_node.prev = curr;

        // Set the next of new node to next of curr
        new_node.next = curr.next;

        // Update the next of current node to new node
        curr.next = new_node;

        // If the new node is not the last node, update prev of next node to new node
        if (new_node.next != null) {
            new_node.next.prev = new_node;
        }

        // Return the head of the doubly linked list
        return head;
    }

    // Print the doubly linked list
    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
      
        // Sample usage of the doubly linked
        // list and traversal functions
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(4);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;

        System.out.println("Forward Traversal:");
        forwardTraversal(head);

        System.out.println("Backward Traversal:");
        backwardTraversal(third);

        System.out.println("LinkedList length: "+ FindLength(head));

        //head = insertBegin(head, 0);
        //printList(head);

        int data = 3;
        int pos = 3;
        head = insertAtPosition(head, pos, data);
        printList(head);
    }
}