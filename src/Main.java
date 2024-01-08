import java.util.*;

public class Main {
    public static List<UserInfo> usersList = new ArrayList<>();

    public static void main(String[] args) {
        CreateAcc1.accInfo();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("What do you want to do today? Create account, Login to account, Deposit money to your account or Withdraw money from your account, Check balance of your accounts or Transfer between them");
            String action = input.nextLine();
            if (action.equals("Create account")) {
                CreateAcc1.accInfo();
            } else if (action.equals("Login to account")) {
                CreateAcc1.login();
            } else if (action.equals("Deposit money")) {
                CreateAcc1.deposit();
            } else if (action.equals("Withdraw money")) {
                CreateAcc1.withdraw();
            } else if (action.equals("Check balance")) {
                CreateAcc1.checkBalance();
            } else if (action.equals("Transfer")) {
                CreateAcc1.transfer();
            } else {
                System.out.println("Invalid request has been made, please try again");

            }

        }
    }
}