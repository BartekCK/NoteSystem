package com.note.gui.utilies;

import com.note.api.models.User;
import com.note.api.utilies.MainDao;
import com.note.gui.App;
import com.note.gui.controllers.UserBoss;
import com.note.gui.controllers.boss.BossMainPanelController;
import com.note.gui.controllers.user.UserMainPanelController;
import com.note.gui.models.UserFx;

import java.util.TimerTask;

public class TimerScheduler extends TimerTask {

    private UserBoss userBoss;

    public TimerScheduler(UserBoss userBoss) {
        this.userBoss = userBoss;
        App.getTimer().scheduleAtFixedRate(this,0,5*1000);
    }


    @Override
    public void run() {

        try {

            if (userBoss instanceof UserMainPanelController)
            {
                UserMainPanelController userMainPanelController = (UserMainPanelController) userBoss;
                User temp = MainDao.findUser(userMainPanelController.getUserFx().getNick(), userMainPanelController.getUserFx().getPassword());
                userMainPanelController.setUserFx(new UserFx(temp));
                if (userMainPanelController.getDatePicker() != null & userMainPanelController.getDatePicker().getValue() != null) {
                    userMainPanelController.getTableView().setItems(userMainPanelController.getUserFx().getNotesFx().filtered(e -> e.getMessageTime().isEqual(userMainPanelController.getDatePicker().getValue())));
                }
                else{
                    userMainPanelController.getTableView().setItems(userMainPanelController.getUserFx().getNotesFx());
                }
            }else {
                BossMainPanelController bossMainPanelController = (BossMainPanelController) userBoss;
                bossMainPanelController.setTableView();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
