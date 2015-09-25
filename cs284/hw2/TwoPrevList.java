/*
        •The code must include tests for all methods implemented.
*/
/*
    Josh Gribbon
    CS284 - HW2
    I pledge my honor I have abided by the Stevens Honor System.
*/
public class TwoPrevList{
    //declare variables
    public TPNode head;
    public TPNode tail;
    public int size;
    //methods
    public TwoPrevList (){
        // Creates an empty list
        tail = head;
        size = 0;
    }
    public boolean add (int i, double d){
        // Adds d at index i
        if(i<0 || i>(size())){
            return false;
        }
        TPNode temp = new TPNode(d);
        TPNode current = head;
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
    public boolean addFirst (double d){
        // Adds d as the new head
        if(size() == 0){
            head = new TPNode(d);
            tail = head;
        }
        else{
            TPNode temp = new TPNode(d);
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        size++;
        return true;
    }
    public boolean addLast (double d){
        // Adds d as the new tail
        if(size() == 0){
            head = new TPNode(d);
            tail = head;
        }
        else{
            TPNode temp = new TPNode(d);
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        size++;
        return true;
    }
    public double get (int i){
        // Returns the number stored at index i
        if(i<0 || i>(size()-1)){
            throw new IllegalArgumentException("Index out of range");
        }
        TPNode current = head;
        for(int j=0; j<i; j++){
            current = current.next;
        }
        return current.data;
    }
    public int size(){
        // Returns the list size
        return size;
    }
    public double removeFirst (){
        // Removes and returns the data at the head
        if(size() == 0)){
            throw new IllegalArgumentException("Index out of range");
        }
        TPNode temp = head;
        head = head.next;
        head.prev = null;
        size--;
        return temp.data;
    }
    public double removeLast (){
        // Removes and returns the data at the tail
        if(size() == 0)){
            throw new IllegalArgumentException("Index out of range");
        }
        TPNode temp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        return temp.data;
    }
    public double remove (int i){
        // Removes and returns the element at index i
        if(i<0 || i>(size()-1 || size()==0)){
            throw new IllegalArgumentException("Index out of range");
        }
        double dat;
        if(i==0){
            dat = head.data;
            removeFirst();
        }
        else if(i==(size()-1)){
            dat = tail.data;
            removeLast();
        }
        else{
            TPNode current = head;
            for(int j=0; j<i; j++){
                current = current.next;
            }
            dat = current.data;
            current.prev.next = current.next;
            size--;
        }
        return dat; // DOESNT RETURN THE RIGHT THING
    }
    public int find (double d){
        // Returns the index of the first instance of d, or -1 if d is not in the list
        int resp = -1;
        TPNode current = head;
        for(int i=0; i<(size-1); i++){
            if(current.data == d){
                return i; //return here so it catches the first instance
            }
            current = current.next;
        }
        return resp;
    }
    public double average(int i){
        // Returns the average of the number at index i and the previous two numbers on the list. If only one or no previous numbers exists, returns the average of the available data
        double curr;
        double prev;
        double prev2;
        double resp;
        if(i<0 || i>(size()-1 || size()==0)){
            throw new IllegalArgumentException("Index out of range");
        }
        if(i==0){
            resp = get(i);
        }
        else if(i==1){
            curr = get(i);
            prev = get(i-1);
            resp = ((curr + prev)/2);
        }
        else{
            curr = get(i);
            prev = get(i-1);
            prev2 = get(i-2);
            resp = ((curr + prev + prev2)/3);
        }
        return resp;
    }
    public String toString(){
        // returns a String with all the elements in the list separated by commas
        TPNode current = head;
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
    //LOOK UP GENERICS
    private class TPNode{
        //declare variables
        private double data;
        private TPNode next;
        private TPNode prev;
        private TPNode prev2;
        //methods
        private TPNode (double d){
            // Creates a node holding d
            data = d;
            next = null;
            prev = null;
            prev2 = null;
        }
        private TPNode(double d, TPNode n,TPNode pr, TPNode pr2){
            //Creates a node holding d, with n as next, pr as prev and pr2 as prev2
            data = d;
            next = n;
            prev = pr;
            prev2 = prev.prev;
        }
    }
}
