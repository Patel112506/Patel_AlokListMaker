import java.util.Scanner;

public class Safe_Input {

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = 0;
        boolean valid = false;
        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                if (retVal >= low && retVal <= high) {
                    valid = true;
                } else {
                    System.out.println("Error: Input out of range.");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter an integer.");
                pipe.next(); // Clear the invalid input
            }
        } while (!valid);
        return retVal;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String input;
        boolean valid = false;
        boolean retVal = false;

        do {
            System.out.print(prompt + " [Y/N]: ");
            input = pipe.next();
            if (input.equalsIgnoreCase("Y")) {
                retVal = true;
                valid = true;
            } else if (input.equalsIgnoreCase("N")) {
                retVal = false;
                valid = true;
            } else {
                System.out.println("Error: Please enter Y or N.");
            }
        } while (!valid);
        return retVal;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String retVal = "";
        boolean valid = false;

        do {
            System.out.print(prompt + ": ");
            retVal = pipe.next();
            if (retVal.matches(regEx)) {
                valid = true;
            } else {
                System.out.println("Error: Invalid input.");
            }
        } while (!valid);
        return retVal;
    }

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retVal = "";
        boolean valid = false;

        do {
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine().trim();
            if (retVal.length() != 0) {
                valid = true;
            } else {
                System.out.println("Error: Input cannot be empty.");
            }
        } while (!valid);
        return retVal;
    }
}
