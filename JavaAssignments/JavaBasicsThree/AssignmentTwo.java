//Assignment 2
// Write a Java program to append text to an existing file.

// FileWriter package can also be used to write data in characters to a file.
import java.io.FileWriter;
import java.io.IOException;

public class AssignmentTwo {
    public static void main(String[] args) {

        // System.getProperty and concatenating the file I want to write to.
        String path = "/Users/chuy/Desktop/projects/smoothstack/JavaAssignments/JavaBasicsThree/file.txt";
        // Setting the String I want to append and storing it in memory via the text variable.
        String text = "Appending this text to the file without overriding occuring.";

        // Try catch block for exception handling.
        try {
            //Instatiate a new FileWriter object and passed my path variable to it.
            FileWriter fw = new FileWriter(path, true);
            // using the write method to write my text variable to the file
            fw.write(text);
            // end
            fw.close();
        }
        //Catch IOException
        catch(IOException e) {
            System.out.println(e);
        }
    }
}