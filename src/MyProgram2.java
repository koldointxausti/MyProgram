import java.util.Scanner;
public class MyProgram2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// Print the games' description
		System.out.println("Welcome to the famous HANGMAN game.");
		System.out.println("First of all, someone who is not playing has to enter a word.");
		System.out.println("Then, the player will have to guess which word is hidden between the voids.");
		System.out.println("For this, you will be able to enter 3 letters that may appear in the word, or not. After this, you will only have a chance to guess the word hidden and win the game.");
		System.out.println("Good luck, start with the first letter.");
		boolean wordFound=false;
		while (wordFound==false) {
			if (!sc.hasNextInt()) {
				wordFound=true;
				String word = sc.next();
				int spaceCounter=0;
				while (spaceCounter<20) {
					System.out.println("");
					spaceCounter++;
				}
				// Create a char array with the length of the word
				char guessed[]=new char[word.length()];
				// Declare a variable that will hold the number of letter that the user guesses
				int guessedCounter=0;
				// Printing the word with voids
				int index3=0;
				while (index3<word.length()) {
						System.out.print("_ ");
					index3++;
				}
				// Open a loop that will go asking to the user a possible letter in each turn
				int flag=0;
				while (flag<3) {
					// Check that the user doesn't enter a number
					if (!sc.hasNextInt()) {
						// Create a string object with the letter's value
						String possibleLetter=sc.next();
						// Check that the user has entered just a character
						if (possibleLetter.length()==1) {
							// Open a loop that will go checking if the letter the user entered is in the surname
							int index=0;
							while (index<word.length()) {
								if (word.charAt(index)==possibleLetter.charAt(0)) {
									// If it is, open another loop which will go checking if the user had already guessed that letter
									boolean found = false;
									int index2=0;
									while (index2<guessed.length && guessed[index2]!=possibleLetter.charAt(0) && !found ){
										if (guessed[index2]==guessed[3]) {
											// If he/she had not done so, save the letter in the array 'guessed'
											guessed[guessedCounter] = word.charAt(index);
											// Increment once the variable 'guessedCounter' for a future possible letter
											guessedCounter++;
											// Define the variable 'found' as true so as to get out of the loop
											found = true;
										}
										// Increment the the variable 'index2' so as to check the next letter
										index2++;
									}
								}
								// Increment the variable 'index' so as to check the next letter
								index++;
							}
							// Printing the word with only the letters that the user guessed
							int index4=0;
							while (index4<word.length()) {
								boolean found = false;
								int index5=0;
								while (index5<guessed.length) {
									if (guessed[index5]==word.charAt(index4)) {
										System.out.print(word.charAt(index4)+ " ");
										found = true;
									}
									index5++;
								}
								if (!found) {
									System.out.print("_ ");
								}
								index4++;
							}
							// Increment the variable 'flag' so as to ask the next letter
							flag++;
						}
						// If the user entered more than one characters, ask him/her to enter just one
						else {
							System.out.println("Don't cheat, please enter just a letter.");
						}
					}
					// If the user entered a number, ask him to enter a letter
					else {
						System.out.println("That is not a letter, try it again.");
						// Jump the token '/n'
						sc.next();
					}
					// Print to the user the letters he/she has left
					if (flag == 1) {
						System.out.println("You have two letters left.");
					}
					else if (flag==2){
						System.out.println("You have just a letter left.");
					}
				}
				// Ask to the user a possible word
				System.out.println("It's the time, you have to guess the surname.");
				String userRandom = sc.next();
				if (userRandom.equals(word)) {
					System.out.println("Congrats, you won the game.");
				}
				else {
					System.out.println("I'm sorry, you lost the game. The word was " + word);
				}
			}
			else {
				System.out.println("Enter a word please");
				sc.next();
			}
		}
		sc.close();
	}
}
