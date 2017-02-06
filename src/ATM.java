import java.util.Scanner;

/**
 * Created by BHarris on 2/1/17.
 * <p>
 * This is a bank atm that allows you to deposit and withdraw money, and get current balances.
 */

public class ATM {
    private final double DEFAULT_VAL = 100;
    private String name;
    private Bank bank = new Bank();

    public void getName(Scanner scanner) throws Exception {
        System.out.println("Welcome to the ATM, please Enter your name: ");
        this.name = scanner.nextLine();
        if(!bank.isInBankAccount(this.name)){
            System.out.println("No account, Would you like to make an account?[y/n]");
            String answer = scanner.nextLine().toLowerCase();
            if(answer.equals("y")){
                System.out.print("Enter your name you will log in with: ");
                this.name = scanner.nextLine();
                bank.addBankAccount(this.name, DEFAULT_VAL);

            } else getName(scanner);
        }
    }

    //sysAdmin comes defaulted, if you login to it you can run "exit" to shut down the program.
    public void transaction(Scanner response) throws Exception {
        while (true) {
            System.out.printf("Welcome %s,", this.name);
            System.out.println(" Please Enter 1. Check my balance, 2. Withdraw Funds 3.  Add Funds or 4. Cancel 5.) Close Account");
            String currentResponse = response.nextLine().toLowerCase();

            if (currentResponse.contains("1") || currentResponse.contains("balance")) {
                System.out.println("Your current balance is $" + bank.getMoney(this.name) + "\n");

            } else if (currentResponse.contains("2") || currentResponse.contains("withdraw")) {
                takeMoney(response);

            } else if (currentResponse.contains("3") || currentResponse.contains("add")) {
                addMoney(response);

            } else if (currentResponse.contains("4") || currentResponse.toLowerCase().contains("cancel")) {
                checkCancelResponse(response);


            } else if ((currentResponse.contains("5") || currentResponse.toLowerCase().contains("delete"))) {
                bank.removeAccount(this.name);
                getName(response);

            } else if ((currentResponse.equals("exit") && this.name.equals("sysAdmin"))){
                System.exit(0);
            }else {
                throw new Exception("That is not a logical response. Please Enter a [1,2,3,4, or 5].");
            }

        }
    }

    public void checkCancelResponse(Scanner response) throws Exception {
        System.out.println("Thank you " + this.name + ", Please come again. Balance: $" + bank.getMoney(this.name));
        System.out.println("Would you like to login to another account? [y,n]");
        String resp2 = response.nextLine().toLowerCase();

        if(resp2.equals("y")){
            getName(response);
        }else{
            bank.printUsersAndBalance();
            getName(response);
        }
    }


    public double addMoney(Scanner response) {
        System.out.print("How much money? ");
        double money = Double.parseDouble(response.nextLine());
        if (money > 0) {
            bank.addMoney(this.name, money);
        }
        System.out.println("Your current Balance is: " + bank.getMoney(this.name));
        return bank.getMoney(this.name);
    }

    public double takeMoney(Scanner response) {
        System.out.print("How much money? ");
        double money = Double.parseDouble(response.nextLine());
        if (bank.getMoney(this.name) - money > 0 && money > 0) {
            bank.withdrawMoney(this.name, money);
            System.out.println("Your current balance is $" + bank.getMoney(this.name) + "\n");
            return bank.getMoney(this.name);
        }
        System.out.println(notEnoughMoney());
        return bank.getMoney(this.name);
    }

    public String notEnoughMoney() {
        return "Not enough money";
    }

}
