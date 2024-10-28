import java.time.Year;
import java.util.Scanner;

public class Game {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		// ----- Write your code below

		System.out.println("__ _ ___ __ __\r\n" + //
						"/ /__ ____________ _( )_____ / | ____/ / _____ ____ / /___ __________\r\n" + //
						"__ / / _ \\/ ___/ ___/ / / /// ___/ / /| |/ __ / | / / _ \\/ __ \\/ __/ / / / ___/ _ \\\r\n" + //
						"/ /_/ / __/ / / / / /_/ / (__ ) / ___ / /_/ /| |/ / __/ / / / /_/ /_/ / / / __/\r\n" + //
						"\\____/\\___/_/ /_/ \\__, / /____/ /_/ |_\\__,_/ |___/\\___/_/ /_/\\__/\\__,_/_/ \\___/\r\n" + //
						"/____/\r\n" + //
						"by: Thanasis\n");

		System.out.print("What is your name?: ");
		String name = scanner.nextLine();
		System.out.println("Hi " + name + "!");

		System.out.print("When were you born?: ");
		int birthYear = scanner.nextInt();
		System.out.println("You are " + calculateAge(birthYear) + " years old.\n");

		System.out.println("You are standing in an abandoned university office. There are neither students\r\n" + //
						"nor teachers around you. There's a table in front of you with various papers,\r\n" + //
						"pens, a small puzzle toy, and a calculator.\r\n" + //
						"A large window shows an empty office building; there are no Zombies in the empty\r\n" + //
						"building (as far as you can tell). Behind you is a dark and mysterious door that\r\n" + //
						"leads to a well-lit corridor with a fireproof ceiling and floor. You feel a\r\n" + //
						"sense of Wi-Fi around you, the grinding of an LCD operated coffee machine can be\r\n" + //
						"heard in the distance. You are not thirsty, but you rather have a craving for\r\n" + //
						"justice.\n");

		System.out.print("What would you like to do?: ");
		String action = scanner.nextLine();
		System.out.println(action);

		// ----- Write your code above
	}

	public static int calculateAge(int birthYear) {
		return Year.now().getValue() -birthYear;
	}
}