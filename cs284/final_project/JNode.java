/**A node in the JPriorityQueue
 * CS284 - Data Structures
 * Final Project
 * I pledge my honor I have abided by the Stevens Honor System.
 *
 * @author Josh Gribbon
 *
 * Sources used: Linked list node from HW2
 */
public class JNode{
    /**The ErrItem to store*/
    public ErrorItem data;
    /**The priority of the ErrItem*/
    public int priority;
    /**The next JNode in the list*/
    public JNode next;
    /**The prevous JNode in the list*/
    public JNode prev;

    /**Constructor
     * @param errMsg        The ErrorItem to store in the node
     */
    public JNode (ErrorItem errMsg){
        // Creates a node holding d
        data = errMsg;
        next = null;
        prev = null;
        priority = errMsg.priority();
    }

    /**Constructor
     * @param errMsg        The ErrorItem to store in the node
     * @param n             The next JNode in the list
     * @param p             The previous JNode in the list
     */
    public JNode(ErrorItem errMsg, JNode n,JNode p){
        data = errMsg;
        next = n;
        prev = p;
    }

    /**Data getter
     * @return      The ErrorItem stored in the node
     */
    public ErrorItem data(){
        return this.data;
    }

    /**Priority getter
     * @return      The priority of the ErrorItem in the node
     */
    public int priority(){
        return this.priority;
    }
}
