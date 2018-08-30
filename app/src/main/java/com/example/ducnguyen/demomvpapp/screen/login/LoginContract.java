package com.example.ducnguyen.demomvpapp.screen.login;

import com.example.ducnguyen.demomvpapp.screen.BasePresenter;

public interface LoginContract {
    interface View{
        void showProgressBar();
        void hideProgressBar();
        void showUsernameErrorMessage();
        void showPasswordErrorMessage();
        void showLoginFailMessage();
        void toHomeActivity();
    }
    interface Presenter extends BasePresenter<LoginContract.View>{
        void login(String username,String password);
    }
}
