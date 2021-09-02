import java.util.Scanner;

public class JavaBasicsOne2 {
	public static void main(String arg[]) {
		//Started the game
		game();
	}

	//Created a seperate method for the game and invoked it in our main method
	public static void game() {
		// Scanner Class
		Scanner sc = new Scanner(System.in);

		// Generate the random number
		int number = 1 + (int)(100 * Math.random());
		System.out.println(number);

		// Number of user guess
		int numOfGuesses = 5;

		int i, guess;

		System.out.println("Guess the random number between 1-100");
		System.out.println("You have " + numOfGuesses + " tries!!!");

		for (i = 0; i < numOfGuesses; i++) {

			System.out.println("What's your guess:");

			// Take the user's guess
			guess = sc.nextInt();

			// If number is guessed, display winner.
			if (number == guess) {
				System.out.println("Congratulations! You guessed the number.");
				break;
			}
			else if (number > guess && number - 11 < guess && i != numOfGuesses - 1 ) {
				System.out.println("The number is greater than " + guess + ".");
				System.out.println("You were within ten, give or take, digits close to the correct answer, which was: " + number);
				System.out.println("Re-run the program to try again.");
				System.exit(0);
			}
			
			else if (number < guess && number + 11 > guess && i != numOfGuesses - 1 ) {
				System.out.println("The number is less than " + guess + ".");
				System.out.println("You were within ten, give or take, digits close to the correct answer, which was: " + number);
				System.out.println("Re-run the program to try again.");
				System.exit(0);
			}
		}

		if (i == numOfGuesses) {
			System.out.println("Sorry");

			System.out.println("The number was " + number);
		}
		//Close the scanner
		sc.close();
	}
}

/*
	LEGACY SOLUTION BELOW!
*/

// import java.util.Random;
// import java.util.Scanner;

// public class JavaBasicsOne2 {
// 	public static void main(String[] args)
// 	{
// 		int answer, guess;
//         // using final primitve data type
// 		final int max = 100;

// 		// Scanner for getting user input
// 		Scanner in = new Scanner(System.in);

// 		// Creating a new random instance`
// 		Random rand = new Random();

// 		boolean correct = false;

// 		// correct answer
// 		answer = rand.nextInt(max) + 1;

// 		// loop until the guess is correct

// 		while (!correct) {

// 			System.out.println(
// 				"Guess a number between 1 and 100: ");

// 			// guess value
// 			guess = in.nextInt();

// 			// if guess is greater than actual
// 			if (guess > answer) {
// 				System.out.println("Too high, try again");
// 			}

// 			// if guess is less than actual
// 			else if (guess < answer) {
// 				System.out.println("Too low, try again");
// 			}
            // else if(guess + 10 > answer){
            //     System.out.println("You're within ten of the correct answer");
            //     System.out.println(answer);
            // }
            // else if(guess -10 > answer){
            //     System.out.println("You're within ten of the correct answer");
            //     System.out.println(answer);
            // }
            // else if(guess + 10 < answer){
            //     System.out.println("You're within ten of the correct answer");
            //     System.out.println(answer);
            // }
            // else if(guess -10 < answer){
            //     System.out.println("You're within ten of the correct answer");
            //     System.out.println(answer);
            // }
// 			else {
// 				System.out.println(
// 					"Yes, you guessed the number.");

// 				correct = true;
// 			}
// 		}
// 		System.exit(0);
// 	}
// }
