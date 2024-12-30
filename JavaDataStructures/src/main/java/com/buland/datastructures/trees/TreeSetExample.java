package com.buland.datastructures.trees;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * One of the key features of the tree set is that it stores elements by defaults in ascending order.
 * So if a number it would store them going up with the smallest first and the largest at the end.
 *
 * Another feature of tree sets is that you can't store duplicate values. Even if we try to add, it will not add duplicates
 */
public class TreeSetExample {

    public static void main(String[] args) {
        treeSetOfInts();
        treeSetOfStringsAsNums();
        treeSetOfStringsAsStrings();
        treeSetOfStringsAsStringUsingComparator();
        createSortedTreeSet("Apples", "Oranges", "Pineapples");//Print "Set: [Apples, Oranges, Pineapples]"
        createSortedTreeSet("Bananas", "Oranges", "Pineapples");//Print "Set: [Bananas, Pineapples]" //because Oranges and bananas are of same length
    }

    private static void treeSetOfInts() {
        System.out.println("\n************************* Testing TreeSet of Integers ......");
        Set<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(1);
        treeSet.add(300);
        treeSet.add(47);
        treeSet.add(6);
        System.out.printf("\nTreeSet: %s\n",treeSet); //did not show in the order I out but it in ascending order from lowest to highest

        treeSet.add(47);//ignore duplicates
        treeSet.add(1);//ignore duplicates
        System.out.printf("\nTreeSet: %s\n",treeSet); //did not show in the order I out but it in ascending order from lowest to highest
    }

    private static void treeSetOfStringsAsNums() {
        System.out.println("\n************************* Testing TreeSet of Strings as Ints ......");
        Set<String> treeSet = new TreeSet<String>();
        treeSet.add("1");
        treeSet.add("300");
        treeSet.add("47");
        treeSet.add("6");
        System.out.printf("\nTreeSet: %s\n",treeSet); //did not show in the order I out but it in ascending order from lowest to highest

        treeSet.add("47");//ignore duplicates
        treeSet.add("1");//ignore duplicates
        System.out.printf("\nTreeSet: %s\n",treeSet); //did not show in the order I out but it in ascending order from lowest to highest
    }

    private static void treeSetOfStringsAsStrings() {
        System.out.println("\n************************* Testing TreeSet of Strings as Strings ......");
        Set<String> animalSet = new TreeSet<String>();
        animalSet.add("Tiger");
        animalSet.add("Giraffe");
        animalSet.add("Bear");
        animalSet.add("Alligator");
        System.out.printf("\nAnimalSet: %s\n",animalSet); //did not show in the order I out but it in ascending order from lowest to highest

        animalSet.add("Alligator");//ignore duplicates
        System.out.printf("\nAnimalSet: %s\n",animalSet); //did not show in the order I out but it in ascending order from lowest to highest
    }

    /**
     * sort using added string length. In this case even if we add for example two strings of same length, as its using length as a
     * duplicate measure so will ignore other strings of same length
     */
    private static void treeSetOfStringsAsStringUsingComparator() {
        System.out.println("\n************************* Testing TreeSet of Strings as Strings Using Comparator ......");
        Set<String> animalSet = new TreeSet<String>(Comparator.comparing((String::length)));
        animalSet.add("Tiger");
        animalSet.add("Giraffe");
        animalSet.add("Bear");
        animalSet.add("Alligator");
        System.out.printf("\nAnimalSet: %s\n",animalSet); //did not show in the order I out but it in ascending order from lowest to highest

        animalSet.add("Wolf");//ignore duplicates as its of same size as Bear and because we are using length as a duplicate measure
        System.out.printf("\nAnimalSet: %s\n",animalSet); //did not show in the order I out but it in ascending order from lowest to highest

        animalSet.remove("Bear");
        System.out.printf("\nAnimalSet: %s\n",animalSet); //did not show in the order I out but it in ascending order from lowest to highest

        animalSet.add("Wolf");
        System.out.printf("\nAnimalSet: %s\n",animalSet); //did not show in the order I out but it in ascending order from lowest to highest
    }

    /**
     * The first step is to initialize a TreeSet<String> which will sort the contents by length.
     * To do this, a Comparator can be passed in to the constructor of the TreeSet.
     * To sort by the length of the String, we can call the comparing method and pass in a method reference as an argument:
     *
     * @param word1
     * @param word2
     * @param word3
     * @return
     */
    static TreeSet<String> createSortedTreeSet(String word1, String word2, String word3) {
        System.out.println("\n************************* Testing createSortedTreeSet ......");
        TreeSet<String> set = new TreeSet<>(Comparator.comparing(String::length));
        set.addAll(Arrays.asList(word1, word2, word3));
        /*set.add(word1);
        set.add(word2);
        set.add(word3);*/
        System.out.printf("\nSet: %s\n",set); //did not show in the order I out but it in ascending order from lowest to highest
        return set;
    }
}
