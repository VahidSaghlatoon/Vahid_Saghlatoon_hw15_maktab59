package question2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity<Long> {

    private String name;
    private String nationalCode;
    private String userName ;
    private String password;

    @ManyToOne
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    public Customer(String name, String nationalCode, String userName, String password, Bank bank, Account account) {
        this.name = name;
        this.nationalCode = nationalCode;
        this.userName = userName;
        this.password = password;
        this.bank = bank;
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getId(), customer.getId()) && Objects.equals(nationalCode, customer.nationalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), nationalCode);
    }

    @Override
    public String toString() {
        return "Customer{" +
                " id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", bank=" + bank +
                ", account=" + account +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
