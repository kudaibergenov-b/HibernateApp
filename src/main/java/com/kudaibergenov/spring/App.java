package com.kudaibergenov.spring;

import com.kudaibergenov.spring.model.one_to_one.Director;
import com.kudaibergenov.spring.model.one_to_many.Person;
import com.kudaibergenov.spring.model.one_to_one.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class  App {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(School.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();



            session.getTransaction().commit();
        }
    }
}
