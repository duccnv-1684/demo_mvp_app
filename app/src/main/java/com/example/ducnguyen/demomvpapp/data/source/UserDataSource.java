package com.example.ducnguyen.demomvpapp.data.source;

import com.example.ducnguyen.demomvpapp.data.model.User;
import com.example.ducnguyen.demomvpapp.data.source.remode.UserRemoteDataSource;

public interface UserDataSource {

    interface LocalDataSource extends UserDataSource{
        void insertUser(User user);
        void getUser(String userId);
        void updateUser(User user);
        void deleteUser(User user);
    }
    interface RemoteDataSource extends UserDataSource{
        void login(String username, String password
                , UserRemoteDataSource.OnLoginComplete onLoginComplete);
    }
}
