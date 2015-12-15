/**A system to process entries in the priority queue and put them into the archive and hash table
 * CS284 - Data Structures
 * Final Project
 * I pledge my honor I have abided by the Stevens Honor System.
 *
 * @author Josh Gribbon
 *
 * Sources used: stackoverflow for file parsing help
 */
public class JProcess{
    /**The priority queue*/
    JPriorityQueue pqueue;
    /**The hash table*/
    JHashTable hashtable;
    /**The archive*/
    JArchive archive;

    /**Constructor
     * @param jpq           The priority queue of problems
     * @param jht           The has table to put entries
     * @param ja            The archive to put problems
     */
    public JProcess(JPriorityQueue jpq, JHashTable jht, JArchive ja){
        this.pqueue = jpq;
        this.hashtable = jht;
        this.archive = ja;
    }

    /**Method to process data*/
    public void process(){
        while(this.pqueue.size > 1){
            ErrorItem data = this.pqueue.remove().data();
            this.hashtable.put(data);
            this.archive.add(data);
        }
    }
}
