package com.example.ducnguyen.demomvpapp.screen;

public interface BasePresenter<T> {
    void setView(T view);
    void start();
    void stop();
}
