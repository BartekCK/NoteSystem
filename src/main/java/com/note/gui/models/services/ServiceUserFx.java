package com.note.gui.models.services;

import com.note.gui.models.UserFx;

public class ServiceUserFx {
    private static UserFx userFx;

    public static UserFx getUserFx() {
        return userFx;
    }

    public static void setUserFx(UserFx userFx) {
        ServiceUserFx.userFx = userFx;
    }
}
