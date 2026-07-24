package InputHelper;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getValidString(String message) {
        while (true) {

            System.out.println(message);
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Invalid Input");
        }

    }
    public static int getValidInt(String message) {

        while (true) {

            System.out.print(message);

            try {

                int number = Integer.parseInt(scanner.nextLine());

                if (number > 0) {
                    return number;
                }

                System.out.println("Number must be greater than 0!");

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number!");

            }
        }
    }
}
