package com.note.utilies;

import com.note.models.Boss;
import com.note.models.SaveOrder;
import com.note.models.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class MainDao {

    public static void save(SaveOrder saveOrder)
    {
        try(Session session = Connection.getSessionFactory().openSession()){
            session.beginTransaction();
            session.saveOrUpdate(saveOrder);
            session.getTransaction().commit();
        }catch (Exception e)
        {
            e.printStackTrace();
            Connection.getSessionFactory().openSession().getTransaction().rollback();
        }
    }

    public static void addEmployee(Boss boss, User user)
    {
        try(Session session  = Connection.getSessionFactory().openSession()){
            session.beginTransaction();

            Query query = session.createQuery("from User where nick = :userNick");
            query.setParameter("userNick",user.getNick());

            user = (User) query.uniqueResult();
            boss = session.get(Boss.class,boss.getPersonId());
            boss.getUserSet().add(user);

            session.getTransaction().commit();
        }catch (Exception e)
        {
            e.printStackTrace();
            Connection.getSessionFactory().openSession().getTransaction().rollback();
        }
    }


}
