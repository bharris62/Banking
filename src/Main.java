import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();
        atm.getName(scanner);

//        while(true) {
//            try {
//                atm.transaction(scanner);
//                break;
//            } catch (Exception e) {
//                System.out.println("Your error: " + e.getMessage());
//            }
//        }
    }
}
