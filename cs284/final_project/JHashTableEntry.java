/**A node in the JHashTable
 * CS284 - Data Structures
 * Final Project
 * I pledge my honor I have abided by the Stevens Honor System.
 *
 * @author Josh Gribbon
 */
public class JHashTableEntry{
    /**The key for the table*/
    private int key;
    private ErrorItem data;

    /**Constructor
     * @param k             The key for the entry
     * @param d             The data for the entry
     */
    public JHashTableEntry (int k, ErrorItem d){
        // Creates a node holding d
        this.key = k;
        this.data = d;
    }

    /**Data getter
     * @return      The ErrorItem stored in the entry
     */
    public ErrorItem data(){
        return this.data;
    }

    public void setData( ErrorItem d){
        this.data = d;
    }

    /**Priority getter
     * @return      The key for the entry
     */
    public int key(){
        return this.key;
    }
}
