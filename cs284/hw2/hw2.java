/*
    Josh Gribbon
    CS284 - HW2
    I pledge my honor I have abided by the Stevens Honor System.
*/
public class hw2{
    public static void main(String[] args) {
        /*TESTS TO MAKE           COUNT
            Make a new list       0
            addFirst()            1
            addFirst()            2
            addFirst()            3
            addFirst()            4
            addFirst()            5
            addFirst()            6
            addFirst()            7
            addLast()             8
            add(-1) - false
            add(0)                9
            add(3)                10
            add(12) - false
            get(-1) - error
            get(0)
            get(2)
            get(3)
            get(14) - error
            removeFirst()         9
            removeLast()          8
            remove(-1) - error
            remove(0)             7
            remove(2)             6
            remove(5)             5
            remove(5) - error
            find(existing)
            find(non-existing)
            average(-1) - error
            average(0)
            average(1)
            average(4)
            average(8) - error
            toString() - between every step

        */
        System.out.println("---");

        TwoPrevList myL = new TwoPrevList();
        //Add toString and size between each step
        System.out.println(myL.size() + "  -  " + myL.toString());
        System.out.println(myL.addFirst(1));
        System.out.println(myL.size() + "  -  " + myL.toString());
        System.out.println(myL.addFirst(2));
        System.out.println(myL.size() + "  -  " + myL.toString());
        System.out.println(myL.addFirst(3));
        System.out.println(myL.size() + "  -  " + myL.toString());
        System.out.println(myL.addFirst(4));
        System.out.println(myL.size() + "  -  " + myL.toString());
        System.out.println(myL.addFirst(5));
        System.out.println(myL.size() + "  -  " + myL.toString());
        System.out.println(myL.addFirst(6));
        System.out.println(myL.size() + "  -  " + myL.toString());
        System.out.println(myL.addFirst(7));
        System.out.println(myL.size() + "  -  " + myL.toString());

        System.out.println("---");
    }
}
/* TERMINAL OUTPUT
---

---
*/
