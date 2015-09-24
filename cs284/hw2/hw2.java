/*
Josh Gribbon
CS284 - HW1
I pledge my honor I have abided by the Stevens Honor System.

Note: I didn't need to check for a negative degree or anything like that because it's determined by the length of the array. Any values in the array or fine(assuming they're real numbers).
*/

/*
Assignment. Implement a linked list in which a node is linked to its next node as well as to the two previous nodes. Your code must implement the following UML diagrams.
    •Your class must be named TwoPrevList.
    •TwoPrevList should contain the private inner class shown in the second UML diagram.
    •All methods should follow the specifications below.

Hints
    •Inserting a node to the beginning or end of the list using the add(int index, Double data) method should be allowed.
    •Make sure that all special cases, e.g. an empty list, are handled.

Submit a single file named TwoPrevList.java. No report is required. Your grade will be determinedas follows:
    •You will get 0 if your code does not compile.
    •The code must implement the following UML diagram precisely. ( You can add data members and methods as needed.) It will be tested using a driver.
    •The code must include tests for all methods implemented.
    •We will NOT try to feed erroneous and inconsistent inputs to your methods this time.
*/
public class hw2{
    public static void main(String[] args) {
        System.out.println("---");

        TwoPrevList myL = new TwoPrevList();
        myL.addFirst(10.0);
        myL.addLast(15.8);
        myL.addLast(25);
        myL.addLast(25);
        myL.addLast(25);
        myL.addFirst(10.0);
        myL.addFirst(10.0);
        System.out.println(myL.get(4));
        System.out.println("Size: " + myL.size());
        System.out.println(myL.toString());
        TwoPrevList.TPNode myN = myL.getNode(4);
        System.out.println(myN.data);
        System.out.println(myN.next.data);
        System.out.println(myN.prev.data);
        //System.out.println(myN.prev2.data);
        System.out.println(myL.removeFirst());
        System.out.println(myL.removeLast());
        System.out.println("Size: " + myL.size());
        System.out.println(myL.toString());

        System.out.println("---");
    }
}
/* TERMINAL OUTPUT
---

---
*/
