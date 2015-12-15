public class JProcess{
    JPriorityQueue pqueue;
    JHashTable hashtable;
    JArchive archive;
    public JProcess(JPriorityQueue jpq, JHashTable jht, JArchive ja){
        this.pqueue = jpq;
        this.hashtable = jht;
        this.archive = ja;
    }

    public void process(){
        while(this.pqueue.size > 1){
            ErrorItem data = this.pqueue.remove().data();
            this.hashtable.put(data);
            this.archive.add(data);
        }
    }
}
