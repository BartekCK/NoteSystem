package com.note.gui.utilies;

import com.note.api.models.User;
import com.note.api.utilies.MainDao;
import com.note.gui.controllers.user.UserMainPanelController;
import com.note.gui.models.UserFx;

import java.util.TimerTask;

public class TimerScheduler extends TimerTask {

    UserMainPanelController userMainPanelController;

    public TimerScheduler(UserMainPanelController userMainPanelController) {
        this.userMainPanelController = userMainPanelController;
    }

    @Override
    public void run() {

        try {
            User temp = MainDao.findUser(userMainPanelController.getUserFx().getNick(), userMainPanelController.getUserFx().getPassword());
            UserFx userFx = new UserFx(temp);
            userMainPanelController.setUserFx(userFx);
            if (userMainPanelController.getDatePicker() != null & userMainPanelController.getDatePicker().getValue() != null) {
                userMainPanelController.getTableView().setItems(userFx.getNotesFx().filtered(e -> e.getMessageTime().isEqual(userMainPanelController.getDatePicker().getValue())));
            }
            else{
                userMainPanelController.getTableView().setItems(userFx.getNotesFx());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
