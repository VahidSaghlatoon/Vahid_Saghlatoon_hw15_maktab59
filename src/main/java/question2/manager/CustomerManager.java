package question2.manager;

import question2.dao.CustomerDao;
import question2.entity.Account;
import question2.entity.Bank;
import question2.entity.CreditCard;
import question2.entity.Customer;

import javax.persistence.TypedQuery;
import java.util.Scanner;

public class CustomerManager extends BaseManager<Customer, Long> {

    private final Scanner input = new Scanner(System.in);
    public CustomerManager() {
        setBaseDao(new CustomerDao());
    }

    public void deleteCustomer() {
        loadAll().forEach(customer -> System.out.println(customer.toString()));
        System.out.print("Enter customer id : ");
        Customer customer = loadById(input.nextLong());
        delete(customer);

    }

    public void updateCustomer() {
        loadAll().forEach(customer -> System.out.println(customer.toString()));
        System.out.print("Enter customer id : ");
        Customer customer = loadById(input.nextLong());
        System.out.print("Enter new user name : ");
        customer.setUserName(input.next());
        System.out.print("Enter new password : ");
        customer.setPassword(input.next());
        System.out.println("Card issuance (Yes->1/No->0) : ");
        if (input.nextInt() == 1 )
            customer.getAccount().setCreditCard(new CreditCard());
        update(customer);

    }

    public void findAllCustomer() {
        System.out.println("--------------------------------------------------------------");
        loadAll().forEach(customer -> System.out.println(customer.toString()));

    }

    public void findCustomerById() {
        System.out.print("Enter customer id : ");
        Customer customer = loadById(input.nextLong());
        System.out.println(customer.toString());
    }

    public void addCustomer() {
        Customer customer = new Customer();
        new BankManager().loadAll().forEach(bank -> System.out.println(bank.toString()));
        System.out.print("Enter  bank id  : ");
        Bank bank = new BankManager().loadById(input.nextLong());
        customer.setBank(bank);
        System.out.print("Enter  name : ");
        customer.setName(input.next());
        System.out.print("Enter  national code : ");
        customer.setNationalCode(input.next());
        System.out.print("Enter user name : ");
        customer.setUserName(input.next());
        System.out.print("Enter  password : ");
        customer.setPassword(input.next());
        System.out.print("Enter  balance : ");
        customer.setAccount(new Account(input.nextLong()));
        System.out.println("Card issuance (Yes->1/No->0) : ");
        if (input.nextInt() == 1 )
            customer.getAccount().setCreditCard(new CreditCard());
        save(customer);

    }
}
