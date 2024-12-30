package com.buland.datastructures.linkedlist.singltlinkedlist;

import com.buland.datastructures.linkedlist.SinglyLinkedList;

import java.util.LinkedList;

public class SinglyLinkedListExample_1 {

    private ListNode<Integer> head;


    /**
     * print singly linkedlist data
     *
     * Time Complexity = O(n)
     */
    public void print(){
        System.out.println("");
        ListNode<Integer> tmpHead = head;
        while (tmpHead!=null) {
            System.out.printf("  %s --->",tmpHead.data);
            tmpHead = tmpHead.next;
        }
        System.out.printf(" %s","null");
    }

    public void printNode(ListNode<Integer> node){
        System.out.println("");
        ListNode<Integer> tmpHead = node;
        while (tmpHead!=null) {
            System.out.printf("  %s --->",tmpHead.data);
            tmpHead = tmpHead.next;
        }
        System.out.printf(" %s","null");
    }


    /**
     * length of a singly Linked List
     *
     * Time Complexity = O(n)
     *
     * @return
     */
    public int length(){
        ListNode<Integer> tmpHead = head;
        int length = 0;
        while (tmpHead!=null) {
            length++;
            tmpHead = tmpHead.next;
        }
        return length;
    }


    /**
     * Create a new node and add at as a header (at the start of the singly linked list)
     *
     * Time Complexity = O(1)
     *
     * @param data
     */
    public void insertAtStart(int data) {
        ListNode<Integer> newNode = new ListNode<Integer>(data);
        newNode.next = head;
        head = newNode;
    }


    /**
     * Create a new node and add at as a tail (at the end of the singly linked list)
     *
     * Time Complexity = O(n)
     *
     * @param data
     */
    public void insertAtEnd(int data) {
        ListNode<Integer> newNode = new ListNode<Integer>(data);
        if (head==null){
            insertAtStart(data);
            return;
        }
        ListNode<Integer> tmpNode = head;
        while (tmpNode.next!=null) {
            tmpNode = tmpNode.next;
        }
        tmpNode.next = newNode;

    }


    /**
     * 1. if head is null or position is 0, than it has to be inserted at the start
     * 2. otherwise loop through till either node.next is null or index< an earlier postion (earlier position because we needs to set given position previous possition next to new code
     * previous
     * 3. if out of the loop check if its out of bound position
     * 4. if #3 is not the case than we are at a node that is previoud to the given position so
     *      newNode.next = currentNode.next (current node at position set to newNode next)
     *      currentNode.next = newNode
     * @param data
     * @param position
     */
    public void insertAtGivenPos(int data, int position) {
        ListNode<Integer> newNode = new ListNode<Integer>(data);
        if (head==null || position==1) {
            insertAtStart(data);
            return;
        }

        ListNode<Integer> tmpNode = head;
        int index=1;
        while (tmpNode.next!=null && index<(position-1)) {
            tmpNode = tmpNode.next;
            index++;
        }

        if (tmpNode.next==null && index<=(position-1)) {
            throw new IndexOutOfBoundsException("Given Position is out of bound");
        }
        newNode.next = tmpNode.next;
        tmpNode.next = newNode;
    }

    public void insertAtGivenPosOption2(int data, int position) {
        ListNode<Integer> newNode = new ListNode<Integer>(data);
        if (head==null || position==1) {
            insertAtStart(data);
            return;
        }

        ListNode<Integer> previoudNode = head;
        int index=1;
        while (index<(position-1)) {
            previoudNode = previoudNode.next;
            index++;
        }

        if (previoudNode.next==null && index<=(position-1)) {
            throw new IndexOutOfBoundsException("Given Position is out of bound");
        }
        newNode.next = previoudNode.next;
        previoudNode.next = newNode;
    }

    /**
     * Time Complexity - O(1)
     */
    public void deleteFirstNode(){
        //ListNode<Integer> tmpNode = head.next;
        if (head==null){
            throw new IndexOutOfBoundsException("Singly LinkedList is empty or null");
        }
        head = head.next;
    }

    /**
     * Time Complexity - O(1)
     */
    public ListNode<Integer> deleteFirstNodeAndReturn(){
        ListNode<Integer> tmpNode = head;
        if (head==null){
            throw new IndexOutOfBoundsException("Singly LinkedList is empty or null");
        }
        head = head.next;
        tmpNode.next = null;
        return tmpNode;
    }

    /**
     * 1. you need two pointers, currentNode and previousNode.
     * 2. Iterator over currentNode (at start it points to head that is at the start of teh singly LinkedList) and goes till its next is not null
     * 3. 1st store currentNode to previousNode
     * 4. then make currentNode as currentNode.next
     * 5. Once out of the loop, currentNode points to the last node whoes next is null
     * 6. PreviousNode points to a node before the last last so set its next to null.
     *
     * Time Complexity - O(n)
     * @return
     */
    public ListNode<Integer> deleteLastNodeAndReturn(){
        if (head==null){
            throw new IndexOutOfBoundsException("Singly LinkedList is empty or null");
        }
        ListNode<Integer> previousNode = null;
        ListNode<Integer> currentNode = head;

        while (currentNode.next!=null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        previousNode.next = null;
        return currentNode;
    }

    /**
     * 1. if positions == 1 than just move head = head.next
     * 2. iterator over the singly linkedlist using a pointer referred here as currentNode till either currentNode.next is not null or index<one position before the given position
     * 3. Once outside the check if its not out of bound condition and if yes than throw an error
     * 4. if its not out of bound error than set currentNode.next = currentNode.next.next
     *
     * @param position
     * @return
     */
    public ListNode<Integer> deleteLastNodeAtGivenPositionAndReturn(int position){
        if (head==null){
            throw new IndexOutOfBoundsException("Singly LinkedList is empty or null");
        }

        ListNode<Integer> deletedNode = null;
        if (position == 1) {
            deletedNode = head;
            head = head.next;
            deletedNode.next = null;
            return deletedNode;
        }
        else {

            //ListNode<Integer> previousNode = null;
            ListNode<Integer> currentNode = head;
            int index = 1;
            while (currentNode.next != null && (index++ < (position - 1))) {
                //previousNode = currentNode;
                currentNode = currentNode.next;
            }

            if (currentNode.next == null && index <= (position - 1)) {
                throw new IndexOutOfBoundsException("Given Position is out of bound");
            }

            if (currentNode.next == null) { //this may never happen and always goes to else as we stop one position before the given position if its valid
                currentNode.next = null;
            } else {
                deletedNode = currentNode.next;
                currentNode.next = currentNode.next.next;
                deletedNode.next = null;
            }
        }
        return deletedNode;
    }


    /**
     * Time Complexity - O(n)
     *
     * @param dataKey
     * @return
     */
    public Boolean keyExists(int dataKey) {
        if (head==null){
            throw new IndexOutOfBoundsException("Singly LinkedList is empty or null");
        }

        ListNode<Integer> currentNode = head;
        while (currentNode!=null) {
            //System.out.printf("\ncurrentNode.data %d, (currentNode.data == dataKey) = %b",currentNode.data, (currentNode.data == dataKey ) );
            if ( currentNode.data == dataKey ) return Boolean.TRUE;
            currentNode = currentNode.next;
        }
        return Boolean.FALSE;
    }


    /**
     * /**
     *      * Reversing a Singly LinkedList
     *      * 1. Check if head is null than return
     *      * 2. Create three variables to store the currentNode, nextNode and previousNode
     *      * 3. Loop through till currentNode is null
     *      *  3.1 nextNode = currentNode.next
     *      *  3.2 currentNode.next = previousNode
     *      *  3.3 previousNode = currentNode
     *      *  3.4 currentNode = NextNode
     *      * 4. Return previousNode
     *      *
     *     *          * [0,1,2,3]
     *     *          * head = [0->1], nextNode = null, previousNode = null
     *     *          * head=[0->null], nextNode = [1->2], head=[1->2], previousNode = [0->null]
     *     *          * head=[1->2], nextNode = [2->3], head=[1->0], previousNode = [1->0]
     *     *          * head=[2->3], nextNode = [3->null], head=[2->1], previousNode = [2->1]
     *     *          * head=[3->null], nextNode = [null], head=[3->2], previousNode = [3->2]
     *     *          * head=[null], nextNode = [null], head=[3->2], previousNode = [3->2]
     *
     * Time Complexity: O(n)
     *
     * @return
     */
    public ListNode<Integer> reverseSinglyLinkedList(){
        if ( head==null) return head;

        ListNode<Integer> nextNode = null;
        ListNode<Integer> previousNode = null;
        ListNode<Integer> currentNode = head;
        while (currentNode!=null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
        return previousNode;
    }


    /**
     * for this algorithm, we have to keep in mind that List length might be even(0,2,4,6,8,...) or odd (1,3,5,7,...).
     *
     * Slow Pointer - moves one node at a time
     * Fast Pointer - moves two nodes at a time
     *
     * Idea is to travers one by one while fast pointer reaches end of the list, slow pointer will be at the middle of it.
     *
     * @return
     */
    public ListNode<Integer> findMiddleNode(){
        ListNode<Integer> slowPointer = head;
        ListNode<Integer> fastPointer = head;
        while (fastPointer!=null && fastPointer.next!=null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }


    /**
     * we can solve it in multiple ways.
     * 1. reverse the linkedlist and then scan through till the nth position and grab the node
     * 2. Another option shows below where the idea is that we use 2 pointers.
     *  2.1 In first loop, we move first pointer (pointer1) N times while pointer2 still points to the start of the list/head. Loop goes till counter starts with 1 is less than n (n here is the Nth position)
     *  2.2 In second loop, we iterate till pointer1 != null (reaches till the end) and keep moving both pointer1 and pointer2 to their next.
     *  2.3 return pointer2 as thats the nth position from the end
     *
     * @return
     */
    public ListNode<Integer> findNthNodeFromEnd(int nthPosition){
        if ( head==null) return head;

        ListNode<Integer> pointer1 = head;
        ListNode<Integer> pointer2 = head;
        int counter = 1;
        while (counter++ <= nthPosition) {
            if (pointer2==null) {
                throw new IllegalArgumentException(nthPosition + " is greater than the number of nodes in the list");
            }
            pointer2 = pointer2.next;
        }
        while (pointer2 != null) {
            pointer2 = pointer2.next;
            pointer1 = pointer1.next;
        }
        return pointer1;
    }


    /**
     * 1. loop through until either currentNodePointer is null or currentNodePointer.next is null
     * 2. inside loop check is currentNodePointer.data == currentNodePointer.next.data
     * 3. if #2 is true then currentNodePointer.next = currentNodePointer.next.next
     * 4. if #2 is false then currentNodePointer = currentNodePointer.next
     *
     * Time COmpelxity: O(n)
     */
    public void removeDuplicateFromSortedList() {
        if (head==null) return;

        ListNode<Integer> currentNodePointer = head;

        while (currentNodePointer!=null && currentNodePointer.next!=null) {
            if ( currentNodePointer.data == currentNodePointer.next.data) {
                currentNodePointer.next = currentNodePointer.next.next;
            } else {
                currentNodePointer = currentNodePointer.next;
            }
        }
    }

    /**
     * Algorithm steps.
     *
     * 1.create a new node with the new data
     * 2. create a pointer currentNode that points to head as well as previousNode that starts with null (idea is to always keeps the previoud node refrence as well)
     * 3. in the loop set previousNode = currentNode & currentNode = currentNode.next
     * 4. once loop ended than we either are at the node that has 1st highest data or just at the end if all data element are lesser than incoming data key
     *  4.1 previoudNode.next= tmpNode
     *  4.2 tmpNode.next = currentNode
     *
     * @param dataToBeInserted
     */
    public void insertInSortedList(int dataToBeInserted) {
        ListNode<Integer> tmpNode = new ListNode<Integer>(dataToBeInserted);
        if (head==null) {
             head = tmpNode;
        } else {
            ListNode<Integer> currentNode = head;
            ListNode<Integer> previoudNode = null;
            while (currentNode!=null && (currentNode.data<tmpNode.data)) {
                previoudNode = currentNode;
                currentNode = currentNode.next;
            }
            previoudNode.next = tmpNode;
            tmpNode.next = currentNode;
        }
    }

    /**
     * Algorithms steps.
     * 1. if head is null, return
     * 2. create two vars, previousNoe and currentNode = head
     * 3. look through till either currentNode is null or (currentNode.data!=dataKeyToBeRemoved)
     * 4. inside the loop set previousNode = currentNode and currentNode = currentNode.next
     * 5. Once outside the loop
     *  5.1 if currentNode==null than nothing to remove as key does not exists
     *  5.2 otherwise previousNode.next = currentNode.next
     *
     * @param dataKeyToBeRemoved
     */
    public void removeFromSortedList(int dataKeyToBeRemoved) {
        if (head==null) return;

        ListNode<Integer> previousNode = null;
        ListNode<Integer> currentNode = head;

        while (currentNode!=null && currentNode.data!=dataKeyToBeRemoved) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode==null) return;
        previousNode.next = currentNode.next;
    }


    /**
     * Idea is to use 2 pointer where one pointer moves faster than the other. Faster pointers move two point with each iteration while
     * slow pointer moves only one position and eventually they will be at same place, means there is a loop.
     *
     * @return
     */
    public Boolean detectLoopInSinglyLinkedList() {

        if (head==null) return Boolean.FALSE;

        ListNode<Integer> slowPointer = head;
        ListNode<Integer> fastPointer = head;

        while (fastPointer!=null && fastPointer.next!=null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (slowPointer == fastPointer) return Boolean.TRUE; //its a loop
        }

        return Boolean.FALSE;

    }


    /**
     * Idea is to use 2 pointer where one pointer moves faster than the other. Faster pointers move two point with each iteration while
     * slow pointer moves only one position and eventually they will be at same place, means there is a loop.
     *
     * Once we detect a loop than use a tmpPointer starting from head and until both tmpPointer & slowPointer are not equal keep
     * moving them one position with each iteration.
     *
     * Its based out of Floyd's Cycle Detection Algorithm.
     *
     * @return
     */
    public ListNode<Integer> findStartPointOfALoopInSinglyLinkedList() {
        if (head==null) return null;

        ListNode<Integer> slowPointer = head;
        ListNode<Integer> fastPointer = head;
        while (fastPointer!=null && fastPointer.next!=null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (slowPointer == fastPointer) { //detects a loop
                ListNode<Integer> tmpPointer = head;
                while (slowPointer!=tmpPointer) {
                    tmpPointer = tmpPointer.next;
                    slowPointer = slowPointer.next;
                }
                return tmpPointer;
            }
        }
        return null;
    }


    public void removeLoopFromSinglyList() {
        if (head==null) return;
        ListNode<Integer> fastPointer = head;
        ListNode<Integer> slowPointer = head;
        while (fastPointer!=null && fastPointer.next!=null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if(slowPointer == fastPointer) {
                ListNode<Integer> tmpNode = head;

                /**
                ListNode<Integer> previousNode = null;
                while (slowPointer!=tmpNode) {
                    previousNode = slowPointer;
                    slowPointer = slowPointer.next;
                    tmpNode = tmpNode.next;
                }
                previousNode.next = null;
                */

                while(slowPointer.next != tmpNode.next) {
                    slowPointer = slowPointer.next;
                    tmpNode = tmpNode.next;
                }
                slowPointer.next = null;

                return;
            }
        }
    }

    /**
     * Algorithm Steps.
     * 1. Creates a dummyNode ListNode and a tailNode node that points to dummyNode
     * 2. Iterator through ListA and ListB until both are not null (sortedListA!=null && sortedListB!=null)
     *  2.1 If ListA is lesser than ListB ( sortedListA.data <= sortedListB.data )
     *      2.1.1 tailNode.next = sortedListA
     *      2.1.2 sortedListA = sortedListA.next
     *  2.2 Otherwise
     *      2.2.1 tailNode.next = sortedListB
     *      2.2.2 sortedListB = sortedListB.next
     *  2.3 tailNode = tailNode.next
     * 3. We are outside the loop now, check if ListA is null means ListB remains so tailNode.next = sortedListB
     * 4. We are outside the loop now, check if ListB is null means ListA remains so tailNode.next = sortedListA
     * 5. as of now dummyNode that is point to head of merged list so return dummyNode.next
     *
     * Time Complexity: O(n)
     *
     * Its also LeetCode Question -
     *
     * @param sortedListA
     * @param sortedListB
     * @return
     */
    public ListNode<Integer> mergeTwoSortedSinglyLinkedList(ListNode<Integer> sortedListA,ListNode<Integer> sortedListB) {
        if (sortedListA==null) return sortedListB;
        if (sortedListB==null) return sortedListA;

        ListNode<Integer> dummyNode = new ListNode<Integer>(Integer.MIN_VALUE);
        ListNode<Integer> tailNode = dummyNode;

        while (sortedListA!=null && sortedListB!=null) {
            if (sortedListA.data <= sortedListB.data) {
                tailNode.next = sortedListA;
                sortedListA = sortedListA.next;
            } else {
                tailNode.next = sortedListB;
                sortedListB = sortedListB.next;
            }
            tailNode = tailNode.next;
        }//end while loop O(n)

        if (sortedListA==null) {
            tailNode.next = sortedListB;
        } else {
            tailNode.next = sortedListA;
        }
        return dummyNode.next;
    }


    /**
     * Q: ou are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * https://leetcode.com/problems/add-two-numbers/description/
     *
     * Algorithm Steps.
     *
     * As each Node can only have one digit so we use Two mathematical operators devision (/) by 10 and use answer as carry on and use
     * modulus (%) operator to get the ramainder and use it to set the next Node.
     *
     * 1. Create a dummyNode and tailNode and assign dummyNode to it. We will use this new node to store our resultand return this node
     * 2. look through till either of the list is not empty
     * 3. if list1 is not null than get its value and store into variable a
     * 4. if list2 is not null than get its value and store into variable b
     * 5. create a variable carryOnDigit
     * 6. do a sum of carryOnDigit + a + b (sum = carryOnDigit + a + b)
     * 7. do a division of teh sum with 10 and store result in the carryOnDigit ( carryOnDigit = sum / 10 )
     * 8. get a remainder of sum and create a new Node with it (ListNode<Integer> newNode = new ListNode</Integer>( sum % 10))
     * 9. tail.next = newNode
     * 10. tail = tail.next;
     * 11. If list1 is not empty than move the pointer (list1 = list1.next)
     * 12. If list2 is not empty than move the pointer (list2 = list2.next) --because carryOnDigit results is dividing single digit with 10 so it can always have only single digit
     * 13. Once we are outside loop, check if carryOnDigit is >0 than set it as a tail.next as a newNode (tail.next = new ListNode<Integer(carryOnDigit))
     * 14. retunr dummyNode.next
     *
     * Time Complexity: O(n)
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode<Integer> addTwoSinglyListList(ListNode<Integer> list1, ListNode<Integer> list2) {
        if (list1==null) return list2;
        if (list2==null) return list1;
        ListNode<Integer> dummyNode = new ListNode<Integer>(Integer.MIN_VALUE);
        ListNode<Integer> tailNode = dummyNode;
        int carryOnDigit = 0;
        while (list1!=null || list2!=null) {

            int a = (list1!=null) ? list1.data : 0;
            int b = (list2!=null) ? list2.data : 0;
            int sum = carryOnDigit + a + b;
            carryOnDigit = sum / 10;
            tailNode.next = new ListNode<Integer>(sum % 10);
            tailNode = tailNode.next;

            if (list1!=null) list1 = list1.next;
            if (list2!=null) list2 = list2.next;

        } //end of loop

        if ( carryOnDigit>0 ) {
            tailNode.next = new ListNode<Integer>(carryOnDigit);
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        SinglyLinkedListExample_1 sll = new SinglyLinkedListExample_1();
        sll.head = new ListNode<>(10);
        ListNode<Integer> second = new ListNode<>(1);
        ListNode<Integer> third = new ListNode<>(8);
        ListNode<Integer> forth = new ListNode<>(11);

        //setting chain
        sll.head.next = second; //10 --> 1 --> null
        second.next = third; //10 --> 1 --> 8 --> null
        third.next = forth; //10 --> 1 --> 8 --> 11 --> null

        sll.print();

        System.out.printf("\n Singly LisnkedList Length is %d",sll.length());

        sll.insertAtStart(13);
        sll.print();

        sll.insertAtEnd(7);
        sll.print();

        SinglyLinkedListExample_1 sll2 = new SinglyLinkedListExample_1();
        sll2.insertAtEnd(9);
        sll2.insertAtEnd(10);
        sll2.insertAtStart(8);
        sll2.print();

        sll2.insertAtGivenPos(2,3);
        sll2.insertAtGivenPos(12,2);
        sll2.insertAtGivenPosOption2(99,3);
        sll2.print();

        sll2.deleteFirstNode();
        sll2.print();

        ListNode<Integer> deletedNode = sll2.deleteFirstNodeAndReturn();
        sll2.print();
        System.out.printf("\nDeleted First Node: %d -> %s",deletedNode.data, deletedNode.next);

        deletedNode = sll2.deleteLastNodeAndReturn();
        sll2.print();
        System.out.printf("\nDeleted Last Node: %d -> %s",deletedNode.data, deletedNode.next);

        deletedNode = sll2.deleteLastNodeAtGivenPositionAndReturn(1);
        sll2.print();
        System.out.printf("\nDeleted Position=1 (1st Node): %d -> %s",deletedNode.data, deletedNode.next);

        deletedNode = sll2.deleteLastNodeAtGivenPositionAndReturn(2);
        sll2.print();
        System.out.printf("\nDeleted Position=2 (last Node): %d -> %s",deletedNode.data, deletedNode.next);

        sll2.insertAtGivenPos(2,1);
        sll2.insertAtGivenPos(12,2);
        sll2.insertAtGivenPosOption2(99,3);
        sll2.print();

        deletedNode = sll2.deleteLastNodeAtGivenPositionAndReturn(3);
        sll2.print();
        System.out.printf("\nDeleted Position=2 (last Node): %d -> %s",deletedNode.data, deletedNode.next);

        System.out.printf("\nKey=1 Exists %b",sll2.keyExists(1));
        System.out.printf("\nKey=2 Exists %b",sll2.keyExists(2));
        System.out.printf("\nKey=9 Exists %b",sll2.keyExists(9));
        System.out.printf("\nKey=12 Exists %b",sll2.keyExists(12));

        ListNode<Integer> reversedLL = sll2.reverseSinglyLinkedList();
        sll2.printNode(reversedLL);

        //sll2.print();
        ListNode<Integer> node = sll2.findMiddleNode();
        //sll2.print();
        System.out.printf("\nMiddle Node : %d -> %s",node.data, node.next);

        sll2.insertAtGivenPos(13,1);
        sll2.insertAtGivenPos(12,1);
        sll2.insertAtGivenPos(7,2);
        sll2.print();

        node = sll2.findMiddleNode();
        sll2.print();
        System.out.printf("\nMiddle Node : %d -> %s",node.data, node.next);

        node = sll2.findNthNodeFromEnd(2);
        sll2.print();
        System.out.printf("\n2nd Node From Last: %d -> %s",node.data, node.next);

        node = sll2.findNthNodeFromEnd(5);
        sll2.print();
        System.out.printf("\n2nd Node From Last: %d -> %s\n",node.data, node.next);

        /*node = sll2.findNthNodeFromEnd(7); //java.lang.IllegalArgumentException: 7 is greather than the number of nodes in the list
        sll2.print();
        System.out.printf("\n2nd Node From Last: %d -> %s",node.data, node.next);*/

        sll = new SinglyLinkedListExample_1();
        sll.insertAtStart(1);
        sll.insertAtStart(1);
        sll.insertAtEnd(2);
        sll.insertAtEnd(3);
        sll.insertAtEnd(3);
        sll.print();

        sll.removeDuplicateFromSortedList();
        sll.print();

        sll.insertInSortedList(5);
        sll.print();

        sll.insertInSortedList(4);
        sll.print();

        sll.removeFromSortedList(4);
        sll.print();

        sll.removeFromSortedList(5);
        sll.print();

        sll.removeFromSortedList(5);
        sll.print();

        Boolean isLoopDetected = sll.detectLoopInSinglyLinkedList();
        System.out.printf("\nLoop Detected: %b\n", isLoopDetected);

        SinglyLinkedListExample_1 sll_1 = new SinglyLinkedListExample_1();
        sll_1.insertAtStart(2);
        sll_1.insertAtStart(1);
        isLoopDetected = sll_1.detectLoopInSinglyLinkedList();
        System.out.printf("\n[1,2] Loop Detected: %b\n", isLoopDetected);


        SinglyLinkedListExample_1 singlyLinkedListWithLoop = createAndTestLoopInList();
        isLoopDetected = singlyLinkedListWithLoop.detectLoopInSinglyLinkedList();
        System.out.printf("\nLoop Detected: %b\n", isLoopDetected);

        ListNode<Integer> tmp = sll.findStartPointOfALoopInSinglyLinkedList();
        System.out.printf("\nLoop Detected Starting Node: %s\n", (tmp==null? null : (tmp.data + " ___ "+tmp.next)) );
        //SinglyLinkedListExample_1 singlyLinkedListWithLoop = createAndTestLoopInList();
        //singlyLinkedListWithLoop.print();
        
        tmp = singlyLinkedListWithLoop.findStartPointOfALoopInSinglyLinkedList();
        System.out.printf("\nLoop Detected Starting Node: %s\n", (tmp==null? null : (tmp.data + " ___ "+tmp.next)) );

        System.out.printf("\nRemoving Loop from Singly LinkedList\n");
        singlyLinkedListWithLoop.removeLoopFromSinglyList();
        singlyLinkedListWithLoop.print();


        //Test Merg of 2 sorted Singly LinkedList
        SinglyLinkedListExample_1 sortedListA = new SinglyLinkedListExample_1();
        sortedListA.insertAtStart(1);
        sortedListA.insertAtEnd(3);
        sortedListA.insertAtEnd(7);
        sortedListA.print();

        //Test Merge of 2 sorted Singly LinkedList
        SinglyLinkedListExample_1 sortedListB = new SinglyLinkedListExample_1();
        sortedListB.insertAtStart(1);
        sortedListB.insertAtEnd(2);
        sortedListB.insertAtEnd(4);
        sortedListB.print();

        SinglyLinkedListExample_1 meredSinglyList = new SinglyLinkedListExample_1();
        meredSinglyList.head = sortedListA.mergeTwoSortedSinglyLinkedList(sortedListA.head,sortedListB.head);
        meredSinglyList.print();

        sortedListA = new SinglyLinkedListExample_1();
        sortedListA.insertAtStart(2);
        sortedListA.insertAtEnd(4);
        sortedListA.insertAtEnd(3);
        sortedListA.print();

        //Test Merge of 2 sorted Singly LinkedList
        sortedListB = new SinglyLinkedListExample_1();
        sortedListB.insertAtStart(5);
        sortedListB.insertAtEnd(6);
        sortedListB.insertAtEnd(4);
        sortedListB.print();

        SinglyLinkedListExample_1 addSumSinglyList = new SinglyLinkedListExample_1();
        addSumSinglyList.head = sortedListA.addTwoSinglyListList(sortedListA.head,sortedListB.head);
        addSumSinglyList.print();

        sortedListA = new SinglyLinkedListExample_1();
        sortedListA.insertAtStart(9);
        sortedListA.insertAtEnd(9);
        sortedListA.insertAtEnd(9);
        sortedListA.insertAtEnd(9);
        sortedListA.insertAtEnd(9);
        sortedListA.insertAtEnd(9);
        sortedListA.insertAtEnd(9);
        sortedListA.print();

        //Test Merge of 2 sorted Singly LinkedList
        sortedListB = new SinglyLinkedListExample_1();
        sortedListB.insertAtStart(9);
        sortedListB.insertAtEnd(9);
        sortedListB.insertAtEnd(9);
        sortedListB.insertAtEnd(9);
        sortedListB.print();

        addSumSinglyList = new SinglyLinkedListExample_1();
        addSumSinglyList.head = sortedListA.addTwoSinglyListList(sortedListA.head,sortedListB.head);
        addSumSinglyList.print();

    }

    private static SinglyLinkedListExample_1 createAndTestLoopInList() {
        SinglyLinkedListExample_1 singlyLinkedListWithLoop = new SinglyLinkedListExample_1();
        ListNode<Integer> first = new ListNode<>(1);
        ListNode<Integer> second = new ListNode<>(2);
        ListNode<Integer> third = new ListNode<>(3);
        ListNode<Integer> forth = new ListNode<>(4);
        ListNode<Integer> fifth = new ListNode<>(5);
        ListNode<Integer> sixth = new ListNode<>(6);

        singlyLinkedListWithLoop.head = first;
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;
        
        return singlyLinkedListWithLoop;
    }

}
