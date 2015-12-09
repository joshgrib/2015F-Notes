/**A file of errors, meant to be parsed, turned into "ErrorItem"s, and put in a JPriorityQueue
 * CS284 - Data Structures
 * Final Project
 * I pledge my honor I have abided by the Stevens Honor System.
 *
 * @author Josh Gribbon
 *
 * Sources used: stackoverflow for file parsing help
 */
import java.io.*;
public class ErrFile{
    /**Method to parse the file and put ErrorItems in a JPriorityQueue
     * @param fileName          The name of the file to parse
     * @return                  A JPriorityQueue of "ErrorItem"s
     */
    public static JPriorityQueue parseFile(String fileName){
        //String fileName = "problems.txt";
        String line = null;
        JPriorityQueue myPQ = new JPriorityQueue();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                ErrorItem err = parseLine(line);
                myPQ.insert(err);
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" +
                fileName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
        return myPQ;
    }

    /**Method to parse a line in the file
     * @param line          The string line to be parsed
     * @return              An ErrorItem filled wth the data from the line
     */
    private static ErrorItem parseLine(String line){
    String[] parts = line.split("\\|"); // String array, each element is text between dots
    String user = parts[0];
    String host = parts[1];
    String problem = parts[2];
    String priority = parts[3];
    ErrorItem errItem = new ErrorItem(user, host, problem, priority);
    return errItem;
    }
    /**Main method - used for testing*/
    public static void main(String[] args) {
        JPriorityQueue myQ = new JPriorityQueue();
        myQ = parseFile("problems.txt");
        while(myQ.size > 1){
            System.out.println(myQ.remove().data());
        }
    }
}
