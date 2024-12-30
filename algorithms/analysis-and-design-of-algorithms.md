# Analysis And Design Of Algorithms

## Topics Covered
* Analysis Approach
    * Algorithms Notation
    * Time And Space Complexity (Worst, Average, Best)
    * Resurrance Relation
        * Tree Method
        * Master Theorum
    * Searching, Sorting and Hashing (Analysis Aspects)
    * Graph Traversal
    * MST (Minimum Spending Tree)
    * Shortest Path Algorithm Analysis
* Design Approach
    * Dynamic Programing
    * Greedy Approach
    * Divide and Conquer

## What is an Algorithm?
* **Definition**: An algorithm is a finite sequence of precise instructions/steps that a computer/human can follow to solve a problem or complete a task. It's like a recipe or a set of directions that tells the computer/human to accomplish a task.

* **Purpose**
    * Algorithms are used in programming to automate tasks, make decisions, process data, and solve problems efficiently.
    * Its like map of a building before starting a construction or a medical treatment plan before starting any procedures.

* **Steps**
        
    * `Input`: Algorithms start with input, which is the data or information they will work with.
    * `Processing`: The algorithm processes the input data using various operations like calculations, comparisons, and logical decisions.
    * `Output`: Finally, the algorithm produces an output or result based on the processed input.

* **Example**: A simple algorithm could be a recipe for making a sandwich. The input is the ingredients (bread, cheese, ham, etc.), the processing involves steps like spreading the condiments and assembling the ingredients, and the output is the finished sandwich.

* **Characteristics**
        
    * `Finiteness`: Algorithms must have a finite number of steps.
    * `Definiteness`: Each step in the algorithm must be precisely defined and unambiguous.
    * `Input`: They take input from the user or from another program.
    * `Output`: They produce output or a result.
    * `Effectiveness`: Algorithms must be effective, meaning they should solve the problem correctly in a reasonable amount of time and resources. Its also referred to Time & Space Complexity and another term technically use to denoate this concept is `Big O` notation.

## Difference b/w Algorithm and Program
| Aspect          | Algorithm                                | Program                                    |
|-----------------|------------------------------------------|--------------------------------------------|
| **Definition**  | A set of step-by-step instructions       | A set of instructions executed by a computer|
| **When to do it**  | Design Phase       | Implementation Phase|
| **Nature**      | Abstract and conceptual                   | Concrete and executable                    |
| **Language Used to Write**      | Natural Language/Psuedo Code                   | Any programming Language(C/C++/Java)                    |
| **Purpose**     | Describes a solution or procedure        | Implements a solution or performs a task   |
| **Execution**   | Not directly executable by a computer (Analyze an Algorithm)     | Directly executable by a computer (Test the program)         |
| **Representation** | Typically represented using pseudocode or flowcharts | Represented using programming languages like Java, Python, etc. |
| **Input/Output** | Focuses on the logic and steps involved in solving a problem | Handles input data, processes it, and produces output |
| **Examples**    | Sorting algorithms, search algorithms, etc. | Word processors, web browsers, games, etc. |

## Aditional Resources
1. [Princeton University’s Algorithms 1](https://www.coursera.org/learn/algorithms-part1?utm_source=impact&utm_medium=partners&utm_campaign=3552395&irclickid=2i73%3A7XZwxyPWxLz1cxy101sUkHUM735LQA90I0&irgwc=1&utm_content=b2c)
2. [Princeton University’s Algorithms 2](https://www.coursera.org/learn/algorithms-part2)
3. [Princeton University’s Algorithms Website](https://algs4.cs.princeton.edu/11model/)
4. [Google’s Data Structures and Algorithms in Python](https://link.mail.beehiiv.com/ss/c/u001.BWGbrZeVBJAGKGn7g_gc-i5pLUGurvd7MLBr-6XBKSl-ufNSBn1Bhnpi6SGSLaeZoXGi5vMD0uCUh6yMwdqMfc3fMisi5bcyKgQ8WwFkSz0qrl-h5F7GhclF0g3gy2l5tX4yFXXttp05pE_S9Bzs2dfmCANdFeDquLK65BBQtPc/44t/q4YoVNRETEiyBXQwjlC9_g/h11/h001.Kzw4a3bN-X45lUqcs5rYF5bfyUbnD4dbEgGb1oPN0J4)
5. [IBM: Data Structures & Algorithms Using C++](https://link.mail.beehiiv.com/ss/c/u001.gPlIcflxxXMSkFQ2Agyp9o2xuSVJusGBrleli3Lm273lrrBaRf8zYDpvsgLjzMeXyOTDrX399qifv5HDjp4xMWVLqD7vaQY-LJjbAeiknBR6HZZe2AVMR7zTHa75sNfERykDQzXwW-nHsf9borz9JTxShOIQumy9hQ-WiHWy4Tw/44t/q4YoVNRETEiyBXQwjlC9_g/h10/h001.PDbMlYjpe0Q7HFcXageAEhJE7gVnaZb1WopiJFTymGQ)
6. [ntroduction to Algorithms - By Abdul Bari](https://www.youtube.com/watch?v=0IAPZzGSbME&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O)
7. [Design and Analysis of Algorithms(DAA) - By  Jenny's Lectures CS IT](https://www.youtube.com/watch?v=ovz54KoZo9o&list=PLdo5W4Nhv31ZTn2P9vF02bkb3SC8uiUUn&index=2)