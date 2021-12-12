package question2.entity;

import javax.persistence.*;
import java.security.SecureRandom;
import java.util.Objects;

@Entity
@Table(name = "accounts")
public class Account extends BaseEntity<Long> {

    private long accountNumber;
    private long balance;
    private AccountState state;


    @OneToOne(mappedBy = "account")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_card_id", referencedColumnName = "id")
    private CreditCard creditCard;




    public Account(long balance) {
        this.accountNumber = setAccountNumber();
        this.balance = balance;
        this.state = AccountState.ACTIVE;
    }

    public Account() {

    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public Long setAccountNumber() {
        SecureRandom secureRandom = new SecureRandom();
        return (1000 + secureRandom.nextLong(4000));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return accountNumber == account.accountNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, customer);
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public AccountState getState() {
        return state;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", state=" + state +'\n'+
                ", creditCard=" + creditCard +
                '}';
    }
}
