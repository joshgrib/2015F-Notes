/**A hash table to store problems that have been handled. Hash table uses open addressing and linear probing
 * CS284 - Data Structures
 * Final Project
 * I pledge my honor I have abided by the Stevens Honor System.
 *
 * @author Josh Gribbon
 *
 * Sources used: Hash table example at http://www.algolist.net/
 */
import java.util.Random;
public class JHashTable{

    private final static int TSize = 128;
    JHashTableEntry[] table;

    JHashTable(){
        table = new JHashTableEntry[TSize];
        for (int i = 0; i < TSize; i++)
            table[i] = null;
    }

    public ErrorItem get(int k){
        int hash = (k % TSize);
        int iHash = -1;
        while (hash != iHash
                && (table[hash] == JHashTableDeletedEntry.getADeletedEntry() || table[hash] != null
                         && table[hash].key() != k)) {
            if (iHash == -1)
                iHash = hash;
            hash = (hash + 1) % TSize;
        }
        if (table[hash] == null || hash == iHash)
            return null;
        else
            return table[hash].data();
    }

    public int getHash(String name){
        int name_length = name.length();
        int hash_num = 0;
        for(int i=0; i<name_length; i++){
            hash_num += Math.pow(23, name_length-(i+1)) * (int)name.charAt(i);
        }
        return hash_num;
    }

    public void put(ErrorItem d){
        put( getHash(d.user()), d);
    }

    public void put(int k, ErrorItem d){
        int hash = (k % TSize);
        int iHash = -1;
        int iOfDelEntry = -1;
        while (hash != iHash
                && (table[hash] == JHashTableDeletedEntry.getADeletedEntry() || table[hash] != null
                    && table[hash].key() != k)) {
            if (iHash == -1)
                iHash = hash;
            if (table[hash] == JHashTableDeletedEntry.getADeletedEntry())
                iOfDelEntry = hash;
            hash = (hash + 1) % TSize;
        }
        if ((table[hash] == null || hash == iHash)
                && iOfDelEntry != -1)
            table[iOfDelEntry] = new JHashTableEntry(k, d);
        else if (iHash != hash)
            if (table[hash] != JHashTableDeletedEntry.getADeletedEntry()
                && table[hash] != null && table[hash].key() == k)
                table[hash].setData(d);
            else
                table[hash] = new JHashTableEntry(k, d);
    }

    public void remove(int k){
        int hash = (k % TSize);
        int iHash = -1;
        while (hash != iHash
                && (table[hash] == JHashTableDeletedEntry.getADeletedEntry() || table[hash] != null
                        && table[hash].key() != k)) {
            if (iHash == -1)
                iHash = hash;
            hash = (hash + 1) % TSize;
        }
        if (hash != iHash && table[hash] != null)
            table[hash] = JHashTableDeletedEntry.getADeletedEntry();
    }

    /**Main method - used for testing*/
    public static void main(String[] args){
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
        JHashTable htable = new JHashTable();
        while(myQ.size > 1){
            ErrorItem err = myQ.remove().data();
            System.out.println(err + " added!");
            htable.put(err);
        }
        //maybe use assertEquals(x, y); for testing?
    }
}
