import java.util.Scanner;

public class ATMinterference {
    private double balance;

    public ATMinterference(double firstBalance) {
        this.balance = firstBalance;
    }

    // Method to display the ATM menu
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("what you want: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    checkYourBalance();
                    break;
                case 2:
                    depositMoney(sc);
                    break;
                case 3:
                    withdrawMoney(sc);
                    break;
                case 4:
                    System.out.println("Exiting from ATM. Thank you!");
                    break;
                default:
                    System.out.println("choice is invalid. Please try again.");
            }
        } while (option < 5);

        sc.close();
    }

    // Method to check the current balance
    private void checkYourBalance() {
        System.out.println(" your Current balance is : $" + balance);
    }

    // Method to deposit an amount into the account
    private void depositMoney(Scanner scanner) {
        System.out.print("Enter your deposit amount: ");
        double Moneyamount = scanner.nextDouble();
        if (Moneyamount > 0) {
            balance += Moneyamount;
            System.out.println("Deposit  successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw an amount from the account
    private void withdrawMoney(Scanner sc) {
        System.out.print("Enter withdrawal amount: ");
        double Moneyamount = sc.nextDouble();
        if (Moneyamount > 0 && Moneyamount <= balance) {
            balance -= Moneyamount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else if (Moneyamount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public static void main(String[] args) {
        ATMinterference atm = new ATMinterference(500); // Initial balance of $500
        atm.showMenu();
    }
}
