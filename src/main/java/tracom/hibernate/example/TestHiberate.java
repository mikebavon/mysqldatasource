package tracom.hibernate.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestHiberate {

    public static void main(String args []){

        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
        //session.beginTransaction();
        Transaction tx = session.getTransaction();
        tx.begin();

        TracomAcademy tracomAcademy = new TracomAcademy();
        tracomAcademy.setName("Academy 1");
        tracomAcademy.setDescription("January - June");
        session.save(tracomAcademy);

        tracomAcademy = new TracomAcademy();
        tracomAcademy.setName("Academy 2");
        tracomAcademy.setDescription("July - October");
        session.save(tracomAcademy);

        tracomAcademy = new TracomAcademy();
        tracomAcademy.setName("Academy 3");
        tracomAcademy.setDescription("November - December");
        session.save(tracomAcademy);

        //session.getTransaction().commit();
        tx.commit();

    }
}
