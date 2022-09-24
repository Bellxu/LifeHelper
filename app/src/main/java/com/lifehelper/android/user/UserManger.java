package com.lifehelper.android.user;

import com.lifehelper.android.dao.AppDatabase;
import com.lifehelper.android.dao.User;

public class UserManger {
    private User user;

    private static class Holder {
        private static UserManger INSTANCE = new UserManger();
    }

    public static UserManger getInstance() {
        return UserManger.Holder.INSTANCE;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean checkLogin() {
        return user != null;
    }
}
