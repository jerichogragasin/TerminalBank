import AccountTypeTransaction.CheckingAccountTransaction;
import AccountTypeTransaction.SavingsAccountTransaction;
import AccountTypeTransaction.Transaction;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\u20B1");
        System.out.println("--------Welcome to the Terminal Bank--------");
        clearScreen();
        System.out.println();
        System.out.println("Main Transactions");
        System.out.println("A. Savings");
        System.out.println("B. Checking");
        System.out.println("Quick Transactions");
        System.out.println("C. Check Card Balance");
        System.out.println("D. Check Account Balance");
        Scanner userSelection = new Scanner(System.in);
        System.out.print("Please Select Your Desired Transaction (A, B, C, D): ");
        String optionSelected = userSelection.nextLine();
        optionSelected = optionSelected.toLowerCase(Locale.ROOT);

        switch (optionSelected) {
            case "a" -> {
                System.out.println("Account Type Selected: Savings");
                mainTransaction("savings");
            }
            case "b" -> {
                System.out.println("Account Type Selected: Checking");
                mainTransaction("checking");
            }
            case "c" -> {
                System.out.println("Quick Transaction Selected: Check Card Balance");
                quickTransaction("ccb");
            }
            case "d" -> {
                System.out.println("Quick Transaction Selected: Account Balance Check");
                quickTransaction("abc");
            }
            default -> System.out.println("Invalid Option Selected. Please Try Again");
        }
    }



    public static void mainTransaction(String transaction) {
        Transaction userTransaction;

        if(Objects.equals(transaction, "savings")){
            //savings transaction
            userTransaction = new SavingsAccountTransaction();
            getAccountInformation()
                    .forEach((accountNumber, accountPin)-> {
                        userTransaction.setAccountNumber(accountNumber);
                        userTransaction.setAccountPin(accountPin);
                    });
        } else {
            //savings transaction
            userTransaction = new CheckingAccountTransaction();
            getAccountInformation()
                    .forEach((accountNumber, accountPin)-> {
                        userTransaction.setAccountNumber(accountNumber);
                        userTransaction.setAccountPin(accountPin);
                    });
        }

        int accountNumber = userTransaction.getAccountNumber();
        float accountBalance = userTransaction.getAccountBalance();

        if(userTransaction.accountIsValid()){
            clearScreen();
            System.out.println("Account Number: xxx" + Integer.toString(accountNumber).substring(Integer.toString(accountNumber).length() - 4));
            System.out.println("Account Balance: " + userTransaction.formatAmount(accountBalance));
        } else {
            System.out.println(userTransaction.getError());
            System.out.println("Please Try Again");
        }
    }

    private static HashMap<Integer, Integer> getAccountInformation() {
        System.out.print("Enter Account Number: ");
        Scanner accountNumberInput = new Scanner(System.in);
        int accountNumber = accountNumberInput.nextInt();
        System.out.print("Enter Account Pin: ");
        Scanner accountPinInput = new Scanner(System.in);
        int accountPin = accountPinInput.nextInt();
        HashMap<Integer, Integer> accountDetails = new HashMap<>();
        accountDetails.put(accountNumber, accountPin);
        return accountDetails;
    }

    private static void quickTransaction(String transaction) {
        if(Objects.equals(transaction, "ccb"))    {
        } else {
        }
    }

    public static void clearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ignored) {}
    }
}
