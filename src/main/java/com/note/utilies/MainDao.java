package com.note.utilies;

import org.hibernate.Session;

import java.io.Serializable;

public class MainDao {

    private static Session session;

    public static void saveInDataBase(Serializable serializable)
    {
        try{
            session = Connection.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(serializable);
            session.getTransaction().commit();

        }catch (Exception e)
        {
            session.getTransaction().rollback();
            e.getMessage();
        }
        finally {
            session.close();
        }

    }

}
