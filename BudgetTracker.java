import java.util.ArrayList;
import java.util.Scanner;

class Transaction {
    String type;
    String description;
    double amount;

    public Transaction(String type, String description, double amount) {
        this.type = type;
        this.description = description;
        this.amount = amount;
    }

    public String toString() {
        return type + ": " + description + " - ₹" + amount;
    }
}

public class BudgetTracker {
    static ArrayList<Transaction> transactions = new ArrayList<>();
    static double balance = 0;

    public static void addTransaction(String type, String description, double amount) {
        if (type.equals("Expense")) {
            amount = -amount;
        }
        transactions.add(new Transaction(type, description, Math.abs(amount)));
        balance += amount;
    }

    public static void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Budget Tracker ---");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter income description: ");
                    String incDesc = sc.nextLine();
                    System.out.print("Enter income amount: ");
                    double incAmt = sc.nextDouble();
                    addTransaction("Income", incDesc, incAmt);
                    break;

                case 2:
                    System.out.print("Enter expense description: ");
                    String expDesc = sc.nextLine();
                    System.out.print("Enter expense amount: ");
                    double expAmt = sc.nextDouble();
                    addTransaction("Expense", expDesc, expAmt);
                    break;

                case 3:
                    System.out.println("Current Balance: ₹" + balance);
                    break;

                case 4:
                    showTransactions();
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
