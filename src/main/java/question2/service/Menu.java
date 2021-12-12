package question2.service;

import question2.exception.CreditCardInvalidException;
import question2.exception.InvalidAmountException;
import question2.exception.NotFoundCreditCard;
import question2.manager.BankManager;
import question2.manager.CreditCardManager;
import question2.manager.CustomerManager;
import question2.manager.EmployeeManager;

import java.util.Scanner;

public class Menu {
    private final Scanner input = new Scanner(System.in);

    public void printCrudMenu(String entityName) {
        System.out.printf(
                "------------%s menu------------%n" +
                        "1-->Add %n" +
                        "2-->Show by id %n" +
                        "3-->Show all %n" +
                        "4-->Update by id %n" +
                        "5-->Delete by id %n" +
                        "0-->Back : ", entityName
        );
    }

    public void mainMenu() {
        System.out.print("""
                ----------main menu-----------
                1-->Bank
                2-->Employee
                3-->Customer
                4-->Credit card
                0-->Exit :\s""");
    }

    public void start() throws CreditCardInvalidException, InvalidAmountException, NotFoundCreditCard {
        boolean check = true;
        while (check) {
            mainMenu();
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> bankMenu();
                case 2 -> employeeMenu();
                case 3 -> customerMenu();
                case 4 -> creditCardMenu();
                case 0 -> check = false;
            }
        }
    }

    private void creditCardMenu() throws CreditCardInvalidException, InvalidAmountException, NotFoundCreditCard {
        boolean check = true;
        while (check) {
            System.out.print("""
                ----------credit card menu-----------
                1-->Money transfer
                2-->Change first password
                3-->Change second password
                4-->Show all transaction by card number
                5-->Unlock card
                0-->Back :\s""");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> new CreditCardManager().moneyTransfer();
                case 2 -> new CreditCardManager().changeFirstPassword();
                case 3 -> new CreditCardManager().changeSecondPassword();
                case 4 -> new CreditCardManager().showTransactionByCardNumber();
                case 5 -> new CreditCardManager().unlockCreditCard();
                case 0 -> check = false;
            }
        }
    }



    private void customerMenu() {
        boolean check = true;
        while (check) {
            printCrudMenu("customer");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> new CustomerManager().addCustomer();
                case 2 -> new CustomerManager().findCustomerById();
                case 3 -> new CustomerManager().findAllCustomer();
                case 4 -> new CustomerManager().updateCustomer();
                case 5 -> new CustomerManager().deleteCustomer();
                case 0 -> check = false;
            }

        }
    }


    private void employeeMenu() {
        boolean check = true;
        while (check) {
            printCrudMenu("employee");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> new EmployeeManager().addEmployee();
                case 2 -> new EmployeeManager().findEmployeeById();
                case 3 -> new EmployeeManager().findAllEmployee();
                case 4 -> new EmployeeManager().updateEmployee();
                case 5 -> new EmployeeManager().deleteEmployee();
                case 0 -> check = false;
            }

        }
    }


    private void bankMenu() {
        boolean check = true;
        while (check) {
            printCrudMenu("bank");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> new BankManager().addBank();
                case 2 -> new BankManager().showBankById();
                case 3 -> new BankManager().showAllBanks();
                case 4 -> new BankManager().updateBank();
                case 5 -> new BankManager().deleteBank();
                case 0 -> check = false;
            }

        }

    }



}
