/*
    Josh Gribbon
    CS284 - HW2
    I pledge my honor I have abided by the Stevens Honor System.
*/
/*From my hw2*/
import java.util.Random;
public class JPriorityQueue{
    //declare variables
    private JNode highest;
    private JNode least;
    public int size;
    private boolean debug = false;
    //methods
    public JPriorityQueue(){
        // Creates an empty list
        if(debug){System.out.println("Created new JPriorityQueue");}
        least = highest;
        size = 0;
    }
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
    private boolean insert_first_node(JNode n){
        highest = n;
        least = n;
        size = 1;
        if(debug){System.out.println("First!");}
        return true;
    }
    private boolean insert_front(JNode n){
        n.next = highest;
        highest.prev = n;
        highest = n;
        size++;
        if(debug){System.out.println("New front!");}
        return true;
    }
    private boolean insert_back(JNode n){
        n.prev = least;
        least.next = n;
        least = n;
        size++;
        if(debug){System.out.println("End!");}
        return true;
    }
    public JNode remove(){
        //Only remove the highest, which should be the front of the queue. I'm really doing this more as a stack but whatever...
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
    public int size(){
        // Returns the list size
        return size;
    }
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

    public class JNode{
        //declare variables
        private ErrorItem data;
        private int priority;
        private JNode next;
        private JNode prev;
        //methods
        private JNode (ErrorItem errMsg){
            // Creates a node holding d
            data = errMsg;
            next = null;
            prev = null;
            priority = errMsg.priority();
        }
        private JNode(ErrorItem errMsg, JNode n,JNode pr){
            //Creates a node holding d, with n as next, pr as prev and pr2 as prev2
            data = errMsg;
            next = n;
            prev = pr;
        }
        public ErrorItem data(){
            return this.data;
        }
        public int priority(){
            return this.priority;
        }
    }

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
