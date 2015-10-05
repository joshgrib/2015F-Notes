public class Queue{
    private MyLinkedList theQ;

    public void enqueue(double elem){
        theQ.addLast(elem);
    }

    public double dequeue(){
        return theQ.removeFirst();
    }

    public double peek(){
        return theQ.get(0);
    }

    public int size(){
        return theQ.size();
    }

    public String toString(){
        return "Queue: " + theQ.toString();
    }

    public static void main(String[] args)
    {
        Queue tq = new Queue();

        tq.enqueue(1.0);
        tq.enqueue(2.0);
        tq.enqueue(3.0);

        System.out.println(tq.size());
        tq.dequeue();
        System.out.println(tq.size());
        System.out.println(tq.peek());
    }
}
