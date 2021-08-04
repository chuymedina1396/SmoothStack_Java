import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        //MAIN METHODS FOR MENU FUNCTIONALITY
        mainMenu();
        printCode();

    }

    public static void mainMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Utopia Airlines Management System. Which category of a user are you?");
        System.out.println("1) Employee/Agent");
        System.out.println("2) Administrator");
        System.out.println("3) Traveler");
        Integer input = scan.nextInt();
        if(input == 1){
            System.out.println("You have chosen Employee and will now be directed to the Employee Menu");
            employeeMenu();
        }
        if(input == 2){
            System.out.println("You have chosen Administrator and will now be directed to the Administrator Menu");
        }
        if(input == 3){
            System.out.println("You have chosen Traveler and will now be directed to the Traveler Menu");
        }
        scan.close();
    }

    public static void employeeMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("1) Enter the flights you manage: ");
        System.out.println("2) Quit to previous menu: ");
        Integer input = scan.nextInt();
        if(input == 1){
            System.out.println("List of Flights from database. ");
        }
        if(input == 2){
            mainMenu();
        }
        scan.close();
    }

    public static void printCode() {
		String code = "";
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
 
			 int r = random.nextInt(10); // randomly give a number each time (0-9)
 
			 code = code + r; //Put together the random numbers every time
 
		}
		System.out.println(code);
	}
}


