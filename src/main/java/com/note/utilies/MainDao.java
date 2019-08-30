package com.note.utilies;

import com.note.models.Boss;
import com.note.models.SaveOrder;
import com.note.models.User;
import org.hibernate.Session;

import java.io.Serializable;

public class MainDao {

    public static void save(SaveOrder saveOrder)
    {
        try(Session session = Connection.getSessionFactory().openSession()){
            session.beginTransaction();
            session.persist(saveOrder);
            session.getTransaction().commit();
        }catch (Exception e)
        {
            e.printStackTrace();
            Connection.getSessionFactory().openSession().getTransaction().rollback();
        }
    }

    public static <T extends User,I extends Boss> void save(T user, I boss)
    {
        try(Session session = Connection.getSessionFactory().openSession()){
            session.beginTransaction();
            boss = (I) session.get(boss.getClass(),boss.getBossId());
            user.setBoss_id(boss);
            session.persist(user);
            session.getTransaction().commit();
        }catch (Exception e)
        {
            e.printStackTrace();
            Connection.getSessionFactory().openSession().getTransaction().rollback();
        }
    }

    public static <T extends Serializable> T dropFromDataBase(Class<T> cls, long id)
    {
        try(Session session = Connection.getSessionFactory().openSession()){
            return session.get(cls,id);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
