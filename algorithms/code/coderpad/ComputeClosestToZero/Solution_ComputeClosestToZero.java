import java.util.*;
import java.io.*;
import java.math.*;

class Solution_ComputeClosestToZero {

    public static int computeClosestToZero(int[] ts) {
        // Write your code here
        // To debug: System.err.println("Debug messages...");
        
        if (ts==null || ts.length<=0) return 0;
        //else if (ts.length==1) return ts[0];
        //else if (ts.length==2) return ts[0]>=ts[1] ? ts[0] : ts[1];
        int tempCloseToZero = ts[0];
        for (int i=1; i< ts.length; i++) {
            if (Math.abs(tempCloseToZero) > Math.abs(ts[i])) {
                tempCloseToZero = ts[i];
            }
            else if (Math.abs(tempCloseToZero) == Math.abs(ts[i])) { //switch same -ve & +Ve #s
                tempCloseToZero = tempCloseToZero > ts[i] ? tempCloseToZero : ts[i];
            }
        }
        return tempCloseToZero;
    }

    /* Ignore and do not change the code below */
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ts = new int[n];
        for (int i = 0; i < n; i++) {
            ts[i] = in.nextInt();
        }
        PrintStream outStream = System.out;
        System.setOut(System.err);
        int solution = computeClosestToZero(ts);
        System.setOut(outStream);
        System.out.println(solution);
    }
    /* Ignore and do not change the code above */
}