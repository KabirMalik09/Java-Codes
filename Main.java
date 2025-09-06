import java.util.Scanner;

abstract class Customer {
    public abstract double getDiscountedBill(double amount);
    public abstract String getCustomerType();
}

class RegularCustomer extends Customer {
    @Override
    public double getDiscountedBill(double amount) {
        return amount - (amount * 0.05);
    }
    @Override
    public String getCustomerType() {
        return "Regular";
    }
}

class PremiumCustomer extends Customer {
    @Override
    public double getDiscountedBill(double amount) {
        return amount - (amount * 0.10);
    }
    @Override
    public String getCustomerType() {
        return "Premium";
    }
}

class VIPCustomer extends Customer {
    @Override
    public double getDiscountedBill(double amount) {
        return amount - (amount * 0.20);
    }
    @Override
    public String getCustomerType() {
        return "VIP";
    }
}

public class Main {   // 👈 Use "Main" for online compilers
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Purchase Amount: Rs. ");
        double purchaseAmount = sc.nextDouble();

        System.out.println("\nSelect Customer Type:");
        System.out.println("1. Regular");
        System.out.println("2. Premium");
        System.out.println("3. VIP");
        System.out.print("Enter choice (1-3): ");
        int choice = sc.nextInt();

        Customer customer;

        switch (choice) {
            case 1 -> customer = new RegularCustomer();
            case 2 -> customer = new PremiumCustomer();
            case 3 -> customer = new VIPCustomer();
            default -> {
                System.out.println("Invalid choice!");
                sc.close();
                return;
            }
        }

        double finalBill = customer.getDiscountedBill(purchaseAmount);
        double discount = purchaseAmount - finalBill;

        System.out.println("\n=== Invoice ===");
        System.out.println("Customer Type: " + customer.getCustomerType());
        System.out.println("Original Amount: Rs. " + purchaseAmount);
        System.out.println("Discount: Rs. " + discount);
        System.out.println("Final Bill: Rs. " + finalBill);

        sc.close();
    }
}