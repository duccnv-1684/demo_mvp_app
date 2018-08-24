package com.example.ducnguyen.demomvpapp.data.source.local;

import com.example.ducnguyen.demomvpapp.data.model.User;
import com.example.ducnguyen.demomvpapp.data.source.UserDataSource;

public class UserLocalDataSource implements UserDataSource.LocalDataSource {
    private static UserLocalDataSource sUserLocalDataSource;

    private UserLocalDataSource() {

    }

    public static synchronized UserLocalDataSource getInstance() {
        if (sUserLocalDataSource == null) sUserLocalDataSource = new UserLocalDataSource();
        return sUserLocalDataSource;
    }

    public void destroyInstance() {
        if (sUserLocalDataSource != null) sUserLocalDataSource = null;
    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public void getUser(String userId) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
