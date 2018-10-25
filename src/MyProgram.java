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
		System.out.println(randomSurname);
		System.out.println("Welcome to the famous HANGMAN game.");
		System.out.println("You will have to guess which surname of the people in class is hidden between the voids.");
		System.out.println("For this, you will be able to enter 3 letters that may appear in the surname, or not. After this, you will only have a chance to guess the surname and win the game.");
		System.out.println("Good luck, start with the first letter.");
		char checked[]=new char[randomSurname.length()];
		int guessedCounter=0;
		int flag=0;
		while (flag<3) {
			if (!sc.hasNextInt()) {
				String possibleLetter=sc.next();
				if (possibleLetter.length()==1) {
					int index=0;
					while (index<randomSurname.length()) {
						if (randomSurname.charAt(index)==possibleLetter.charAt(0)) {
							int index2=0;
							boolean found = false;
							while (index2<checked.length && checked[index2]!=possibleLetter.charAt(0) && !found ){
								if (checked[index2]==checked[3]) {
									checked[guessedCounter] = randomSurname.charAt(index);
									guessedCounter++;
									found = true;
								}
								index2++;
							}
						}
						index++;
					}
				}
				else {
					System.out.println("Don't cheat, please enter just a letter.");
				}
			}
			else {
				System.out.println("That is not a letter, try it again.");
				// Jump the token '/n'
				sc.next();
			}
			int index3=0;
			while (index3<randomSurname.length()) {
				boolean found = false;
				int index4=0;
				while (index4<checked.length) {
					if (checked[index4]==randomSurname.charAt(index3)) {
						System.out.print(randomSurname.charAt(index3)+ " ");
						found = true;
					}
					index4++;
				}
				if (!found) {
					System.out.print("_ ");
				}
				index3++;
			}
			flag++;
			if (flag == 1) {
				System.out.println("You have two letters left.");
			}
			else if (flag==2){
				System.out.println("You have just a letter left.");
			}
		}
		System.out.println("It's the time, you have to guess the surname.");
		String userRandom = sc.next();
		if (userRandom.equals(randomSurname)) {
			System.out.println("Congrats, you won the game.");
		}
		else {
			System.out.println("I'm sorry, you lost the game.");
		}
		sc.close();
	}
}