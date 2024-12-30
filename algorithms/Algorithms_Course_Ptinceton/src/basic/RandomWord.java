package basic;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {

    public static void main(String[] args) {


        do {
            String str = StdIn.readString(); //reads and returns the next string from standard input.
            StdOut.println(str);
            for (int i = 1; i < 5; i++) {
                StdOut.println(StdRandom.bernoulli((double) 1 / i));
            }
        } while ( !StdIn.isEmpty() );


    }
}
