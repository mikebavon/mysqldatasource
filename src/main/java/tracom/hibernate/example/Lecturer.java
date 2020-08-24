package tracom.hibernate.example;

import javax.persistence.*;

@Entity
@Table(name = "lecturers")
public class Lecturer extends BaseEntity{

    @Embedded
    private Person person;

    @Embedded
    private Contact contact;

    @Column(name = "payroll_no")
    private String payrollNo;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getPayrollNo() {
        return payrollNo;
    }

    public void setPayrollNo(String payrollNo) {
        this.payrollNo = payrollNo;
    }
}
