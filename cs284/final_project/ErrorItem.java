/**A item from the list of errors, from an ErrFile, meant to be stored in a JPriorityQueue
 * CS284 - Data Structures
 * Final Project
 * I pledge my honor I have abided by the Stevens Honor System.
 *
 * @author Josh Gribbon
 *
 * Sources used: none
 */
public class ErrorItem{
    /**The user that reported the problem*/
    String user = null;
    /**The host the problem occurred on*/
    String host = null;
    /**The problem itself*/
    String problem = null;
    /**The priority level*/
    int priority = -1;

    /**Constructor
     * @param u         User
     * @param h         Host
     * @param pro       Problem
     * @param pri       Priority
     */
    public ErrorItem(String u, String h, String pro, String pri){
        this.user = u;
        this.host = h;
        this.problem = pro;
        int x = Integer.parseInt(pri);
        this.priority = x;
    }

    /**User getter
     * @return      The user
     */
    public String user(){
        return this.user;
    }
    /**Host getter
     * @return      The host
     */
    public String host(){
        return this.host;
    }
    /**Problem getter
     * @return      The problem
     */
    public String problem(){
        return this.problem;
    }
    /**Priority getter
     * @return      The priority
     */
    public int priority(){
        return this.priority;
    }
    /**Override of toString() method
     * @return      String in the form of "<USER~HOST~PROBLEM~PRIORITY>"
     */
    public String toString(){
        String resp = "<" +
        user + "~" +
        host + "~" +
        problem + "~" +
        Integer.toString(priority) + ">";
        return resp;
    }
    /**Main method - used for testing*/
    public static void main(String[] args) {
        ErrorItem myE = new ErrorItem("jgribbon", "host1", "Memory", "3");
        System.out.println("Error item created with user-jgribbon, host-host1, problem-Memory, priority-3.");
        System.out.println(myE);
    }
}
