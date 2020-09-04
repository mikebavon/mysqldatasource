package tracom.hibernate.example;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateSave {

    public static void main(String args []){
        //deleteStudent();
        //listStudentFromSchool();
        //saveStudentUsingSchool();
        //saveStudent();
        listStudents();
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
    public static void listStudents(){
        Session session = HibernateHelper.getSessionFactory().openSession();

        for (int page = 1; page<10; page++) {

            System.out.println("Page No. " + page);
            List<Student> students = session.createQuery("FROM Student s where s.id>:minId")
                    .setParameter("minId", 800)
                    .setFirstResult(page * 5 - 5)
                    .setMaxResults(5)
                    .getResultList();

            for (Student student : students) {

                System.out.println(student.getId() + ". " + student.getPerson().getName() + " emails is " + student.getContact().getEmail());

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
    public static void listByCriteriaStudents(){
        Session session = HibernateHelper.getSessionFactory().openSession();

        for (int page = 1; page<10; page++) {
            System.out.println("Page No. " + page);
            List<Student> students = session.createQuery("FROM Student s where s.id>:minId")
                    .setParameter("minId", 800)
                    .setFirstResult(page * 5 - 5)
                    .setMaxResults(5)
                    .getResultList();

            for (Student student : students) {

                System.out.println(student.getId() + ". " + student.getPerson().getName() + " emails is " + student.getContact().getEmail());

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
