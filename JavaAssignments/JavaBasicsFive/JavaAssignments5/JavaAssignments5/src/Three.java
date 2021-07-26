// Given a list of Strings, write a method that returns a list of all strings that start with the letter 'a' (lower case) and have exactly 3 letters. TIP: Use Java 8 Lambdas and Streams API's.

import java.util.List;
import java.util.Arrays;

public class Three {
    public static void main(String[] args){
        returnListOfStringsWithA();
    }
    public static void returnListOfStringsWithA(){

        String[] myArray = {"another", "one", "here", "we", "go", "again", "aye"};

        List<String> listOfStrings = Arrays.asList(myArray);
        listOfStrings.stream()
            .filter(s -> (s.startsWith("a") && s.length() == 3)) // I couldn't help just one-lining this code :)
            .forEach(s -> System.out.println(s));
        
    }
}
