package com.example.ducnguyen.demomvpapp.screen.login;

import com.example.ducnguyen.demomvpapp.data.repository.UserRepository;
import com.example.ducnguyen.demomvpapp.data.source.remode.UserRemoteDataSource;
import com.example.ducnguyen.demomvpapp.util.common.StringUtil;

public class LoginPresenter
        implements LoginContract.Presenter,UserRemoteDataSource.OnLoginComplete {
    private LoginContract.View mView;
    private UserRepository mUserRepository;

    LoginPresenter(UserRepository userRepository) {
        this.mUserRepository = userRepository;
    }

    @Override
    public void setView(LoginContract.View view) {
        this.mView = view;
    }

    @Override
    public void login(String username, String password) {
        mView.showProgressBar();
        if (!StringUtil.checkValidateUsername(username)){
            mView.showUsernameErrorMessage();
            return;
        }
        if (!StringUtil.checkValidatePassword(password)){
            mView.showPasswordErrorMessage();
            return;
        }
        mUserRepository.login(username,password,this);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void onSuccess() {
        mView.toHomeActivity();
    }

    @Override
    public void onFail() {
        mView.showLoginFailMessage();
    }
}
