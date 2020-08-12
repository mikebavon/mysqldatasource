package tracom.hibernate.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateSave {

    public static void main(String args []){
        //insertWithSaveMethod();
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

        retrieveData();
    }

    //1. methods for saving and updating...
    public static void insertWithSaveMethod(){
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();

        Transaction tx = session.getTransaction();
        tx.begin();

        User user = new User();
        user.setName("Jane Doe");
        user.setEmail("jane.doe@nodomain.com");
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



}
