package tracom.hibernate.example;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "students")
@DynamicInsert
@DynamicUpdate
public class Student extends BaseEntity{

    @Embedded
    private Person person;

    @Embedded
    private Contact contact;

    @Column(name = "reg_no")
    private String regNo;

    @Column(name = "secondary_skul")
    private String secondarySkul;

    @Column(name = "name_of_chief")
    private String nameOfChief;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private School school;

    @OneToOne(mappedBy = "student")
    private Registration registration;

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

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getSecondarySkul() {
        return secondarySkul;
    }

    public void setSecondarySkul(String secondarySkul) {
        this.secondarySkul = secondarySkul;
    }

    public String getNameOfChief() {
        return nameOfChief;
    }

    public void setNameOfChief(String nameOfChief) {
        this.nameOfChief = nameOfChief;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }
}
