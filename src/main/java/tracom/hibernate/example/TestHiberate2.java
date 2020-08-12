package tracom.hibernate.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestHiberate2 {

    public static void main(String args []){

        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
        //session.beginTransaction();
        Transaction tx = session.getTransaction();
        tx.begin();

        TracomAcademy tracomAcademy = new TracomAcademy();
        tracomAcademy.setName("Maulid3");
        tracomAcademy.setDescription("Maulid3 is a cool guy");
        session.save(tracomAcademy);

        tracomAcademy.setName("Jedidah");
        tracomAcademy.setDescription("Jedidah is a cool babe");

        //session.getTransaction().commit();
        tx.commit();

    }
}
