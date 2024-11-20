import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
    private int balance;
    private int pin;
    private List<String> transactionHistory;

    public ATM(int balance, int pin) {
        this.balance = balance;
        this.pin = pin;
        this.transactionHistory = new ArrayList<>();
    }

    public void displayMenu() {
        System.out.println("1. Check balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Change Pin");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
    }

    public void deposit(int amount) {
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    public void withdraw(int amount) {
        if (balance < amount) {
            System.out.println("Insufficient Funds!");
            return;
        }
        balance -= amount;
        transactionHistory.add("Withdrew: " + amount);
    }

    public int getBalance() {
        return balance;
    }

    public boolean validatePin(int pin) {
        return this.pin == pin;
    }

    public void changePin(int newPin) {
        pin = newPin;
        System.out.println("Pin changed successfully.");
    }

    public void displayTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions to display.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(1000, 1234); 

        System.out.print("Enter your pin: ");
        int pin = scanner.nextInt();

        if (atm.validatePin(pin)) {
            int option = 0;
            while (option != 6) {  
                atm.displayMenu();
                System.out.print("Choose an option: ");
                option = scanner.nextInt();
                
                switch (option) {
                    case 1: 
                        System.out.println("Balance: " + atm.getBalance());
                        break;

                    case 2:
                        System.out.print("Enter Amount to Deposit: ");
                        int depositAmount = scanner.nextInt();
                        atm.deposit(depositAmount);
                        break;

                    case 3: 
                        System.out.print("Enter Amount to Withdraw: ");
                        int withdrawAmount = scanner.nextInt();
                        atm.withdraw(withdrawAmount);
                        break;

                    case 4: 
                        System.out.print("Enter New Pin: ");
                        int newPin = scanner.nextInt();
                        atm.changePin(newPin);
                        break;

                    case 5: 
                        atm.displayTransactionHistory();
                        break;

                    case 6: 
                        System.out.println("Thanks for visiting!");
                        break;

                    default:
                        System.out.println("Invalid option. Please choose again.");
                        break;
                }
            }
        } else {
            System.out.println("Invalid PIN entered!");
        }

        scanner.close();
    }
}
