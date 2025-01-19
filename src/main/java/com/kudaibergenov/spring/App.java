package com.kudaibergenov.spring;

import com.kudaibergenov.spring.model.Director;
import com.kudaibergenov.spring.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(School.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Director director = session.get(Director.class, 2);

            School school = new School("The Wall");

            director.setSchool(school);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
