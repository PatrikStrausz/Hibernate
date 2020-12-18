package demo;

import entity.Children;
import entity.Mother;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateMother {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Mother.class)
                .addAnnotatedClass(Children.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            Mother mother = new Mother("Paulina", "Mala");

            session.beginTransaction();
            session.save(mother);
            session.getTransaction().commit();

        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
