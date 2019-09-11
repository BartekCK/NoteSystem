package com.note.utilies;

import com.note.models.Boss;
import com.note.models.SaveOrder;
import com.note.models.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class MainDao {

    public static void save(SaveOrder saveOrder) throws Exception {
        try(Session session = Connection.getSessionFactory().openSession()){
            session.beginTransaction();
            session.saveOrUpdate(saveOrder);
            session.getTransaction().commit();
        }catch (Exception e)
        {
            e.printStackTrace();
            Connection.getSessionFactory().openSession().getTransaction().rollback();
            throw new Exception("Save error");
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

    public static User findUser(String nick, String password) throws Exception {
        try(Session session = Connection.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM User WHERE nick =:nick AND password = :password");
            query.setParameter("nick",nick);
            query.setParameter("password",password);
            if (query.uniqueResult() instanceof User)
                return (User) query.uniqueResult();
            throw new Exception("Wrong data");
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception("Wrong data");
        }
    }


}
