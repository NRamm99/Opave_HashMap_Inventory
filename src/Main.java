import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static HashMap<String, Integer> inventory = new HashMap<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        addItems();
        printInventory();
    }

    private static void printInventory() {
        printToConsole("---------- INVENTORY ----------");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            printToConsole(" - " + entry.getValue() + " x " + entry.getKey(), false);
        }
    }

    private static void addItems() {
        printToConsole("how many items do you wish to add?");
        System.out.print("Choice: ");
        int amountItems = input.nextInt();
        input.nextLine();

        String itemName;
        int itemQuantity;
        for (int n = 0; n < amountItems; n++) {
            printToConsole("Enter the name of item #" + (n + 1));
            System.out.print("Choice: ");
            itemName = input.nextLine();
            printToConsole("Enter the amount of " + itemName + "s you want to add to your inventory.");
            System.out.print("Choice: ");
            itemQuantity = input.nextInt();
            input.nextLine();
            inventory.put(itemName, itemQuantity);
        }
    }

    public static void clearConsole() {
        for (int n = 0; n < 20; n++) {
            System.out.println();
        }
    }

    public static void waitForUser() {
        System.out.println("Press enter to continue...");
        input.nextLine();
    }

    public static void printToConsole(String text, boolean clear) {
        if (clear) {
            clearConsole();
        }
        System.out.println(text);
    }

    public static void printToConsole(String text) {
        printToConsole(text, true);
    }
}