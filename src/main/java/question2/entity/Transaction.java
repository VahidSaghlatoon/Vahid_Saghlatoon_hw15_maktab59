package question2.entity;

import javax.persistence.*;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity<Long> {

    private String transactionNumber;
    private String origin;
    private String destination;
    private Long amount;
    private String time;


    public Transaction(String origin, String destination, Long amount) {
        this.transactionNumber = generateTransactionNumber();
        this.origin = origin;
        this.destination = destination;
        this.amount = amount;
        this.time = setTime();
    }

    public Transaction() {

    }

    @Override
    public String toString() {
        return "Transaction{" +
                " id='" + getId() + '\'' +
                ", transactionNumber='" + transactionNumber + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", amount=" + amount +
                ", time='" + time + '\'' +
                '}';
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Long getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }

    public String setTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss:mm");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public String generateTransactionNumber() {
        return String.valueOf(new SecureRandom().nextInt(1000, 10000));
    }


}
