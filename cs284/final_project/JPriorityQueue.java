/*
    Josh Gribbon
    CS284 - HW2
    I pledge my honor I have abided by the Stevens Honor System.
*/
/*From my hw2*/
public class JPriorityQueue{
    //declare variables
    private JNode highest;
    private JNode least;
    public int size;
    //methods
    public JPriorityQueue(){
        // Creates an empty list
        System.out.println("Created new JPriorityQueue");
        least = highest;
        size = 0;
    }
    public boolean insert(ErrorItem errMsg){
        System.out.println("Inserting " + errMsg);
        //System.out.println("Priority is: " + errMsg.priority());
        JNode temp = new JNode(errMsg);
        if(size<=0){
            highest = temp;
            least = temp;
            size = 1;
            System.out.println("First!");
            return true;
        }
        JNode current = highest;
        if(size == 1){
            System.out.println("Second!");
            if(temp.priority() > current.priority()){
                temp.next = current;
                current.prev = temp;
                highest = temp;
                System.out.println("New front!");
                return true;
            }
            temp.prev = current;
            current.next = temp;
            least = temp;
            size++;
            return true;
        }
        while(current.next != null){
            if( temp.priority() > current.priority()){//only > so newer things of the same priority go to the back of the same priority level
                if(current == highest){
                    temp.next = current;
                    current.prev = temp;
                    highest = temp;
                    size++;
                    System.out.println("New front!");
                    return true;
                }
                temp.next = current;
                temp.prev = current.prev;
                current.prev.next = temp;
                current.prev = temp;
                size++;
                System.out.println("Inside somewhere!");
                return true;
            }
            current = current.next;
        }
        //if it wasn't greater than anything in the list...
        assert (current.data == temp.data);//just to make sure we are actually at the end;
        temp.prev = current;
        current.next = temp;
        least = temp;
        size++;
        System.out.println("End!");
        return true;
        //currently a problem where things inserted at the end are flipped or something 12-3-15 1:42 am. Going to bed
    }
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
/*
    private boolean add (int i, double d){
        // Adds d at index i
        if(i<0 || i>(size())){
            return false;
        }
        JNode temp = new JNode(d);
        JNode current = highest;
        if(i==0){
            addFirst(d);
        }
        else if(i==size){
            addLast(d);
        }
        else{
            for(int j=0; j<i; j++){
                current = current.next;
            }
            temp.next = current;
            temp.prev = current.prev;
            current.prev.next = temp;
            current.prev = temp;
            size++; //addFirst and Last increment
        }

        return true;
    }
    private boolean addFirst (double d){
        // Adds d as the new highest
        if(size() == 0){
            highest = new JNode(d);
            least = highest;
        }
        else{
            JNode temp = new JNode(d);
            temp.next = highest;
            highest.prev = temp;
            highest = temp;
        }
        size++;
        return true;
    }
    private boolean addLast (double d){
        // Adds d as the new least
        if(size() == 0){
            highest = new JNode(d);
            least = highest;
        }
        else{
            JNode temp = new JNode(d);
            least.next = temp;
            temp.prev = least;
            least = temp;
        }
        size++;
        return true;
    }
    private double get (int i){
        // Returns the number stored at index i
        if(i<0 || i>(size()-1)){
            throw new IllegalArgumentException("Index out of range");
        }
        JNode current = highest;
        for(int j=0; j<i; j++){
            current = current.next;
        }
        return current.data;
    }
*/
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
        System.out.println("---");
        System.out.println("It runs!");
        System.out.println("---");
        //maybe use assertEquals(x, y); for testing?
    }
}
