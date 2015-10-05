//package week5;

public class MyLinkedList
{
    /**
     * Node class needed to create a linked list
     */
    private class MyLNode
    {
        public Double data;
        public MyLNode next;

        /**
         * Creates a linked node with reference next
         * as null and data d if d not null
         * @param  d The value of the double in the node
         */
        public MyLNode(Double d)
        {
            if (d != null)
            {
                data = d;
                next = null;
            }
        }

        /**
         * Creates a doubly linked node with references n and Double d
         * @param  d The Double value in the node
         * @param  n Reference to the next node
         */
        public MyLNode(Double d, MyLNode n)
        {
            if (d != null)
            {
                data = d;
                next = n;
            }
        }
    }

    private MyLNode head;
    private MyLNode tail;
    private int size;

    /**
     * Creates an empty list with size 0.
     */
    public MyLinkedList()
    {
        size = 0;
    }

    /**
     * Adds Double d at position i counting from the head
     * @param  i Index counting from the head
     * @param  d Double to add
     * @return   true if Double succesfully added, false otherwise
     */
    public boolean add(int i, Double d)
    {
        // TODO
        if(i<0 || i>(size-1)){
            throw new IllegalArgumentException("Index out of range");
        }
        MyLNode temp = new MyLNode(d);
        MyLNode current = head;
        for (int j = 1; j < i && current.next != null; j++) {
            current = current.next;
        }
        temp.next = current.next;
        current.next = temp;
        size++;
        return true;
    }

    /**
     * Adds a Double to the front of the list
     * @param  d Double to add
     * @return   true if the Double has been successfully added, false otherwise
     */
    public boolean addFirst(Double d)
    {
        // TODO
        MyLNode temp = new MyLNode(d);
        MyLNode current = head;
        temp.next = current;
        head = temp;
        size++;
        return true;
    }

    /**
     * Adds a Double to the end of the list.
     * @param  d Double to add
     * @return   true if the Double has been successfully added, false otherwise
     */
    public boolean addLast(Double d)
    {
        // TODO
        if(size == 0){
            addFirst(d);
            return true;
        }
        MyLNode temp = new MyLNode(d);
        MyLNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = temp;
        tail = temp;
        size++;
        return true;
    }

    /**
     * Returns the Double stored at index i
     * @param  i the index of the Double
     * @return The value of the Double at index i or null if not found
     */
    public Double get(int i)
    {
        // TODO
        if(i<0 || i>(size-1)){
            throw new IllegalArgumentException("Index out of range");
        }
        MyLNode current = head;
        for(int j=0; j<i; j++){
            current = current.next;
        }
        return current.data;
    }

    /**
     * Returns the size of the list
     * @return The size of the list
     */
    public int size()
    {
        return size;
    }

    /**
     * Removes and returns the element at index i counting from the head
     * @param  i The index of the object to be removed counting from the head
     * @return   The Double at index i or null if not found
     */
    public Double remove(int i)
    {
        Double ret = null;
        if (size < 0 || i < 0 || i > size - 1)
        {
            return null;
        }

        if (i == 0 || size == 1)
        {
            ret = head.data;
            if((head = head.next) == null)
            {
                tail = head;
            }
        }
        else
        {
            MyLNode curr;
            for (curr = head; curr.next != tail && i > 1; i--)
            {
                curr = curr.next;
            }
            ret = curr.next.data;
            if((curr.next = curr.next.next) == null)
            {
                tail = curr;
            }
        }
        size--;
        return ret;
    }

    /**
     * Removes and returns the element at the head of the list
     * @return The element at the head of the list or null if no objects in list
     */
    public Double removeFirst()
    {
        return remove(0);
    }

    /**
     * Removes and returns the element at the tail of the list
     * @return The element at the head of the list or null if no objects in list
     */
    public Double removeLast()
    {
        return remove(size - 1);
    }

    /**
     * Prints the elements in the list starting from the head
     * @return A string with the elements of the list separated by spaces
     */
    public String toString()
    {
        MyLNode curr = head;
        String ret = "";

        if (size <= 0)
        {
            return "This list is empty.\n";
        }
        while (curr != null)
        {
            ret += curr.data.toString() + " ";
            curr = curr.next;
        }
        return ret;
    }

    public static void main(String[] args)
    {
        MyLinkedList l = new MyLinkedList();
        l.addFirst(10.5);
        l.addFirst(11.5);
        l.addFirst(12.5);
        l.addFirst(13.9);
        l.addFirst(118.6);
        l.addFirst(15.3);

        System.out.println("--------------TESTING addFirst--------------");
        System.out.println("Given   : " + l);
        System.out.println("Expected: 15.3 118.6 13.9 12.5 11.5 10.5");

        System.out.println("--------------TESTING add--------------");
        l.add(1, 19.6);
        l.add(4, 28.3);
        System.out.println("Given   : " + l);
        System.out.println("Expected: 15.3 19.6 118.6 13.9 28.3 12.5 11.5 10.5");

        System.out.println("--------------TESTING removeFirst--------------");
        l.removeFirst();
        l.removeFirst();
        System.out.println("Given   : " + l);
        System.out.println("Expected: 118.6 13.9 28.3 12.5 11.5 10.5");

        System.out.println("--------------TESTING remove--------------");
        l.remove(2);
        l.remove(3);
        l.remove(1);
        System.out.println("Given   : " + l);
        System.out.println("Expected: 118.6 12.5 10.5");

        System.out.println("--------------TESTING get--------------");
        System.out.println("Given   : The Double at index 1 is " + l.get(1));
        System.out.println("Expected: The Double at index 1 is 12.5");

        System.out.println("--------------TESTING size--------------");
        System.out.println("Given   : The size of l is " + l.size());
        System.out.println("Expected: The size of l is 3");

        MyLinkedList m = new MyLinkedList();
        m.addLast(10.5);
        m.addLast(11.5);
        m.addLast(12.5);
        m.addLast(13.9);
        m.addLast(118.6);
        m.addLast(15.3);

        System.out.println("--------------TESTING addLast--------------");
        System.out.println("Given   : " + m);
        System.out.println("Expected: 10.5 11.5 12.5 13.9 118.6 15.3");

        System.out.println("--------------TESTING removeLast--------------");
        m.removeLast();
        m.removeLast();
        System.out.println("Given   : " + m);
        System.out.println("Expected: 10.5 11.5 12.5 13.9");

        System.out.println("--------------TESTING get--------------");
        System.out.println("Given   : The Double at index 3 is " + m.get(3));
        System.out.println("Expected: The Double at index 3 is 13.9");

        System.out.println("--------------TESTING size--------------");
        System.out.println("Given   : The size of m is " + m.size());
        System.out.println("Expected: The size of m is 4");
    }
}
