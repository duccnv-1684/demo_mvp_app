package com.example.ducnguyen.demomvpapp.data.repository;

import com.example.ducnguyen.demomvpapp.data.model.User;
import com.example.ducnguyen.demomvpapp.data.source.UserDataSource;
import com.example.ducnguyen.demomvpapp.data.source.local.UserLocalDataSource;
import com.example.ducnguyen.demomvpapp.data.source.remode.UserRemoteDataSource;

public class UserRepository
        implements UserDataSource.LocalDataSource, UserDataSource.RemoteDataSource {
    private static UserRepository sUserRepository;
    private UserLocalDataSource mUserLocalDataSource;
    private UserRemoteDataSource mUserRemoteDataSource;

    private UserRepository(UserLocalDataSource userLocalDataSource
            , UserRemoteDataSource userRemoteDataSource) {
        this.mUserLocalDataSource = userLocalDataSource;
        this.mUserRemoteDataSource = userRemoteDataSource;
    }
    public static synchronized UserRepository getInstance(UserLocalDataSource userLocalDataSource
            ,UserRemoteDataSource userRemoteDataSource){
        if (sUserRepository==null) sUserRepository
                = new UserRepository(userLocalDataSource,userRemoteDataSource);
        return sUserRepository;
    }

    @Override
    public void insertUser(User user) {
        mUserLocalDataSource.insertUser(user);
    }

    @Override
    public void getUser(String userId) {
        mUserLocalDataSource.getUser(userId);
    }

    @Override
    public void updateUser(User user) {
        mUserLocalDataSource.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        mUserLocalDataSource.deleteUser(user);
    }

    @Override
    public void login(String username, String password
            , UserRemoteDataSource.OnLoginComplete onLoginComplete) {
        mUserRemoteDataSource.login(username,password,onLoginComplete);
    }
}
