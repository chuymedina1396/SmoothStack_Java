
// Using Java 8 features write a method that returns a comma separated string based on a given list of integers. Each element should be preceded by the letter 'e' if the number is even, and preceded by the letter 'o' if the number is odd. For example, if the input list is (3,44), the output should be 'o3,e44'.

import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.List;

public class Two {
    public static void main(String[] args){
        returnCommaSeperatedValue(3,44);
    }
    public static void returnCommaSeperatedValue(int one, int two ) {
        try {
            if(one % 2 != 0 && two % 2 == 0){
                System.out.println("o" + one + "," + "e" + two );
            }
            else if(one % 2 == 0 && two % 2 !=0){
                System.out.println("e" + one + "," + "o" + two );
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}