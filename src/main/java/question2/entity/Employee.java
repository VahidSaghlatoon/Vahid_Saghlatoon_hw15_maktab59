package question2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity()
@Table(name = "employees")
public class Employee extends BaseEntity<Long> {
    private String name ;
    private Long bossId;

    @ManyToOne
    @JoinColumn(name = "bank_id" ,nullable = false)
    private Bank bank;

    public Employee(String name, Long bossId, Bank bank) {
        this.name = name;
        this.bossId = bossId;
        this.bank = bank;
    }

    public Employee() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getId(), employee.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Employee{" +
                " id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", bossId=" + bossId +
                ", bank=" + bank +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBossId() {
        return bossId;
    }

    public void setBossId(Long bossId) {
        this.bossId = bossId;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
