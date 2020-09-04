package tracom.hibernate.example;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Formula;

import javax.persistence.*;



@NamedQueries({
    @NamedQuery(name = Student.NQ_LIST_STUDENTS_PERSON_CONTACT_ONLY, query = "SELECT new Student(s.person,s.contact) FROM Student s where s.id between :minId"
            + " and :maxId and (s.person.name like :searchKey or s.contact.email like :searchKey or s.person.idNo like :searchKey)"),

    @NamedQuery(name = Student.NQ_LIST_STUDENTS, query = "SELECT s FROM Student s where s.id between :minId and "
            + ":maxId and (s.person.name like :searchKey or s.contact.email like :searchKey or s.person.idNo like :searchKey)")
})
@Entity
@Table(name = "students")
@DynamicInsert
@DynamicUpdate
public class Student extends BaseEntity{

    @Transient
    public static final String NQ_LIST_STUDENTS_PERSON_CONTACT_ONLY = "Student.listStudentsPersonContactOnly";

    @Transient
    public static final String NQ_LIST_STUDENTS = "Student.listStudentS";

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

    @Formula("(select s.name from schools s where s.id=school_id)")
    private String schoolName;

    @OneToOne(mappedBy = "student")
    private Registration registration;

    public Student(){}

    public Student(String regNo, String secondarySkul){
        this.regNo = regNo;
        this.secondarySkul = secondarySkul;
    }

    public Student(Person person, Contact contact){
        this.contact = contact;
        this.person = person;
    }

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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }
}
