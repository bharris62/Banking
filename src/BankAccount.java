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
        for(String key : bankAccounts.keySet()){
            System.out.println(key);
        }
    }
    //test method
    public void printUsersMoney(){
        for(double value : bankAccounts.values()){
            System.out.println(value);
        }
    }


//    public static void main(String[] args) {
//        BankAccount bank = new BankAccount();
//
//        bank.addBankAccount("Blake", 100);
//        System.out.println(bank.isInBankAccount("Blake"));
//        System.out.println(bank.isInBankAccount("John"));
//        bank.addMoney("Blake", 50);
//        System.out.println(bank.getMoney("Blake"));
//        bank.withdrawMoney("Blake", 50);
//        System.out.println(bank.getMoney("Blake"));
//        bank.printAllUsers();
//
//    }
}
