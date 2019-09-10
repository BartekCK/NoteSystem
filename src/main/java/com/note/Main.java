package com.note;

import com.note.models.Boss;
import com.note.models.Note;
import com.note.models.User;
import com.note.utilies.MainDao;

public class Main
{
    public static void main(String[] args)
    {
        Boss boss = new Boss("Boss1","password1");
        MainDao.save(boss);

        User user = new User("User1","password1");
        user.getNoteSet().add(new Note("Ala ma kota1"));
        MainDao.save(user);

        MainDao.addEmployee(boss,user);

    }




}
