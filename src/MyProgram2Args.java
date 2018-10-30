import java.util.Scanner;
public class MyProgram2Args {
	public static void main(String[] args) {
		if (args.length==2) {
			String name = args[0];
			String word = args [1];
			Scanner sc = new Scanner(System.in);
			boolean numberFound=false;
			for (int i=0;i<word.length();i++) {
				if (word.charAt(i)=='0'||word.charAt(i)=='1'||word.charAt(i)=='2'||word.charAt(i)=='3'||word.charAt(i)=='4'||word.charAt(i)=='5'||word.charAt(i)=='6'||word.charAt(i)=='7'||word.charAt(i)=='8'||word.charAt(i)=='9') {
					numberFound=true;
				}
			}
			if (numberFound==false){
				// Hide the word to the player
				for (int spaceCounter=0;spaceCounter<100;spaceCounter++) {
					System.out.println("");
				}
				// Print the games' description
				System.out.println("Welcome to the famous HANGMAN game V2 " + name + ".");
				System.out.println("You will have to guess which word is hidden between the voids.");
				System.out.println("For this, you will be able to enter 3 letters that may appear in the word, or not. After this, you will only have a chance to guess the word hidden and win the game.");
				// Create a char array with the length of the maximum quantity of letters the player can guess
				char guessed[]=new char[3];
				// Declare a variable that will hold the number of letters that the player guesses
				int guessedCounter=0;
				// Print the word with voids
				for (int index3=0;index3<word.length();index3++) {
					System.out.print("_ ");
				}
				System.out.println("Good luck, start with the first letter.");
				// Open a loop that will go asking to the player a possible letter in each turn
				int flag=0;
				while (flag<3) {
					// Check that the player doesn't enter a number
					if (!sc.hasNextInt()) {
						// Create a string object with the letter's value
						String possibleLetter=sc.nextLine().toLowerCase();
						String[] letterArray=possibleLetter.split(" ");
						if (letterArray.length==1) {
							// Check that the player has entered just a character
							if (letterArray[0].length()==1) {
								// Open a loop that will go checking if the letter the player entered is in the word
								for (int index=0;index<word.length();index++) {
									if (word.charAt(index)==letterArray[0].charAt(0)) {
										// If it is, open another loop which will go checking if the player had already guessed that letter
										boolean found = false;
										int index2=0;
										while (index2<guessed.length && guessed[index2]!=letterArray[0].charAt(0) && !found ){
											if (!Character.isLetter(guessed[index2])) {
												// If he/she had not done so, save the letter in the array 'guessed'
												guessed[guessedCounter] = word.charAt(index);
												// Increment once the variable 'guessedCounter' for a future possible letter
												guessedCounter++;
												// Define the variable 'found' as true so as to get out of the loop
												found = true;
											}
											// Increment the variable 'index2' so as to check the next letter of the array 'guessed'
											index2++;
										}
									}
								}
								// Print the word with only the letters that the player guessed
								for (int index4=0;index4<word.length();index4++) {
									boolean found = false;
									for (int index5=0;index5<guessed.length;index5++) {
										if (guessed[index5]==word.charAt(index4)) {
											System.out.print(word.charAt(index4)+ " ");
											found = true;
										}
									}
									if (!found) {
										System.out.print("_ ");
									}
								}
								// Increment the variable 'flag' so as to ask the next letter
								flag++;
							}
							// If the player entered more than one characters, ask him/her to enter just one
							else {
								System.out.println("Don't cheat, please enter just a letter.");
							}
						}
						else {
							System.out.println("Don't cheat, please enter just a letter.");
						}
					}
					// If the player entered a number, ask him to enter a letter
					else {
						System.out.println("That is not a letter, try it again.");
						sc.nextLine();
					}
					// Print to the player the letters he/she has left
					if (flag == 1) {
						System.out.println("You have two letters left.");
					}
					else if (flag==2){
						System.out.println("You have just a letter left.");
					}
				}
				// Ask to the player a possible word
				System.out.println("It's the time, you have to guess the word.");
				boolean wordEntered=false;
				while (wordEntered==false) {
					String playerWord = sc.nextLine().toLowerCase();
					String[] playerWordArray=playerWord.split(" ");
					if (playerWordArray.length==1) {
						boolean numberFound2=false;
						for (int i=0;i<playerWordArray[0].length();i++) {
							if (playerWordArray[0].charAt(i)=='0'||playerWordArray[0].charAt(i)=='1'||playerWordArray[0].charAt(i)=='2'||playerWordArray[0].charAt(i)=='3'||playerWordArray[0].charAt(i)=='4'||playerWordArray[0].charAt(i)=='5'||playerWordArray[0].charAt(i)=='6'||playerWordArray[0].charAt(i)=='7'||playerWordArray[0].charAt(i)=='8'||playerWordArray[0].charAt(i)=='9') {
								numberFound2=true;
							}
						}
						if (numberFound2==false) {
							wordEntered=true;
							if (playerWordArray[0].equals(word)) {
								System.out.println("Congrats, you won the game.");
							}
							else {
								System.out.println("I'm sorry, you lost the game. The word was " + word);
							}
						}
						else {
							System.out.println("Please, enter a real word.");
						}
					}
					else {
						System.out.println("Please, enter just a word.");
					}
				}
			}
			sc.close();
		}
		else {
			System.out.println("You have to enter your name and a word to play this game.");
		}
	}
}
