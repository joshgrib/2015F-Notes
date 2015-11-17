import java.util.*;
public class hw4{
    /**Class to represent a credit card offer*/
    public class creditOffer{
        /**The fee for the card*/
        public double membershipFee;
        /**The cash back rate*/
        public double CBR;
        /**The annual percentage rate*/
        public double APR;
        /**Constructor
         * @param fee       The fee for the card
         * @param cbr       The cash back rate
         * @param apr       The annual percentage rate
         */
        public creditOffer(double fee, double cbr, double apr){
            this.membershipFee = fee;
            this.CBR = cbr;
            this.APR = apr;
        }
    }
    public class MyMaxHeap{
        public creditOffer theHeap;
        public int size;
        public int capacity;
        public MyMaxHeap(double monthlyExpenses){
            //Creates an empty heap with capacity 5
        }
        public MyMaxHeap(creditOffer[] arr, int n, double monthlyExpenses){
            //Creates a heap by inserting the elements of the input array arr
        }
        public int size(){
            //the size of the heap
            return 0;
        }
        public boolean add(creditOffer job){
            //adds element and reheaps
            return true;
        }
        public creditOffer removeMax(){
            //Returns the node was the highest score and reheaps
            return new creditOffer(0, 0, 0);
        }
        public void showList(){
            //Prints all the elements in the order they are stored
        }
        public void swap(int i, int j){
            //Swaps nodes at i and j
        }
        public int compare(int i, int j){
            //compares nodes at i and j
            return 0;
        }
    }
    public class MyPriorityQueue{
        MyMaxHeap theQueue;
        public MyPriorityQueue(double monthlyExpenses){
            //creates an empty priority queue
        }
        public MyPriorityQueue(creditOffer[] arr, int n, double monthlyExpenses){
            //creates a priority queue out of an array of n creditOffer nodes
        }
        public boolean offer(creditOffer co){
            //adds a new element to the queue and returns true
            return true;
        }
        public creditOffer remove(){
            // removes the first node in the queue and returns it or returns null if the queue is empty
            return new creditOffer(0, 0, 0);
        }
        public creditOffer peek(){
            //returns the item in the front of the queue without removing it or null if the queue is empty
            return new creditOffer(0, 0, 0);
        }
        public boolean isEmpty(){
            //returns true if the queue is empty
            return true;
        }
        public void showList(){
            // Prints all the elements in the queue in the order they are stored
        }
    }
    /**Method for testing*/
    public static void main(String[] args) {
        System.out.println("Hello Josh");
    }
}
