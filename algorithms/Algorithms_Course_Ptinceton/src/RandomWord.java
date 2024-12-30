import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {

    public static void main(String[] args) {

        int i = 0;
        do {
            i++;
            String str = StdIn.readString(); //reads and returns the next string from standard input.
            if (StdRandom.bernoulli((double) 1 / i)) {
                StdOut.println(str);
            }
        } while ( !StdIn.isEmpty() );
/*
        for (int i = 1; i < 5; i++) {
            StdOut.println(StdRandom.bernoulli((double) 1 / i));
        }
 */
    }
}
