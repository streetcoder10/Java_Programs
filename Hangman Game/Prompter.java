/*
 * Author - Vikram Gopal
 * Description - Class for prompter who prompts the user to for guess to play the Hangman game
 * , displays remaining tries, display progress and display if game is won or lost.
 */

package Viky_Programs;

import java.util.Scanner;

public class Prompter 
{
	private Game game;

	public Prompter(Game game)
	{
		this.game=game;
	}

	public boolean promptForGuess()
	{
		Scanner scanner = new Scanner(System.in);	
		boolean isHit =false;

		boolean isAcceptable=false;
	
    do{
			System.out.println("Enter a letter: ");
			String inputGuess = scanner.nextLine();

			try{
				isHit = game.applyGuess(inputGuess);
				isAcceptable=true;
			}
      
			catch(IllegalArgumentException iae)
			{
				System.out.printf(iae.getMessage()+"  please try again! %n");
			}
      
		}while(!isAcceptable);

		return isHit;

	}

	public void displayProgress()
	{ 
		System.out.println("You have "+game.remainingtries()+" tries!");
		System.out.println("Try to solve =>"+game.currentProgress());

	}

	public void displayResult()
	{
		if(!game.isWon())
			System.out.println("You let an innocent man die! \n"+game.getAnswer()+" was the answer!");
		else
			System.out.println("Don't feel so proud that you won this game!\n"+game.getAnswer()+" is the answer");

	}
}
