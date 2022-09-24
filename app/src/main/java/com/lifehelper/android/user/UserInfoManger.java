package com.lifehelper.android.user;

import com.lifehelper.android.dao.User;

public class UserInfoManger {
    private User user;

    private static class Holder {
        private static UserInfoManger INSTANCE = new UserInfoManger();
    }

    public static UserInfoManger getInstance() {
        return UserInfoManger.Holder.INSTANCE;
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
