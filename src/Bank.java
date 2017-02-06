import java.util.HashMap;

/**
 * Created by BHarris on 2/2/17.
 *
 * The bank account class takes care of the adding, subtracting and checking if a user is in a bank account.  A user can
 * also close their account by removing the user from the hashmap.
 */
public class Bank {
    //I feel that the bankAccounts should be held at the bank, not inside the ATM.  The ATM calls the bank to get info.
    private HashMap<String, Double> bankAccounts = new HashMap<>();

    public Bank(){
        bankAccounts.put("sysAdmin", 0.00);
    }

    public void addBankAccount(String name, double money){
        bankAccounts.put(name, money);
    }

    public boolean isInBankAccount(String name){
        return bankAccounts.containsKey(name);
    }

    public void addMoney(String name, double money){
        bankAccounts.put(name, bankAccounts.get(name) + money);
    }

    public void withdrawMoney(String name, double money) {
        bankAccounts.put(name, bankAccounts.get(name) - money);
    }

    public double getMoney(String name) {
        return bankAccounts.get(name);
    }

    public void removeAccount(String name){
        bankAccounts.remove(name);
    }

    public void printAllUsers(){
        System.out.println(bankAccounts);
    }

    //Since sysAdmin isnt really a true user of the bank, it won't be printed.
    public void printUsersAndBalance() {
        System.out.println("-----------------------");
        for (String name : bankAccounts.keySet()) {
            String key = name.toString();
            Double value = bankAccounts.get(name);
            if(!key.equals("sysAdmin")){
                System.out.printf("%-8s", key + ": $" + value);
                System.out.println();
            }

        }
        System.out.println("-----------------------");
    }
}
