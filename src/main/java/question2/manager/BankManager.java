package question2.manager;

import question2.dao.BankDao;
import question2.entity.Bank;

import java.util.List;
import java.util.Scanner;

public class BankManager extends BaseManager<Bank, Long> {
    private final Scanner input = new Scanner(System.in);

    public BankManager() {
        setBaseDao(new BankDao());
    }

    public void addBank() {
        System.out.print("Enter name : ");
        String name = input.next();
        new BankManager().save(new Bank(name));
    }


    public void deleteBank() {
        loadAll().forEach(bank -> System.out.println(bank.toString()));
        System.out.print("Enter bank id : ");
        Long id = input.nextLong();
        Bank bank = loadById(id);
        delete(bank);

    }

    public void updateBank() {
        loadAll().forEach(bank -> System.out.println(bank.toString()));
        System.out.print("Enter bank id : ");
        Long id = input.nextLong();
        Bank bank = loadById(id);
        System.out.print("Enter new bank name : ");
        bank.setName(input.next());
        update(bank);
    }

    public void showAllBanks() {
        loadAll().forEach(bank -> System.out.println(bank.toString()));
    }

    public void showBankById() {
        System.out.print("Enter bank id : ");
        Bank bank = loadById(input.nextLong());
        System.out.println(bank.toString());
    }
}
