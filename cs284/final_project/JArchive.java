/**An archive of past problems that have been handled
 * CS284 - Data Structures
 * Final Project
 * I pledge my honor I have abided by the Stevens Honor System.
 *
 * @author Josh Gribbon
 *
 * Sources used: Stackoverflow for making the array
 */
import java.util.ArrayList;
import java.util.List;
public class JArchive{
    /**The list to store the info in*/
    private List<ListNode> theList;
    /**A counter to create unique IDs*/
    private int idCount;

    /**Constructor*/
    public JArchive(){
        this.idCount = 0;
        this.theList = new ArrayList<ListNode>();
    }

    /**Add an item
     * @param e         An ErrorItem to add to the archive
     */
    public void add(ErrorItem e){
        try{
            ListNode node = new ListNode(e, idCount);
            theList.add(node);
            this.idCount++;
        }
        catch(NullPointerException err){
            System.out.println("Found a null pointer exception!");
        }
    }

    /**Subclass for an entry in the archive*/
    private class ListNode{
        /**The nodes unique ID*/
        int ID;
        /**The data for the entry*/
        String data;
        /**Constructor*/
        private ListNode(ErrorItem e, int UID){
            this.data = e.toString();
            this.ID = UID;
        }
    }
}
