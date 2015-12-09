/**A priority queue of ErrorItems
 * CS284 - Data Structures
 * Final Project
 * I pledge my honor I have abided by the Stevens Honor System.
 *
 * @author Josh Gribbon
 *
 * Sources used: Linked list from HW2
 */

/*Notes

Use the second JNode constructor, might fix problems with inserting the first few

*/
import java.util.Random;
public class JPriorityQueue{
    /**The highest priority item in the queue*/
    private JNode highest;
    /**The lowest priority item in the queue*/
    private JNode least;
    /**The sizo of the queue*/
    public int size;
    /**If I am debugging or not - toggles some printouts*/
    private boolean debug = false;

    /**Constructor*/
    public JPriorityQueue(){
        // Creates an empty list
        if(debug){System.out.println("Created new JPriorityQueue");}
        least = highest;
        size = 0;
    }

    /**Method to insert an ErrorItem
     * @param errMsg        The ErrorItem to insert
     */
    public boolean insert(ErrorItem errMsg){
        if(debug){System.out.println("Inserting " + errMsg);}
        //System.out.println("Priority is: " + errMsg.priority());
        JNode temp = new JNode(errMsg);
        if(size<=0){
            return insert_first_node(temp);
        }
        JNode current = highest;
        while(current.next != null){
            if( temp.priority() > current.priority()){//<= so newer things of the same priority go to the back of the same priority level
                if(debug){System.out.println(Integer.toString(temp.priority()) + " > " + Integer.toString(current.priority()));}//this is an ugly line.
                if(current == highest){
                    return insert_front(temp);
                }
                temp.next = current;
                temp.prev = current.prev;
                current.prev.next = temp;
                current.prev = temp;
                size++;
                if(debug){System.out.println("Inside somewhere!");}
                return true;
            }
            //System.out.println("On to the next one");
            current = current.next;
        }
        //if it wasn't greater than anything in the list...
        assert (current == least);//just to make sure we are actually at the end;
        return insert_back(temp);
        //currently a problem where things inserted at the end are flipped or something 12-3-15 1:42 am. Going to bed
    }

    /**Method to insert the first JNode in the queue
     * @param n         The JNode to insert, as the first node in the list
     * @return          Boolean if the insertion was successful
     */
    private boolean insert_first_node(JNode n){
        highest = n;
        least = n;
        size = 1;
        if(debug){System.out.println("First!");}
        return true;
    }

    /**Method to insert a JNode in the front of the queue
     * @param n         The JNode to insert to the front of the queue
     * @return          Boolean if the insertion was successful
     */
    private boolean insert_front(JNode n){
        n.next = highest;
        highest.prev = n;
        highest = n;
        size++;
        if(debug){System.out.println("New front!");}
        return true;
    }

    /**Method to insert a JNode in the back of the queue
     * @param n         The JNode to insert to the back of the queue
     * @return          Boolean if the insertion was successful
     */
    private boolean insert_back(JNode n){
        n.prev = least;
        least.next = n;
        least = n;
        size++;
        if(debug){System.out.println("End!");}
        return true;
    }

    /**Method to remove a JNode from the queue
     * @return          The JNode with the highest priority in the queue, or null if the queue is empty
     */
    public JNode remove(){
        if(size == 0)
            return null;
        JNode resp = highest;
        JNode newHigh;
        newHigh = highest.next;
        newHigh.prev = null;
        highest = newHigh;
        size--;
        return resp;
    }

    /**Size getter
     * @return          The size of the queue
     */
    public int size(){
        return size;
    }

    /**Override of toString() method
     * @return      String in the form of "[ErrItem, ErrItem, ErrItem]"
     */
    public String toString(){
        // returns a String with all the elements in the list separated by commas
        JNode current = highest;
        String out = "[";
        while(current != null){
            if(current == highest){
                out += current.data;
            }
            else{
                out += ", " + current.data;
            }
            current = current.next;
        }
        out += "]";
        return out;
    }

    /**Main method - used fro testing*/
    public static void main(String[] args) {
        //make some randompriority level errors, put them in the PQ, take them out and print
        Random rand = new Random();
        //int  n = rand.nextInt(5) + 1;
        JPriorityQueue myQ = new JPriorityQueue();
        for(int i=0; i<20; i++){
            String num = Integer.toString(i);
            if(i < 10){
                num = "0" + num;
            }
            ErrorItem errItem = new ErrorItem(
                "test" + num,
                "host" + num,
                "problem" + num,
                Integer.toString(rand.nextInt(5) + 1));
            myQ.insert(errItem);
        }
        while(myQ.size > 1){
            System.out.println(myQ.remove().data());
        }
        //maybe use assertEquals(x, y); for testing?
    }
}
