// Write the following methods that return a lambda expression performing a specified action:

    // PerformOperation isOdd(): The lambda expression must return  if a number is odd or  if it is even.
    // PerformOperation isPrime(): The lambda expression must return  if a number is prime or  if it is composite.
    // PerformOperation isPalindrome(): The lambda expression must return  if a number is a palindrome or  if it is not.
import java.util.*;

interface PerformOperation {
    public boolean isOdd(int num);
    public boolean primeOrComposite(int num);
    public boolean isPalindrome(int num);
}

public class WeekEndAssignmentOne implements PerformOperation{
    public static void main(String[] args){
        public PerformOperation isOdd = num -> {
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
    
        };
        public PerformOperation primeOrComposite = num -> {
            boolean isPrime=true;
            //Has to be i < n instead of i <= n, every number can be divided by 1 so...
            for (int i=2; i < num; i++) { 
                if (num%i==0) {
                    isPrime=false;
                }
            }
            if(isPrime) {
               System.out.println("its a prime number");
               return true; 
            } 
            System.out.println("its a composite number");
            return false;
        };
        public PerFormOperation isPalindrome = num -> {
            int palindrome = num;
            int reverse = 0;

            while (palindrome != 0) {
                int remainder = palindrome % 10;
                reverse = reverse * 10 + remainder;
                palindrome = palindrome / 10;
            }
            return num == reverse;
        };
    };
}
    // public static boolean isOdd(int num) {
    //     boolean isOdd = true;
    //     if(num % 2 == 0){
    //         isOdd=false;
    //         System.out.println("EVEN");
    //         return isOdd;
    //     } 
    //     else if(num % 2 != 0){
    //         isOdd=true;
    //         System.out.println("ODD");
    //         return isOdd;
    //     }
    //     return isOdd;
    // }

//     public static boolean primeOrComposite(int num) {
//         boolean isPrime=true;
//         //Has to be i < n instead of i <= n, every number can be divided by 1 so...
//         for (int i=2; i < num; i++) { 
//             if (num%i==0) {
//                isPrime=false;
//                 break;
//             }
//         }
//         if(isPrime) {
//            System.out.println("its a prime number");
//            return true; 
//         } 
//         System.out.println("its a composite number");
//         return false;
//    }
//    public static boolean isPalindrome(int num) {
//         int palindrome = num;
//         int reverse = 0;

//         while (palindrome != 0) {
//             int remainder = palindrome % 10;
//             reverse = reverse * 10 + remainder;
//             palindrome = palindrome / 10;
//         }
//         return num == reverse;
//     }