public class main{
    public static void main(String[] args) {
        JPriorityQueue myPQ = new JPriorityQueue();
        ErrFile efile = new ErrFile("messages.txt");
        JHashTable myHT = new JHashTable();
        JArchive myArc = new JArchive();
        myPQ = efile.parseFile();

        JProcess processor = new JProcess(myPQ, myHT, myArc);
        processor.process();
    }
}
