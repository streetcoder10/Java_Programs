/*
 * Author - Vikram Gopal
 * Description - Main class for Hangman Game
 */

package Viky_Programs;

public class Hangman 
{
	public static void main(String [] args) {


		Game game = new Game("Demonstration");

		Prompter prompter = new Prompter(game);

		while(game.remainingtries()>0 && !game.isWon())
		{
			prompter.displayProgress();
			prompter.promptForGuess();
		}

		prompter.displayResult();
	}
}
