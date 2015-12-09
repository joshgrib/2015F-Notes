import java.io.*;
public class ErrFile{
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

    private static ErrorItem parseLine(String line){
    String[] parts = line.split("\\|"); // String array, each element is text between dots
    String user = parts[0];
    String host = parts[1];
    String problem = parts[2];
    String priority = parts[3];
    ErrorItem errItem = new ErrorItem(user, host, problem, priority);
    return errItem;
    }

    public static void main(String[] args) {
        JPriorityQueue myQ = new JPriorityQueue();
        myQ = parseFile("problems.txt");
        while(myQ.size > 1){
            System.out.println(myQ.remove().data());
        }
    }
}
