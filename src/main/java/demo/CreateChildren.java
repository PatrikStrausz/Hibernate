package demo;

import entity.Children;
import entity.Mother;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateChildren {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Mother.class)
                .addAnnotatedClass(Children.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            int id = 3;
            Mother mother = session.get(Mother.class, id);

            Children children1 = new Children("Bronisalv", "Velky");
            Children children2 = new Children("Matus", "Velka");

            mother.add(children1);
            mother.add(children2);

            session.save(children1);
            session.save(children2);

            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
