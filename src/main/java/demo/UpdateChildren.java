package demo;

import entity.Children;
import entity.Mother;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateChildren {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Mother.class)
                .addAnnotatedClass(Children.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try{
            session.beginTransaction();

            int id = 10;
            Children children = session.get(Children.class, id);

            children.setfName("Jan");
            session.update(children);

            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
