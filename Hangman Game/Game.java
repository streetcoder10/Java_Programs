/*
 * Author - Vikram Gopal
 * Description - Game class which contains the logic behind the Hangman Game,
 * this can be used as a base to develop the application on any platform.
 */

package Viky_Programs;

public class Game 
{
	public static final int MAX_TRIES=7;
	private String answer;
	private String hits;
	private String misses;

	public Game(String answer)
	{
		this.answer=answer.toLowerCase();
		hits="";
		misses="";
	}

	private char normalizedGuess(char letter)
	{
		if(!Character.isLetter(letter))
			throw new IllegalArgumentException("Enter a letter!");

		letter = Character.toLowerCase(letter);


		if(misses.indexOf(letter)!=-1 || hits.indexOf(letter)!=-1)
		{
			throw new IllegalArgumentException(letter+ " has already been guessed");
		}

		return letter;
	}

	public boolean applyGuess(String letter)
	{
		if(letter.length()==0)
			throw new IllegalArgumentException("No letter found!");

		return applyGuess( letter.charAt(0));
	}

	public boolean applyGuess(char letter) 
	{
		letter = normalizedGuess(letter);

		boolean isHit = answer.indexOf(letter)!=-1;
		if(isHit)
			hits+=letter;
		else
			misses+=letter;

		return isHit;
	}

	public String currentProgress()
	{
		String progress ="";

		for(char letter: answer.toCharArray())
		{
			char display ='-';

			if(hits.indexOf(letter)!=-1)
				display = letter;

			progress+=display;
		}
		return progress;
	}

	public int remainingtries()
	{
		return  MAX_TRIES-misses.length();

	}

	public boolean isWon()
	{
		return currentProgress().indexOf('-')==-1;
	}

	public String getAnswer()
	{
		return answer;
	}
}
