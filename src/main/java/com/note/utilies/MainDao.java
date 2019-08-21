package com.note.utilies;

import org.hibernate.Session;
import java.io.Serializable;

public class MainDao {

    public static void saveInDataBase(Serializable serializable)
    {
        try(Session session = Connection.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(serializable);
            session.getTransaction().commit();

        }catch (Exception e)
        {
            e.printStackTrace();
            Connection.getSessionFactory().openSession().getTransaction().rollback();
        }
    }

}
