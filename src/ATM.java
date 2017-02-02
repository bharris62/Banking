import java.util.Scanner;

/**
 * Created by BHarris on 2/1/17.
 * <p>
 * This is a bank atm that allows you to deposit and withdraw money, and get current balances.
 */
public class ATM {
    private double currentBalance;
    private String name;
    private final double DEFAULT_VAL = 100;
    private BankAccount bank = new BankAccount();

    public ATM() {
        this.currentBalance = DEFAULT_VAL;
    }

    public void getName(Scanner scanner) {
        System.out.println("Welcome to the ATM, please Enter your name: ");
        String userName = scanner.nextLine();
        bank.addBankAccount(userName, DEFAULT_VAL);
    }

    public void transaction(Scanner response) throws Exception {
        while (true) {
            System.out.println("Please Enter 1. Check my balance, 2. Withdraw Funds 3.  Add Funds or 4. Cancel");
            String currentResponse = response.nextLine();

            if (currentResponse.equals("1") || currentResponse.equals("1. Check my balance")) {
                System.out.println("Your currentBalance is $" + this.currentBalance + "\n");

            } else if (currentResponse.equals("2") || currentResponse.equals("2. Withdraw Funds")) {
                takeMoney(response);

            } else if (currentResponse.equals("3") || currentResponse.equals("3. Add Funds")) {
                addMoney(response);

            } else if (currentResponse.equals("4") || currentResponse.toLowerCase().contains("cancel")) {
                System.out.println("Thank you " + this.name + ", Please come again. Balance: $" + this.currentBalance);
                break;
            } else {
                throw new Exception("That is not a logical response. Please Enter a [1,2,3,4].");
            }
        }
    }


    public double addMoney(Scanner response) {
        System.out.print("How much money? ");
        double money = Double.parseDouble(response.nextLine());
        if (money > 0) {
            bank.addMoney(this.name, money);
        }
        return currentBalance;
    }

    public double takeMoney(Scanner response) {
        System.out.print("How much money? ");
        double money = Double.parseDouble(response.nextLine());
        if (this.currentBalance - money > 0) {
            this.currentBalance -= money;
            System.out.println(this.currentBalance + "\n");
            return this.currentBalance;
        }
        System.out.println(notEnoughMoney());
        return this.currentBalance;
    }

    public String notEnoughMoney() {
        return "Not enough money";
    }


}
