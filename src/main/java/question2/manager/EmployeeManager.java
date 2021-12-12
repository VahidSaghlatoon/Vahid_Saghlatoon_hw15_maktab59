package question2.manager;

import question2.dao.EmployeeDao;
import question2.entity.Bank;
import question2.entity.Employee;

import java.util.Scanner;

public class EmployeeManager extends BaseManager<Employee, Long> {

    private final Scanner input = new Scanner(System.in);

    public EmployeeManager() {
        setBaseDao(new EmployeeDao());
    }


    public void addEmployee() {
        Employee employee = new Employee();
        new BankManager().loadAll().forEach(bank -> System.out.println(bank.toString()));
        System.out.print("Enter bank id :");
        Bank bank = new BankManager().loadById(input.nextLong());
        employee.setBank(bank);
        System.out.print("Enter name :");
        employee.setName(input.next());
        loadAll().forEach(employee1 -> System.out.println(employee1.toString()));
        System.out.print("Enter boss id :");
        employee.setBossId(input.nextLong());
        save(employee);
    }

    public void deleteEmployee() {
        loadAll().forEach(employee -> System.out.println(employee.toString()));
        System.out.print("Enter employee id : ");
        Employee employee = loadById(input.nextLong());
        delete(employee);
    }

    public void updateEmployee() {
        loadAll().forEach(employee -> System.out.println(employee.toString()));
        System.out.print("Enter employee id : ");
        Employee employee = loadById(input.nextLong());
        System.out.print("Enter new name : ");
        employee.setName(input.next());
        update(employee);

    }

    public void findAllEmployee() {
        loadAll().forEach(employee -> System.out.println(employee.toString()));
    }

    public void findEmployeeById() {
        System.out.print("Enter employee id : ");
        Employee employee = loadById(input.nextLong());
        System.out.println(employee.toString());
    }
}
