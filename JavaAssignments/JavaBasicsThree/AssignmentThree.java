//Assignment 3
// Write a Java program that counts the number of times a particular character, such as 'e', appears in a file. The character can be specified at the command line. 

import java.io.*;
import java.util.Scanner;


public class AssignmentThree {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a character to filter for and tally up how many times it occurs in the file :) ... ");
        char userInput = scan.next().charAt(0);
        scan.close();

        String fileName = "file.txt";
        String line = "";
        Scanner scanner = new Scanner(new FileReader(fileName));
        try {

            int counter = 0;
            int i;

            while ( scanner.hasNextLine() ){
                line = scanner.nextLine();

                for(i=0; i<line.length(); i++ ) {
                    if( line.charAt(i) == userInput ) {
                        counter++; 

                    } 
                }  
            }
            System.out.println(counter); 
        }
        finally {

          scanner.close();


    }}}

