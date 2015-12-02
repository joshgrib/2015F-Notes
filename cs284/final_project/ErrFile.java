import java.io.*;
public class ErrFile{

    public static void parseFile(String fileName){
        //String fileName = "problems.txt";
        String line = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                parseLine(line);
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
    }

    public static void parseLine(String line){
    String[] parts = line.split("\\|"); // String array, each element is text between dots
    String user = parts[0];
    String host = parts[1];
    String problem = parts[2];
    String priority = parts[3];
    ErrorItem errItem = new ErrorItem(user, host, problem, priority);
    System.out.println("User:" + errItem.user);
    System.out.println("Host:" + errItem.host);
    System.out.println("Problem:" + errItem.problem);
    System.out.println("Priority:" + errItem.priority);
    System.out.println();
    }
    public static void main(String[] args) {
        parseFile("problems.txt");
    }
}
