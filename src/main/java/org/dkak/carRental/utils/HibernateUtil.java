package org.dkak.carRental.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    static final SessionFactory sf = new Configuration()
            .configure("hibernate.cfg.xml").buildSessionFactory();


    public static Session getSessionFactory() {

        // factory = new Configuration().configure().buildSessionFactory();
        final Session session = sf.openSession();
        return session;
    }
}
