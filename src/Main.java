import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static HashMap<String, Integer> inventory = new HashMap<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        addItems();
        promptMenu();
    }

    private static void promptMenu() {
        while (true) {
            printToConsole("""
                    ---------- MENU ----------
                    1... Add item(s)
                    2... Remove item(s)
                    3... Show inventory
                    
                    0... Quit
                    """);
            int userInput = input.nextInt();
            input.nextLine();
            switch (userInput) {
                case 1:
                    addItems();
                    break;
                case 2:
                    removeItems();
                    break;
                case 3:
                    printInventory();
                    waitForUser();
                    break;
                default:
                    return;
            }
        }
    }

    private static void removeItems() {
        printInventory();
        printToConsole("\nWhich item do you want to remove?", false);
        System.out.print("Choice: ");
        String removeItem = input.nextLine();
        inventory.remove(removeItem.toLowerCase());
    }

    private static void printInventory() {
        printToConsole("---------- INVENTORY ----------");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            String item = entry.getKey();
            if (!item.isEmpty()) {
                item = item.substring(0, 1).toUpperCase() + item.substring(1);
            }
            printToConsole(" - " + entry.getValue() + " x " + item, false);
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
            itemName = input.nextLine().toLowerCase();
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