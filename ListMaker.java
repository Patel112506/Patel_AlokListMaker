import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String menuChoice;
        do {
            displayList();
            menuChoice = Safe_Input.getRegExString(console, "Choose an option: [A]dd, [D]elete, [I]nsert, [P]rint, [Q]uit", "[AaDdIiPpQq]");
            switch (menuChoice.toUpperCase()) {
                case "A":
                    addItem(console);
                    break;
                case "D":
                    deleteItem(console);
                    break;
                case "I":
                    insertItem(console);
                    break;
                case "P":
                    displayList();
                    break;
                case "Q":
                    if (Safe_Input.getYNConfirm(console, "Are you sure you want to quit?")) {
                        System.out.println("Exiting the program.");
                        return;
                    }
                    break;
            }
        } while (true);
    }

    private static void displayList() {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ": " + list.get(i));
            }
        }
    }

    private static void addItem(Scanner console) {
        String item = Safe_Input.getNonZeroLenString(console, "Enter the item to add:");
        list.add(item);
    }

    private static void deleteItem(Scanner console) {
        if (list.isEmpty()) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }
        int itemNumber = Safe_Input.getRangedInt(console, "Enter the item number to delete:", 1, list.size());
        list.remove(itemNumber - 1);
    }

    private static void insertItem(Scanner console) {
        if (list.isEmpty()) {
            System.out.println("List is empty, use Add to add the first item.");
            return;
        }
        int position = Safe_Input.getRangedInt(console, "Enter the position to insert at:", 1, list.size() + 1);
        String item = Safe_Input.getNonZeroLenString(console, "Enter the item to insert:");
        list.add(position - 1, item);
    }
}
