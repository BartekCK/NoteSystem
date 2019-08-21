package com.note;

import com.note.models.Note;
import com.note.models.User;
import com.note.utilies.MainDao;

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {

        User user = new User();
        user.setUserId(1);
        user.setNick("Test");
        user.setPassword("password");

        Note note = new Note();
        note.setIdNote(1);
        note.setMessage("Ala ma kota");
        note.setMessageTime(LocalDate.now());
        note.setUser_id(user);

        user.getListNote().add(note);

        MainDao.saveInDataBase(user);
        MainDao.saveInDataBase(note);


    }




}
