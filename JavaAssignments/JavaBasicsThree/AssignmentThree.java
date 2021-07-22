//Assignment 3
// Write a Java program that counts the number of times a particular character, such as 'e', appears in a file. The character can be specified at the command line. 

import java.io.IOException;
import java.io.FileReader;
// Using Scanner again for user input.
import java.util.Scanner;


public class AssignmentThree {
    public static void main(String[] args) throws IOException {
        // Instatiating new Scanner object
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a character to filter for and tally up how many times it occurs in the file :) ... ");
        //Get userInput. char type. then move on to next.
        char userInput = scan.next().charAt(0);
        //end the scan
        scan.close();

        //current file in my directory
        String fileName = "file.txt";
        String line = "";
        //Instatiating new scanner object and passing/instatiating a new FileReader object and passing file
        Scanner scanner = new Scanner(new FileReader(fileName));

        //Try catch block
        try {

            //declared a counter variables to keep track of how many times a char occurs in the file
            int counter = 0;
            // Declared my starting point variable for looping.
            int i;

            while ( scanner.hasNextLine() ){
                line = scanner.nextLine();

                for(i=0; i<line.length(); i++ ) {
                    //IF the userInput is equal to the current index in the file, increase counter variable by 1.
                    if( line.charAt(i) == userInput ) {
                        counter++; 
                    } 
                }  
            }
            System.out.println(counter); 
        }
        finally {
          scanner.close();
        }
    }
}

