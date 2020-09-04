package tracom.hibernate.example;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import java.util.List;
import java.util.Scanner;

public class HibernateSave {

    public static void main(String args []){

/*        Scanner input = new Scanner(System.in);
        System.out.println("Enter start id:");
        int min = input.nextInt();
        System.out.println("Enter max id:");
        int max = input.nextInt();
        System.out.println("Enter  page size: ");
        int pageSize = input.nextInt();
        System.out.println("Enter search key");
        String searchBy = input.next();*/

        //listByNameQueryStudents(min, max, pageSize, searchBy) ;
        listByNameQuerySql() ;
        //listStudents(min, max, pageSize, searchBy) ;
        //deleteStudent();
        //listStudentFromSchool();
        //saveStudentUsingSchool();
        //saveStudent();

        //insertWithPersistMethod();
        //insertWithSaveOrUpdateMethod();
        //updateWithUpdateMethod();
        //insertWithMergeMethod();
        /*retrieveUsingIdWithGetMethod();
        System.out.println("****************************************************");
        System.out.println();
        System.out.println();
        System.out.println();
        retrieveUsingIdWithLoadMethod();*/

        //retrieveData();
    }

    //1. methods for saving and updating...
    public static void saveStudent(){
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();

        Transaction tx = session.getTransaction();
        tx.begin();

        School school = new School();
        school.setId(4);
        school.setName("MIT");
        school.setContact(new Contact());
        school.getContact().setEmail("tracom.mit@tracom.com");

        //int schoolId = (Integer) session.save(school);

        Student student = new Student();
        student.setPerson(new Person());

        //student.setSchool(session.load(School.class, schoolId));
        student.setSchool(school);

        student.getPerson().setName("Anthony");
        student.getPerson().setGender(Gender.FEMALE);
        student.getPerson().setIdNo("232332232323");
        student.getPerson().setMaritalStatus(MaritalStatus.COMPLICATED);
        student.getPerson().setReligion(Religion.CHRISTIAN);

        student.setContact(new Contact());
        student.getContact().setEmail("antony@tracom.com");

        student.setRegNo("PR/2020/78845");
        student.setNameOfChief("Kiarie");
        student.setSecondarySkul("Tumaini Industry Secondary School");
        session.save(student);

        tx.commit();
    }

    //1. methods for saving and updating...
    public static void saveStudentUsingSchool(){
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();

        Transaction tx = session.getTransaction();
        tx.begin();

        School school = new School();
        school.setName("HAVARD - Rwanda");
        school.setContact(new Contact());
        school.getContact().setEmail("harvard.rw@tracom.com");

        //int schoolId = (Integer) session.save(school);

        for (int idx = 0; idx<1000; idx++) {
            Student student = new Student();
            student.setPerson(new Person());

            //student.setSchool(session.load(School.class, schoolId));
            student.setSchool(school);

            student.getPerson().setName("Alexd" + idx);
            student.getPerson().setGender(Gender.FEMALE);
            student.getPerson().setIdNo("232332232323dd" + idx);
            student.getPerson().setMaritalStatus(MaritalStatus.COMPLICATED);
            student.getPerson().setReligion(Religion.CHRISTIAN);

            student.setContact(new Contact());
            student.getContact().setEmail("alexd@tracom.com" + idx);

            student.setRegNo("PR/2020/78845d" + idx);
            student.setNameOfChief("Kiaried" + idx);
            student.setSecondarySkul("Tumainid Industry Secondary School" + idx);

            //******
            school.addStudent(student);
        }

        session.save(school);

        tx.commit();
    }
    //1. delete student..
    public static void deleteStudent(){
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();

        Transaction tx = session.getTransaction();
        tx.begin();

        Student student = session.load(Student.class, 6);

        session.delete(student);

        tx.commit();
    }


    //1. methods for saving and updating...
    public static void insertWithSaveMethod(){
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();

        Transaction tx = session.getTransaction();
        tx.begin();

        User user = new User();
        user.setName("Jane Doe");
        user.setEmail("jane.doe@nodomain.com");
        user.setUserDetails("User is from tracom academy");
        int userId = (Integer) session.save(user);

        UserCredential credential = new UserCredential();
        credential.setUserId(userId);
        credential.setUsername("janedoe");
        credential.setPassword("janedoe123*");
        session.save(credential);

        tx.commit();
    }

    public static void insertWithPersistMethod(){
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();

        Transaction tx = session.getTransaction();
        tx.begin();

        User user = new User();
        user.setName("John Smith");
        user.setEmail("john.smith@nodomain.com");
        session.persist(user);

        tx.commit();
    }

    public static void insertWithSaveOrUpdateMethod(){
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();

        Transaction tx = session.getTransaction();
        tx.begin();

        User user = new User();
        user.setId(2);
        user.setName("Johh Doe");
        user.setEmail("john.doe@nodomain.com");
        session.saveOrUpdate(user);

        tx.commit();
    }

    public static void updateWithUpdateMethod(){
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();

        Transaction tx = session.getTransaction();
        tx.begin();

        User user = new User();
        user.setId(2);
        user.setName("John Cena");
        user.setEmail("john.cena@nodomain.com");
        session.update(user);

        tx.commit();
    }

    public static void insertWithMergeMethod(){
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();

        Transaction tx = session.getTransaction();
        tx.begin();

        User user = new User();
        user.setName("Some Person");
        user.setEmail("some.person@nodomain.com");
        user = (User) session.merge(user);

        UserCredential credential = new UserCredential();
        credential.setUserId(user.getId());
        credential.setUsername("someperson");
        credential.setPassword("some@#@#@3*");
        session.merge(credential);

        tx.commit();
    }

    //methods for loading...
    public static void retrieveUsingIdWithGetMethod(){

        Session session = HibernateHelper.getSessionFactory().openSession();

        User user = session.get(User.class, 2);
        System.out.println("******** Loaded data ****");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getEmail());

    }

    //methods for loading...
    public static void retrieveUsingIdWithLoadMethod(){

        Session session = HibernateHelper.getSessionFactory().openSession();

        User user = session.load(User.class, 2);
        System.out.println("******** Data not load ..waiting to user the object ****");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Started to use the object");
        System.out.println(user.getId());
        System.out.println("It was loaded..after using the object the first time...");
        System.out.println(user.getName());
        System.out.println(user.getEmail());

    }

    public static void retrieveData(){
        Session session = HibernateHelper.getSessionFactory().openSession();

        List<User> users = session.createQuery("FROM User r").getResultList();

        for (User user : users){
            System.out.println(user.getId() + ". " + user.getName() + " emails is " + user.getEmail());
        }
    }

    @SuppressWarnings({"unchecked"})
    public static void listStudents(int min, int max, int pageSize, String searchBy){
        Session session = HibernateHelper.getSessionFactory().openSession();

        for (int page = 1; page<10; page++) {

            System.out.println("Page No. " + page);
            List<Student> students = session.createQuery("SELECT new Student(s.person,s.contact) FROM Student s where s.id between :minId and "
                    + ":maxId and (s.person.name like :searchKey or s.contact.email like :searchKey or s.person.idNo like :searchKey)")
                    .setParameter("minId", min)
                    .setParameter("maxId", max)
                    .setParameter("searchKey", searchBy + "%")
                    .setFirstResult(page * pageSize - pageSize)
                    .setMaxResults(pageSize)
                    .getResultList();

            for (Student student : students) {

                System.out.println(student.getId() + ". " + student.getPerson().getName() + " emails is " + student.getContact().getEmail());
                //System.out.println(student.getRegNo() + ". " + student.getSecondarySkul());

                //if (student.getSchool() != null)
                //System.out.println("School: " + student.getSchool().getName());

  /*          System.out.println("The school of the student will be loaded later on use");
            System.out.println("This students are fantastic");
            System.out.println("They hot dog for breakfast");*/

/*            if(student.getSchool() != null)
                System.out.println(student.getSchool());

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();*/
            }


            System.out.println();
            System.out.println();
        }
    }

    @SuppressWarnings({"unchecked"})
    public static void listByNameQueryStudents(int min, int max, int pageSize, String searchBy){
        Session session = HibernateHelper.getSessionFactory().openSession();

        for (int page = 1; page<10; page++) {

            System.out.println("Page No. " + page);
            List<Student> students = session.createNamedQuery(Student.NQ_LIST_STUDENTS_PERSON_CONTACT_ONLY)
                    .setParameter("minId", min)
                    .setParameter("maxId", max)
                    .setParameter("searchKey", searchBy + "%")
                    .setFirstResult(page * pageSize - pageSize)
                    .setMaxResults(pageSize)
                    .getResultList();

            for (Student student : students) {

                System.out.println(student.getId() + ". " + student.getPerson().getName() + " emails is " + student.getContact().getEmail());

            }

            System.out.println();
            System.out.println();
        }
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public static void listByNameQuerySql(){
        Session session = HibernateHelper.getSessionFactory().openSession();

            List<Object[]> students = session.createSQLQuery("select s.id,s.name,s.email from students s")
                    .setFirstResult(100)
                    .setMaxResults(20)
                    .list();

            for (Object[] obj : students){
                System.out.println(obj[0] + ". " + obj[1] + " email is " + obj[2]);
            }
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public static void listByNameQuerySqlTransform(){
        Session session = HibernateHelper.getSessionFactory().openSession();

        NativeQuery sqlQuery = session.createNativeQuery("select s.id as recorId,s.name as primaryName,s.email as primaryEmail from students s")
                .setFirstResult(100)
                .setMaxResults(20);

        List<PrimaryStudent> primaryStudents = sqlQuery
            .addScalar("recorId", IntegerType.INSTANCE)
            .addScalar("primaryName", StringType.INSTANCE)
            .addScalar("primaryEmail", StringType.INSTANCE)
            .setResultSetMapping(String.valueOf(Transformers.aliasToBean(PrimaryStudent.class)))
            .list();

            for (PrimaryStudent primaryStudent : primaryStudents){
                System.out.println(primaryStudent.getRecorId() + ". " + primaryStudent.getPrimaryName() + " email is " + primaryStudent.getPrimaryEmail());
            }
    }

    public static void listStudentFromSchool(){
        Session session = HibernateHelper.getSessionFactory().openSession();

        List<School> schools = session.createQuery("FROM School s").getResultList();


        for (School school : schools){
            System.out.println(school.getName().toUpperCase());
            System.out.println("Students are as follows:");

            for(Student student : school.getStudents())
                System.out.println(student.getId() + ". " + student.getPerson().getName() + " emails is " + student.getContact().getEmail());


            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
}
