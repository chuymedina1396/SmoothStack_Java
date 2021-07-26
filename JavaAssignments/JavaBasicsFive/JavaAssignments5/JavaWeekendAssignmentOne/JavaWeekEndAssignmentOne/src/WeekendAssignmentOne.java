// Write the following methods that return a lambda expression performing a specified action:

    // PerformOperation isOdd(): The lambda expression must return  if a number is odd or  if it is even.
    // PerformOperation isPrime(): The lambda expression must return  if a number is prime or  if it is composite.
    // PerformOperation isPalindrome(): The lambda expression must return  if a number is a palindrome or  if it is not.
    // Input Format

    // Input is handled for you by the locked stub code in your editor.

    // Output Format

    // The locked stub code in your editor will print  lines of output.

    // Sample Input

    // The first line contains an integer,  (the number of test cases).

    // The  subsequent lines each describe a test case in the form of  space-separated integers:
    // The first integer specifies the condition to check for ( for Odd/Even,  for Prime, or  for Palindrome). The second integer denotes the number to be checked.

    // 5
    // 1 4
    // 2 5
    // 3 898
    // 1 3
    // 2 12

    // Sample Output

    // EVEN
    // PRIME
    // PALINDROME
    // ODD
    // COMPOSITE

import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.*;
import java.util.List;
import java.util.function.Consumer;

public class WeekendAssignmentOne {
    public static void main(String[] args){
        isOdd(4);
        // primeOrComposite();
        // isPalendrone();

    }
    public static void isOdd(int num){
        () -> {
            if(num % 2 == 0){
                System.out.println("EVEN");
            } 
            else if(num % 2 != 0){
                System.out.println("ODD");
            }
        };
    }
    public static void primeOrComposite(){

        
    }
    public static void isPalendrone(){
        System.out.println("Hello from isPalendrone");
    }
}