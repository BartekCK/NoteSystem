package com.note.utilies;

import com.note.models.Boss;
import com.note.models.Note;
import com.note.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

class Connection {

    private final static SessionFactory sessionFactory;

    static
    {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(serviceRegistry).addAnnotatedClass(User.class).addAnnotatedClass(Note.class).addAnnotatedClass(Boss.class).buildMetadata().buildSessionFactory();
    }

    static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}
