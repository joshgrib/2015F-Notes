/**A hash table to store problems that have been handled
 * CS284 - Data Structures
 * Final Project
 * I pledge my honor I have abided by the Stevens Honor System.
 *
 * @author Josh Gribbon
 *
 * Sources used: Textbook implementation of a Hash Table, pg 384
 */
public class JHashTable{
    /**Constructor*/
    public JHashTable(){
        if(debug){System.out.println("Created new JPriorityQueue");}
        least = highest;
        size = 0;
    }
    /**Override of toString() method
     * @return      String "JHashTable"
     */
    public String toString(){
        System.out.println("JHashTable");
    }
    /**Main method - used for testing*/
    public static void main(String[] args) {
        System.out.println("Hello world\n~Hash Table");
    }
}
