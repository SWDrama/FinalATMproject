import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateAcc1 {

    public static List<UserInfo> usersList = new ArrayList<>();
    public static UserInfo loggedInUser;

    public static void main(String[] args) {

    }

    public static void accInfo() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first name please");
        String firstname = input.nextLine();

        System.out.println("Enter you Surname please");
        String secondname = input.nextLine();

        System.out.println("Enter a valid email address please");
        String email = input.nextLine();

        System.out.println("Enter a password please");
        String password = input.nextLine();



        UserInfo user = new UserInfo();
        user.firstName = firstname;
        user.secondName = secondname;
        user.email = email;
        user.password = password;

        usersList.add(user);


        System.out.println("Registration successful!");
    }

    public static void login() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your email address to log in");
        String enteredEmail = input.nextLine();

        System.out.println("Enter your password");
        String enteredPassword = input.nextLine();

        for (int i = 0; i < usersList.size(); i++ ) {
            var user = usersList.get(i);
            if (enteredEmail.equals(user.email)) {
                if (enteredPassword.equals(user.password)) {
                    System.out.println("Welcome" + " " + user.firstName + " " + user.secondName);
                    loggedInUser = user;
                    break;
                } else System.out.println("incorrect password, please try again");
            } else System.out.println("Incorrect email, try again");
        }

        }

    public static void deposit() {

        //checking if user is logged in before proceeding with operation
        if (loggedInUser == null) {
            System.out.println("You need to login first");
            return;
        }

        Scanner input = new Scanner(System.in);

        System.out.println("Choose an account you want to deposit on: Small business account, Community account or Client account");
        String accType = input.nextLine();

        System.out.println("Enter amount of money you want to deposit");
        double moneyIn = input.nextDouble();

        if (accType.equalsIgnoreCase("Small business account"))
            loggedInUser.smallBusinessBalance = loggedInUser.smallBusinessBalance + moneyIn;
        else if (accType.equalsIgnoreCase("Community account"))
            loggedInUser.communityBalance = loggedInUser.communityBalance + moneyIn;
        else if (accType.equalsIgnoreCase("Client account"))
            loggedInUser.clientBalance = loggedInUser.clientBalance +moneyIn;
        else
            System.out.println("Incorrect type of account, please try again");

        CreateAcc1.checkBalance();
    }

    public static void withdraw() {

        if (loggedInUser == null) {
            System.out.println("You need to login first");
            return;
        }
        Scanner input = new Scanner(System.in);

        System.out.println("Choose an account you want to withdraw money from: Small business account, Community account or Client account");
        String accType = input.nextLine();

        System.out.println("Enter amount of money you want to withdraw");
        double moneyOut = input.nextDouble();

        if (accType.equalsIgnoreCase("Small business account")) {
            if (loggedInUser.smallBusinessBalance - moneyOut < -1000) {
                System.out.println("In Small business account you can overdraft up to £1000");
            } else {
                System.out.println("You have successfully withdrawn money");
                loggedInUser.smallBusinessBalance = loggedInUser.smallBusinessBalance - moneyOut;
            }

        } else if (accType.equalsIgnoreCase("Community account")) {
            if (loggedInUser.communityBalance - moneyOut < -2500) {
                System.out.println("In Community account you can overdraft up to £2500");

            } else {
                System.out.println("You have successfully withdrawn money");
                loggedInUser.communityBalance = loggedInUser.communityBalance - moneyOut;
            }

        } else if (accType.equalsIgnoreCase("Client account")) {
            if (loggedInUser.clientBalance - moneyOut < -1500) {
                System.out.println("In Client account you can overdraft up to £1500");

            } else {
                System.out.println("You have successfully withdrawn money");
                loggedInUser.clientBalance = loggedInUser.clientBalance - moneyOut;
            }
        } else
            System.out.println("Incorrect type of account, please try again");

        CreateAcc1.checkBalance();
    }

    public static void transfer() {

        if (loggedInUser == null) {
            System.out.println("You need to login first");
            return;
        }
        Scanner input = new Scanner(System.in);

        System.out.println("Choose an account you want to transfer money from: Small business account, Community account or Client account");
        String accType = input.nextLine();

        if (accType.equalsIgnoreCase("Small business account")) {
            System.out.println("Choose account to transfer money to: Community account or Client account");
            String transferTo = input.nextLine();

            System.out.println("How much money do you want to transfer?");
            double transferAmount = input.nextDouble();

            loggedInUser.smallBusinessBalance = loggedInUser.smallBusinessBalance - transferAmount;

            if (transferTo.equalsIgnoreCase("Community account")) {
                loggedInUser.communityBalance = loggedInUser.communityBalance + transferAmount;
            } else if (transferTo.equalsIgnoreCase("Client account")) {
                loggedInUser.clientBalance = loggedInUser.clientBalance + transferAmount;
            } else
                System.out.println("Incorrect type of account, please try again");
        }
        else if (accType.equalsIgnoreCase("Community account")) {
            System.out.println("Choose account to transfer money to: Small business account or Client account");
            String transferTo = input.nextLine();

            System.out.println("How much money do you want to transfer?");
            double transferAmount = input.nextDouble();

            loggedInUser.communityBalance = loggedInUser.communityBalance - transferAmount;

            if (transferTo.equalsIgnoreCase("Small business account")) {
                loggedInUser.smallBusinessBalance = loggedInUser.smallBusinessBalance + transferAmount;
            } else if (transferTo.equalsIgnoreCase("Client account")) {
                loggedInUser.clientBalance = loggedInUser.clientBalance + transferAmount;
            } else
                System.out.println("Incorrect type of account, please try again");
        }
        else if (accType.equalsIgnoreCase("Client account")) {
            System.out.println("Choose account to transfer money to: Small business account or Community account");
            String transferTo = input.nextLine();

            System.out.println("How much money do you want to transfer?");
            double transferAmount = input.nextDouble();

            loggedInUser.clientBalance = loggedInUser.clientBalance - transferAmount;

            if (transferTo.equalsIgnoreCase("Small business account")) {
                loggedInUser.smallBusinessBalance = loggedInUser.smallBusinessBalance + transferAmount;
            } else if (transferTo.equalsIgnoreCase("Community account")) {
                loggedInUser.communityBalance = loggedInUser.communityBalance + transferAmount;
            } else
                System.out.println("Incorrect type of account, please try again");
        } else {
            System.out.println("Invalid request has been made, please try again");

        }
        CreateAcc1.checkBalance();





    }



    public static void checkBalance() {

        System.out.println("The balance of your Small business account is" + " " + loggedInUser.smallBusinessBalance +
                "\n The balance of your Community account is " + loggedInUser.communityBalance +
                "\n The balance of your Client account is " + loggedInUser.clientBalance);
    }

    }

