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
    private int[] auditLog = new int[3];
    private String pin;

    public ATM() {
        this.currentBalance = DEFAULT_VAL;
    }

    public ATM(double money) {
        this.currentBalance = money;

    }

    public void getName(Scanner name) {
        System.out.println("Welcome to the ATM, please Enter your name: ");

        while (true) {
            String userName = name.nextLine();
            if (!userName.isEmpty()) {
                this.name = userName;
                break;
            }
        }
        setPin(name);
    }

    public void transaction(Scanner response) throws Exception {
        while (true) {
            System.out.println("Please Enter 1. Check my balance, 2. Withdraw Funds 3.  Add Funds or 4. Cancel");
            String currentResponse = response.nextLine();

            if (currentResponse.equals("1") || currentResponse.equals("1. Check my balance")) {
                System.out.println("Your currentBalance is $" + this.currentBalance + "\n");
                auditLog[0] += 1;

            } else if (currentResponse.equals("2") || currentResponse.equals("2. Withdraw Funds")) {
                takeMoney(response);

            } else if (currentResponse.equals("3") || currentResponse.equals("3. Add Funds")) {
                addMoney(response);

            } else if (currentResponse.equals("4") || currentResponse.toLowerCase().contains("cancel")) {
                System.out.println("Thank you " + this.name + ", Please come again. Balance: $" + this.currentBalance);
                showAuditLog(response);
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
            currentBalance += money;
        }
        System.out.println(currentBalance + "\n");
        auditLog[2] += 1;
        ;
        return this.currentBalance;
    }

    public double takeMoney(Scanner response) {
        System.out.print("How much money? ");
        double money = Double.parseDouble(response.nextLine());
        if (this.currentBalance - money > 0) {
            this.currentBalance -= money;
            System.out.println(this.currentBalance + "\n");
            auditLog[1] += 1;
            return this.currentBalance;
        }
        System.out.println(notEnoughMoney());
        auditLog[1] += 1;
        return this.currentBalance;
    }

    public String notEnoughMoney() {
        return "Not enough money";
    }

    public void setPin(Scanner pin) {
        while (true) {
            System.out.println("Enter a 4 character pin");
            String userPin = pin.nextLine();
            if (userPin.length() == 4) {
                this.pin = userPin;
                break;
            }
        }
    }

    public String getPin() {
        return this.pin;
    }


    public void showAuditLog(Scanner response) {
        System.out.println("To see audit log, enter your pin, you have 3 chances");
        int count = 3;
        while (count > 0) {
            String userResp = response.nextLine();
            if (!this.pin.equals(userResp)) {
                count--;
                if (count == 0) {
                    System.out.println("Sorry, out of tries.");
                    System.exit(0);
                }
                System.out.println("chances left: " + count);
            } else {
                printAuditLog();
            }
        }
    }

    public void printAuditLog() {

        System.out.println("*************************************");
        System.out.printf("*********%s AUDIT LOG***********\n", this.name.toUpperCase() + "'S");
        System.out.println("*************************************");
        for (int i = 0; i < auditLog.length; i++) {
            switch (i) {
                case 0:
                    System.out.printf("you have looked at current balance %d time(s)\n", auditLog[0]);
                    break;
                case 1:
                    System.out.printf("you have withdrawn %d time(s)\n", auditLog[1]);
                    break;
                case 2:
                    System.out.printf("You have deposited money %d time(s)\n", auditLog[2]);
                    break;
            }
        }
    }
}
