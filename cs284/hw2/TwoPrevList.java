/*
    Assignment. Implement a linked list in which a node is linked to its next node as well as to the two previous nodes. Your code must implement the following UML diagrams.
        •Your class must be named TwoPrevList.
        •TwoPrevList should contain the private inner class shown in the second UML diagram.
        •All methods should follow the specifications below.
    Hints
        •Inserting a node to the beginning or end of the list using the add(int index, double data) method should be allowed.
        •Make sure that all special cases, e.g. an empty list, are handled.
    Submit a single file named TwoPrevList.java. No report is required. Your grade will be determinedas follows:
        •You will get 0 if your code does not compile.
        •The code must implement the following UML diagram precisely. ( You can add data members and methods as needed.) It will be tested using a driver.
        •The code must include tests for all methods implemented.
        •We will NOT try to feed erroneous and inconsistent inputs to your methods this time.
*/
public class TwoPrevList{
    //declare variables
    public TPNode head;
    public TPNode tail;
    public int size;
    //methods
    public TwoPrevList (){
        // Creates an empty list
        TPNode temp = new TPNode();
        head = temp;
        tail = temp;
        size = 0;
    }
    public boolean add (int i, double d){
        // Adds d at index i
        TPNode temp = new TPNode(d);
        TPNode current = head;
        for(int j=1; j<i && current.next != null; j++){
            current = current.next;
        }
        temp.next = current;
        temp.prev = current.prev;
        current.prev.next = temp;
        current.prev = temp;

        size++;
        return true;
    }
    public boolean addFirst (double d){
        // Adds d as the new head
        TPNode temp = new TPNode(d);
        temp.next = head;
        head.prev = temp;
        head = temp;
        size++;
        return true;
    }
    public boolean addLast (double d){
        // Adds d as the new tail
        TPNode temp = new TPNode(d);
        tail.next = temp;
        temp.prev = tail;
        tail = temp;
        size++;
        return true;
    }
    public double get (int i){
        // Returns the number stored at index i
        double resp;
        //if(i <= 0){
        //    resp = null;
        //}
        TPNode current = head.next; // because first is null
        for(int j=1; j<i; j++){
        //    if(current.next == null){
        //        resp = null;
        //    }
            current = current.next;
        }
        resp =  current.data;
        return resp;
    }
    public TPNode getNode(int i){
        //return the node stored at index i
        TPNode current = head.next; // because first is null
        for(int j=1; j<i; j++){
            current = current.next;
        }
        return current;
    }
    public int size(){
        // Returns the list size
        return size;
    }
    public double removeFirst (){
        // Removes and returns the data at the head
        TPNode temp = head;
        head = head.next;
        head.prev = null;
        size--;
        return temp.data;
    }
    public double removeLast (){
        // Removes and returns the data at the tail
        TPNode temp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        return temp.data;
    }
    public double remove (int i){
        // Removes and returns the element at index i
        //if(i<1 || i>size()){
        //    return null;
        //}
        TPNode current = head;
        for(int j=1; j<i; j++){
        //    if(current.next == null){
        //        return null;
        //    }
            current = current.next;
        }
        double dat = current.next.data;
        current.next = current.next.next;
        size--;
        return dat; // DOESNT RETURN THE RIGHT THING
    }
    public int find (double d){
        // Returns the index of the firstinstance of d, or -1 if d is not in the list
        int resp;
        if(i <= 0){
            resp = -1;
        }
        TPNode current = head.next; // because first is null
        for(int j-1; j<i; j++){
            if(current.next == null){
                resp = null;
            }
            current = current.next;
        }
        resp = current.data;
        return resp;
    }
    public double average(int i){
        // Returns the average of the number at index iand the previous two numbers on the list. If only one or no previous numberexists, returns the average of the available data
        return 0.0;
    }
    public String toString(){
        // returns a String with all the elements in the list separated by commas
        TPNode current = head.next;
        String out = "[";
        while(current != null){
            if(current == head){
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
    //
    public class TPNode{
        //declare variables
        protected double data;
        protected TPNode next;
        protected TPNode prev;
        protected TPNode prev2;
        //methods
        public TPNode (){
            //for the first node
        //    data = null;
            next = null;
            prev = null;
            prev2 = null;
        }
        public TPNode (double d){
            // Creates a node holding d
            data = d;
            next = null;
            prev = null;
            prev2 = null;
        }
        public TPNode(double d, TPNode n,TPNode pr, TPNode pr2){
            //Creates a node holding d, with n as next, pr as prev and pr2 as prev2
            data = d;
            next = n;
            prev = pr;
            prev2 = prev.prev;
        }
        //getters and setters
        /*
        public double getData(){
            return data;
        }
        public void setData(double d){
            data = d;
        }
        public TPNode getNext(){
            return next;
        }
        public void setNext(TPNode nextVal){
            next = nextVal;
        }
        public TPNode getPrev(){
            return prev;
        }
        public void setPrev(TPNode prevVal){
            prev = prevVal;
        }
        public TPNode getPrev2(){
            return prev2;
            //return getPrev().getPrev()
        }
        public void setPrev2(TPNode prev2Val){
            prev2 = prev2Val;
        }
        */
    }
}
