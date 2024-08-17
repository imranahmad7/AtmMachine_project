import java.util.ArrayList;
import java.util.Scanner;

// Class to handle ATM functionalities
class Atm {
    private float balance; // Current balance of the account
    private int pin = 1105; // Default PIN
    private ArrayList<String> transactionHistory = new ArrayList<>(); // Transaction history

    // Method to check the PIN and proceed to the main menu if correct
    public void checkPin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter PIN: ");
        int enteredPin = sc.nextInt();
        if (enteredPin == pin) {
            menu();
        } else {
            System.out.println("Invalid PIN. Please try again.");
            checkPin(); // Recursive call to re-enter PIN
        }
    }

    // Main menu to choose different ATM functions
    private void menu() {
        System.out.println("Enter your choice: ");
        System.out.println("1. Check Account Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Change PIN");
        System.out.println("5. View Transaction History");
        System.out.println("6. EXIT");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdrawMoney();
                break;
            case 3:
                depositMoney();
                break;
            case 4:
                changePin();
                break;
            case 5:
                viewTransactionHistory();
                break;
            case 6:
                System.out.println("Exiting... Thank you for using ATM.");
                break;
            default:
                System.out.println("Invalid choice. Please select again.");
                menu();
                break;
        }
    }

    // Method to check and display the account balance
    private void checkBalance() {
        System.out.println("Current Balance: " + balance);
        menu();
    }

    // Method to withdraw money from the account
    private void withdrawMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to withdraw:");
        float amount = sc.nextFloat();
        if (amount > balance) {
            System.out.println("Insufficient Balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Amount withdrawn: " + amount);
            transactionHistory.add("Withdrawn: " + amount);
        }
        menu();
    }

    // Method to deposit money into the account
    private void depositMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to deposit:");
        float amount = sc.nextFloat();
        balance += amount;
        System.out.println("Deposit successful. Amount deposited: " + amount);
        transactionHistory.add("Deposited: " + amount);
        menu();
    }

    // Method to change the account PIN
    private void changePin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your new PIN:");
        int newPin = sc.nextInt();
        pin = newPin;
        System.out.println("PIN changed successfully.");
        menu();
    }

    // Method to view transaction history
    private void viewTransactionHistory() {
        System.out.println("Transaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
        menu();
    }
}

// Main class to run the ATM simulation
public class AtmMachine1{
    public static void main(String[] args) {
        Atm atm = new Atm();
        atm.checkPin();
    }
}
