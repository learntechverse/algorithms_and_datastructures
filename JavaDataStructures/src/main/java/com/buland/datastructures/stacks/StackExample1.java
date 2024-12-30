package com.buland.datastructures.stacks;

import java.util.Stack;

public class StackExample1 {

    public static void main(String[] args) {
        Stack<String> fruits = new Stack<String>();
        fruits.push("Apples");
        fruits.push("Oranges");
        fruits.push("Kiwis");

        System.out.println("All Fruits: "+fruits); //shows in same order as created which is not how Stack behaves so confusing
        System.out.println("Last Fruit Added: "+fruits.peek());
        System.out.println("Last Fruit Added: "+fruits.pop());
        System.out.println("All Fruits: "+fruits); //shows in same order as created which is not how Stack behaves so confusing
    }
}
