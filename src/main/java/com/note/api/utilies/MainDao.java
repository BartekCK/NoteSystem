package com.note.api.utilies;

import com.note.api.models.Boss;
import com.note.api.models.Note;
import com.note.api.models.SaveOrder;
import com.note.api.models.User;
import com.note.gui.models.NoteFx;
import com.note.gui.models.UserFx;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

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

    public static List<User> findUser(String nick ) throws Exception {
        try(Session session = Connection.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM User WHERE nick =:nick ");
            query.setParameter("nick",nick);
            if (query.list().get(0) instanceof User)
                return query.list();
            throw new Exception("Wrong data");
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception("Wrong data");
        }
    }

    public static void addNote(UserFx userFx,String message){
        try(Session session = Connection.getSessionFactory().openSession()){
            session.beginTransaction();
            User user = session.get(User.class,userFx.getPersonId());
            user.getNoteSet().add(new Note(message));
            session.getTransaction().commit();
        }catch (Exception e)
        {
            e.printStackTrace();
            Connection.getSessionFactory().openSession().getTransaction().rollback();

        }
    }

    public static void changeNoteStatus(NoteFx noteFx){
        try(Session session = Connection.getSessionFactory().openSession()){
            session.beginTransaction();
            Note note = session.get(Note.class,noteFx.getIdNote());
            note.setDone(noteFx.isDone());
            session.getTransaction().commit();
        }catch (Exception e)
        {
            e.printStackTrace();
            Connection.getSessionFactory().openSession().getTransaction().rollback();
        }
    }

}
