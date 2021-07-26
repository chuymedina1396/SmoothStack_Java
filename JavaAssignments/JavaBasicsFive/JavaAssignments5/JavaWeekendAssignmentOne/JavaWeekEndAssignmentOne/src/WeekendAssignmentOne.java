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


public class WeekEndAssignmentOne {
    public static void main(String[] args){
        Integer i = 4;
        isOdd(i);
        primeOrComposite(i);
        isPalendrone();

    }
    public static boolean isOdd(int num) {
        boolean isOdd = true;
        if(num % 2 == 0){
            isOdd=false;
            System.out.println("EVEN");
            return isOdd;
        } 
        else if(num % 2 != 0){
            isOdd=true;
            System.out.println("ODD");
            return isOdd;
        }
        return isOdd;
    }
    public static boolean primeOrComposite(int num) {
        boolean isPrime=true;
        //Has to be i < n instead of i <= n, every number can be divided by 1 so...
        for (int i=2; i < num; i++) { 
            if (num%i==0) {
               isPrime=false;
                break;
            }
        }
        if(isPrime) {
           System.out.println("its a prime number");
           return true; 
        } 
        System.out.println("its a composite number");
        return false;
   }
   public static boolean isPalindrome(int num) {
       int palindrome = num;
       int reverse = 0;

        // Compute the reverse
        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        return num == reverse;
    }
}