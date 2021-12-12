package question2.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.security.SecureRandom;
import java.util.Set;

@Entity()
@Table(name = "banks")
public class Bank extends BaseEntity<Long> {
    private String name;
    private int branchCode;

    @OneToMany(mappedBy = "bank")
    private Set<Employee> employees;

    @OneToMany(mappedBy = "bank")
    private Set<Customer> customers;


    public Bank(String name) {
        this.name = name;
        this.branchCode = setBranchCode();
    }

    public Bank() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public int setBranchCode() {
        SecureRandom secureRandom = new SecureRandom();
        return 100 + secureRandom.nextInt(200);
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }


    @Override
    public String toString() {
        return "Bank{" +
                " id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", branchCode=" + branchCode +
                '}';
    }
}
