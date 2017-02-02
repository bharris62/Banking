import java.util.HashMap;
import java.util.Map;

/**
 * Created by BHarris on 2/2/17.
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
    //test method
    public void printAllUsers(){
        System.out.println(bankAccounts);
    }

    public void removeAccount(String name){
        bankAccounts.remove(name);
    }



}
