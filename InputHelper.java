import java.util.Scanner;

/**
 * Helper class for safe console input.
 * Keeps asking until the user enters a valid whole number.
 */
public class InputHelper {
    private static final Scanner SC = new Scanner(System.in);

    /** Reads a whole number. Repeats until the input is valid. */
    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!SC.hasNextLine()) {
                System.out.println("\nNo more input. Exiting program.");
                System.exit(0);
            }
            String line = SC.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    /** Reads a whole number that must be between min and max (inclusive). */
    public static int readInt(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Please enter a value between " + min + " and " + max + ".");
        }
    }
}
