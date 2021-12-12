package question2.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person extends BaseEntity<Long> {
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String nationalCode;
    @Column
    private String phone;
    @Column
    private String mobile;

    public Person(String firstName, String lastName, String nationalCode, String phone, String mobile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.phone = phone;
        this.mobile = mobile;
    }

    public Person(PersonBuilder<?> personBuilder) {
        firstName = personBuilder.firstName;
        lastName = personBuilder.lastName;
        nationalCode = personBuilder.nationalCode;
        phone = personBuilder.phone;
        mobile = personBuilder.mobile;
    }

    public Person() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @SuppressWarnings("unchecked")
    public static class PersonBuilder<T extends PersonBuilder<T>> {
        private String firstName;
        private String lastName;
        private String nationalCode;
        private String phone;
        private String mobile;

        public T setFirstName(String firstName) {
            this.firstName = firstName;
            return (T) this;
        }

        public T setLastName(String lastName) {
            this.lastName = lastName;
            return (T) this;
        }

        public T setNationalCode(String nationalCode) {
            this.nationalCode = nationalCode;
            return (T) this;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("PersonBuilder{");
            sb.append("firstName='").append(firstName).append('\'');
            sb.append(", lastName='").append(lastName).append('\'');
            sb.append(", nationalCode='").append(nationalCode).append('\'');
            sb.append(", phone='").append(phone).append('\'');
            sb.append(", mobile='").append(mobile).append('\'');
            sb.append('}');
            return sb.toString();
        }

        public T setPhone(String phone) {
            this.phone = phone;
            return (T) this;
        }

        public T setMobile(String mobile) {
            this.mobile = mobile;
            return (T) this;
        }

        public Person build() {
            return new Person(this);
        }
    }

}
