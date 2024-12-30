package com.buland.datastructures.arrays;

import java.util.Arrays;

public class SimpleArrayUsage {

    public static void main(String[] args) {

        //Instantiate an Array with a fixed size
        String weekdays[] = new String[7]; //fixed length that cannot be increaaed later
        System.out.println(weekdays); //prints hashcode

        System.out.println(Arrays.toString(weekdays)); //prints whole array

        weekdays[0] = "Monday";
        System.out.println(Arrays.toString(weekdays)); //prints whole array

        weekdays = new String[]{"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        System.out.println(Arrays.toString(weekdays)); //prints whole array

        for (String day : weekdays) {
            System.out.println("Weekday: "+day);
        }

        System.out.println("----------------------");
        for (int i=0; i<weekdays.length; i++) {
            System.out.println("Weekday: "+weekdays[i]);
        }

        //Declare & Initialize
        String[] weekdays1 = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        System.out.println(Arrays.toString(weekdays1)); //prints whole array


    }
}
