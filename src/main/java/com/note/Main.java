package com.note;

import com.note.models.Note;
import com.note.models.User;
import com.note.utilies.MainDao;

public class Main {


    public static void main(String[] args) {

        User user = new User();
        user.setNick("Test");
        user.setPassword("password");
        user.getListNote().add(new Note("Ala ma kota",user));
        MainDao.saveInDataBase(user);

    }




}
