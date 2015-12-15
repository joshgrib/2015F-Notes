/**A deleted node in the JHashTable
 * CS284 - Data Structures
 * Final Project
 * I pledge my honor I have abided by the Stevens Honor System.
 *
 * @author Josh Gribbon
 */
public class JHashTableDeletedEntry extends JHashTableEntry {
    /**Set a null entry*/
    private static JHashTableDeletedEntry entry = null;

    /**Constructor*/
    private JHashTableDeletedEntry() {
        super(-1, null);
    }

    /**Getter for a deleted entry*/
    public static JHashTableDeletedEntry getADeletedEntry() {
        if (entry == null)
            entry = new JHashTableDeletedEntry();
        return entry;
    }
}
