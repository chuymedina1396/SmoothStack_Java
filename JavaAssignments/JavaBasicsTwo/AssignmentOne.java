import java.util.Scanner;
public class AssignmentOne {
    public static void main(String args[]) {
        // NOTE: Not DRY at all :( lol 
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number:");
        int a = scan.nextInt();

        System.out.println("Enter another number:");
        int b = scan.nextInt();

        System.out.println("Enter another number:");
        int c = scan.nextInt();

        System.out.println("Enter one more number:");
        int d = scan.nextInt();
        scan.close();

        System.out.println("And the result is ..." + " " + (a + b + c + d));
	}
}
