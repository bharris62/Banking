import java.util.HashMap;

/**
 * Created by BHarris on 2/2/17.
 *
 * The bank account class takes care of the adding, subtracting and checking if a user is in a bank account.  A user can
 * also close their account by removing the user from the hashmap.
 */
public class BankAccount {
    private HashMap<String, Double> bankAccounts = new HashMap<>();

    public BankAccount(){}

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

}
