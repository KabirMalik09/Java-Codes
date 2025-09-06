import java.util.*;

public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int MAX_CUSTOMERS = 5;
        final int MAX_ITEMS = 10;

        String[][] items = new String[MAX_CUSTOMERS][];

        for (int i = 0; i < MAX_CUSTOMERS; i++) {
            System.out.print("Enter number of items purchased by Customer " + (i + 1) + " (1-10): ");
            int n = sc.nextInt();
            while (n < 1 || n > MAX_ITEMS) {
                System.out.print("Invalid! Enter again (1-10): ");
                n = sc.nextInt();
            }

            items[i] = new String[n];
            for (int j = 0; j < n; j++) {
                System.out.print("Enter item " + (j + 1) + " for Customer " + (i + 1) + ": ");
                items[i][j] = sc.next();
            }
        }

        System.out.println("\n--- Initial Customer Items Summary ---");
        displaySummary(items, MAX_CUSTOMERS, MAX_ITEMS);

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Rearrange items for a customer (split and rotate)");
            System.out.println("2. Swap two customer entries");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
          
                System.out.print("\nEnter customer number to rearrange (1-" + MAX_CUSTOMERS + "): ");
                int custNum = sc.nextInt();
                while (custNum < 1 || custNum > MAX_CUSTOMERS) {
                    System.out.print("Invalid! Enter again (1-" + MAX_CUSTOMERS + "): ");
                    custNum = sc.nextInt();
                }
                int custIdx = custNum - 1;
                int numItems = items[custIdx].length;


                System.out.print("Enter split position (1-" + numItems + "): ");
                int position = sc.nextInt();
                while (position < 1 || position > numItems) {
                    System.out.print("Invalid! Enter again (1-" + numItems + "): ");
                    position = sc.nextInt();
                }
                int idx = position - 1;

               
                String[] custItems = items[custIdx];
                int n = custItems.length;
                for (int i = 0; i < idx; i++) {
                    String temp = custItems[0];
                    for (int j = 0; j < n - 1; j++) {
                        custItems[j] = custItems[j + 1];
                    }
                    custItems[n - 1] = temp;
                }

                System.out.println("\n--- Summary After Rearrangement ---");
                displaySummary(items, MAX_CUSTOMERS, MAX_ITEMS);
            } else if (choice == 2) {
      
                System.out.print("\nEnter two customer numbers to swap (e.g., 1 3): ");
                int swap1 = sc.nextInt();
                int swap2 = sc.nextInt();
                while (swap1 < 1 || swap1 > MAX_CUSTOMERS || swap2 < 1 || swap2 > MAX_CUSTOMERS || swap1 == swap2) {
                    System.out.print("Invalid! Enter again (two different numbers 1-" + MAX_CUSTOMERS + "): ");
                    swap1 = sc.nextInt();
                    swap2 = sc.nextInt();
                }
                String[] temp = items[swap1 - 1];
                items[swap1 - 1] = items[swap2 - 1];
                items[swap2 - 1] = temp;

                System.out.println("\n--- Summary After Swap ---");
                displaySummary(items, MAX_CUSTOMERS, MAX_ITEMS);
            } else if (choice == 3) {
                running = false;
                System.out.println("Exiting the program.");
            } else {
                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }

        sc.close();
    }

    private static void displaySummary(String[][] items, int maxCustomers, int maxItems) {
        System.out.printf("%-10s", "Customer");
        for (int j = 0; j < maxItems; j++) {
            System.out.printf("%10s", "I" + (j + 1));
        }
        System.out.println();

        for (int i = 0; i < maxCustomers; i++) {
            System.out.printf("%-10s", "Cust" + (i + 1));
            for (int j = 0; j < maxItems; j++) {
                if (j < items[i].length) {
                    System.out.printf("%10s", items[i][j]);
                } else {
                    System.out.printf("%10s", "-");
                }
            }
            System.out.println();
        }
    }
}
