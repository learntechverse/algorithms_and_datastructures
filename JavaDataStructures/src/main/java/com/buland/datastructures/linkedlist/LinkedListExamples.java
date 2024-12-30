package com.buland.datastructures.linkedlist;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExamples {

    public static void main(String[] args) {
        //Java has doubly linked list
        LinkedList<String> shoppingList = new LinkedList<>();
        shoppingList.add("Apples");
        shoppingList.add("Bananas");
        shoppingList.add("Cherries");

        System.out.println("ShoppingList: "+shoppingList); //keepos the order and start with 0

        shoppingList.add(0, "Mangoes");
        System.out.println("ShoppingList: "+shoppingList); //keepos the order and start with 0

        shoppingList.removeFirst();
        System.out.println("ShoppingList: "+shoppingList); //keepos the order and start with 0

        //LinkedList are not syncrhonized so better in performnace but not ideal for multi threaded app
        List<String> syncrhonizedSHoppingList = Collections.synchronizedList(shoppingList);
        System.out.println("Syncrhonized ShoppingList: "+syncrhonizedSHoppingList); //thread safe
    }
}
