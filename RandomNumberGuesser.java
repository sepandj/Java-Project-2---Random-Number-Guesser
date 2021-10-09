

/*
 * Class: CMSC203 
 * Instructor: Prf. Gary Thai
 * Description: Random Number Guessing Game
 * Due: 10/08/2021
 * Platform/compiler: Java Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Sepand Jahrominejad
*/










//inserting Scanner to be able to accept user input
import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) {
		
		
		//program's header
		System.out.println("****  This program let's you guess a random number"+
							" between 0 and 100  ****");
		
		//creating a new input
		Scanner input = new Scanner(System.in);
		
		//a yes or no string for program's re-run later
		String yesNo ;
		
		
		
		//creating a do-while loop to make the program re-runable by the user
		do {
			//initializing low and high guess values to default 
			//at the start of each loop
			int highGuess = 100;
			int lowGuess = 0;
			
			//creating and initializing a random number
			int randNum = RNG.rand();
			
			//reseting count to 0 at the start of each loop
			RNG.resetCount();
			
			//a hidden shortcut to the random number
			//System.out.println("the random number is "+ randNum);
			
			
			//asking user to start by inserting an input
			System.out.print("\n----  To start, first guess a number between 0 and 100: ");
		
			
			//assigning user's guess to a variable
			int nextGuess = input.nextInt();
		
			
			//validating user's input with the current needed integer range
			while(RNG.inputValidation(nextGuess, lowGuess, highGuess)==false) {
				nextGuess = input.nextInt();
				
			}
		
		
			//creating a do-while loop to narrow down user's guesses to the random number
			do {
				
					//if the user guesses correctly the first time
					if(nextGuess==randNum && RNG.getCount() == 1) {
						System.out.println("        Congratulations!! You've guessed correctly.");
			
						System.out.println("        Impressive!! only 1 guess.");
					}
		
					
					//if the user's guess is more than the random number
					else if(nextGuess>randNum) {
						
						//assigning user's guess to the high guess
						highGuess = nextGuess;
						
						//telling the user to guess a different number in a specified range
						System.out.println("       ****  Number of guess(s): "+ RNG.getCount()+ "  ****");
						System.out.println("        Your guess is too high");
						System.out.print("\n      Enter you next guess between "+
									lowGuess+" and " +highGuess+ ": ");
						nextGuess = input.nextInt();
						
						//validating user's input with the current needed integer range
						while(RNG.inputValidation(nextGuess, lowGuess, highGuess)==false) {
							nextGuess = input.nextInt();
						}
						
					}
				
					
					//if user's guess is less than the random number
					else if(nextGuess<randNum) {
						
						//assigning user's guess as the low number in guessing range
						lowGuess = nextGuess;
						
						//asking user to guess another number in the specified range
						System.out.println("       ****  Number of guess(s): "+ RNG.getCount()+ "  ****");
						System.out.println("        Your guess is too low");
						System.out.print("\n      Enter you next guess between "+
									lowGuess+" and " +highGuess+ ": ");
						nextGuess = input.nextInt();
						
						//validating user's input with the current needed integer range
						while(RNG.inputValidation(nextGuess, lowGuess, highGuess)==false) {
							nextGuess = input.nextInt();
						}
						
					}
				
			}while(nextGuess!=randNum);//condition of the do-while loop while guesses are wrong
			
			//congratulating user if they guess the number correctly with number of guesses more than one
			if(RNG.getCount()>1) {
				System.out.println("\n      Congratulations!! You've guessed correctly.");
				System.out.println("       ****  Number of guess(s): "+ RNG.getCount()+ "  ****");
			}
		
			
			//asking user if they want to play again
			System.out.print("\n      Would you like to try again(Yes/No)? ");
			
			
			//getting user's yes or no input
			input.nextLine();
			yesNo = input.nextLine();
			
			
			//validating user's input to yes or no answers only
			while (yesNo.compareToIgnoreCase("yes")!=0 && yesNo.compareToIgnoreCase("no")!=0){
				
				System.out.print("        Please answer only with yes or no: ");
				yesNo = input.nextLine();
			}
			
		}while(yesNo.equalsIgnoreCase("yes"));//condition of do-while loop while the user wants to play
		
		
		//thanking the user if they don't want to play anymore
		if (yesNo.equalsIgnoreCase("no")){
			System.out.println("      Thanks for playing.");
		}
		
		//closing the input
		input.close();
	}

}
