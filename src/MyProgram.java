import java.util.Scanner;
import java.util.Random;
public class MyProgram {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// Save into an array all the surnames of the people in class
		String[] surnames = {"lazkano","intxausti","artola","alberdi","lekubide"};
		// Take randomly a surname between them
		String randomSurname = surnames[new Random().nextInt(surnames.length)];
		char [] surnameChars = randomSurname.toCharArray();
		System.out.println("Welcome to the famous HANGMAN game.");
		System.out.println("You will have to guess which surname of the people in class is hidden between the voids.");
		System.out.println("For this, you will be able to enter 3 letters that may appear in the surname, or not. After this, you will only have a chance to guess the surname and win the game.");
		System.out.println("Good luck, start with the first letter.");
		int flag=0;
		while (flag<=3) {
			if (!sc.hasNextInt()) {
				String possibleLetter=sc.next();
				if (possibleLetter.length()==1) {
					int lettersquantity=0;
					for (int index=0;index<randomSurname.length();index++) {
						if (possibleLetter.charAt(0)==randomSurname.charAt(index)) {
							lettersquantity++;
							char[] guessedLetters=new char[lettersquantity];
							
						}
					}
				}
				else {
					System.out.println("Don't cheat, please enter just a letter");
				}
			}
			else {
				System.out.println("That is not a letter, try it again");
				// Jump the token '/n'
				sc.next();
			}
		}
		sc.close();
	}
}