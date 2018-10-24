import java.util.Scanner;
import java.util.Random;
public class MyProgram {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// Save into an array all the surnames of the people in class
		String[] surnames = {"lazkano","intxausti","artola","alberdi","lekubide"};
		// Take randomly a surname between them
		System.out.println(surnames.length);
		System.out.println(surnames[new Random().nextInt(surnames.length)]);
		sc.close();
	}
}