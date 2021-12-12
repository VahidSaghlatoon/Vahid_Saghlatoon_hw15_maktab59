package question2.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Random;
import java.util.Set;

@Entity
@Table(name = "creditCards")
public class CreditCard extends BaseEntity<Long> {

    private String cardNumber;
    private LocalDate issueDate;
    private LocalDate expireDate;
    private String cvv2Code;
    private String firstPassword;
    private String secondPassword;
    private CreditCardState state;

    @OneToOne(mappedBy = "creditCard")
    private Account account;


    public CreditCard() {
        this.cardNumber = generateCardNumber();
        this.issueDate = LocalDate.now();
        this.expireDate = LocalDate.now().plusYears(4);
        this.cvv2Code = generateNumberWithFourRandomDigit();
        this.firstPassword = generateNumberWithFourRandomDigit();
        this.state = CreditCardState.UNLOCK;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", issueDate=" + issueDate +
                ", expireDate=" + expireDate +
                ", cvv2Code='" + cvv2Code + '\'' +
                ", firstPassword='" + firstPassword + '\'' +
                ", secondPassword='" + secondPassword + '\'' +
                ", state=" + state +
                '}';
    }

    public String generateCardNumber() {
        StringBuilder cardNumber = new StringBuilder("6037");
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            cardNumber.append(random.nextInt(10));
        }
        return cardNumber.toString();
    }

    public String generateNumberWithFourRandomDigit() {
        StringBuilder number = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            number.append(random.nextInt(10));
        }
        return number.toString();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public String getCvv2Code() {
        return cvv2Code;
    }

    public void setCvv2Code(String cvv2Code) {
        this.cvv2Code = cvv2Code;
    }

    public String getFirstPassword() {
        return firstPassword;
    }

    public void setFirstPassword(String firstPassword) {
        this.firstPassword = firstPassword;
    }

    public String getSecondPassword() {
        return secondPassword;
    }

    public void setSecondPassword(String secondPassword) {
        this.secondPassword = secondPassword;
    }

    public CreditCardState getState() {
        return state;
    }

    public void setState(CreditCardState state) {
        this.state = state;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
