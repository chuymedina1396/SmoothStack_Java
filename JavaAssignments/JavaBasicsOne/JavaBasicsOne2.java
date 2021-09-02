import java.util.Random;
import java.util.Scanner;

public class JavaBasicsOne2 {
	public static void main(String[] args)
	{
		int answer, guess;
        // using final primitve data type
		final int max = 100;

		// Scanner for getting user input
		Scanner in = new Scanner(System.in);

		// Creating a new random instance`
		Random rand = new Random();

		boolean correct = false;

		// correct answer
		answer = rand.nextInt(max) + 1;

		// loop until the guess is correct
		while (!correct) {

			System.out.println(
				"Guess a number between 1 and 100: ");

			// guess value
			guess = in.nextInt();

			// if guess is greater than actual
			if (guess > answer) {
				System.out.println("Too high, try again");
			}

			// if guess is less than actual
			else if (guess < answer) {
				System.out.println("Too low, try again");
			}
            else if(guess + 10 > answer){
                System.out.println("You within ten of the correct answer");
                System.out.println(answer);
            }
            else if(guess -10 > answer){
                System.out.println("You within ten of the correct answer");
                System.out.println(answer);
            }
            else if(guess + 10 < answer){
                System.out.println("You within ten of the correct answer");
                System.out.println(answer);
            }
            else if(guess -10 < answer){
                System.out.println("You within ten of the correct answer");
                System.out.println(answer);
            }
			else {
				System.out.println(
					"Yes, you guessed the number.");

				correct = true;
			}
		}
		System.exit(0);
	}
}
