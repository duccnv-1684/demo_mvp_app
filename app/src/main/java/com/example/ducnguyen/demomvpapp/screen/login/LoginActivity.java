package com.example.ducnguyen.demomvpapp.screen.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ducnguyen.demomvpapp.R;
import com.example.ducnguyen.demomvpapp.data.repository.UserRepository;
import com.example.ducnguyen.demomvpapp.data.source.local.UserLocalDataSource;
import com.example.ducnguyen.demomvpapp.data.source.remode.UserRemoteDataSource;
import com.example.ducnguyen.demomvpapp.screen.BaseActivity;

public class LoginActivity extends BaseActivity
        implements LoginContract.View, View.OnClickListener {
    private LoginContract.Presenter mPresenter;
    private EditText mEditTextUsername;
    private EditText mEditTextPassword;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button buttonLogin = findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(this);
        mEditTextUsername = findViewById(R.id.text_user_name);
        mEditTextPassword = findViewById(R.id.text_password);
        mProgressBar = findViewById(R.id.progress_bar);
        UserRepository userRepository = UserRepository.getInstance(
                UserLocalDataSource.getInstance(),
                UserRemoteDataSource.getInstance()
        );
        mPresenter = new LoginPresenter(userRepository);
        mPresenter.setView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.stop();
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showUsernameErrorMessage() {
        hideProgressBar();
        mEditTextUsername.setError(getString(R.string.message_username_invalid));
    }

    @Override
    public void showPasswordErrorMessage() {
        hideProgressBar();
        mEditTextPassword.setError(getString(R.string.message_password_invalid));
    }

    @Override
    public void showLoginFailMessage() {
        hideProgressBar();
        Toast.makeText(this, getString(R.string.login_fail), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toHomeActivity() {
        hideProgressBar();
        Toast.makeText(this, getString(R.string.to_home_activity), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login:
                String username = mEditTextUsername.getText().toString();
                String password = mEditTextPassword.getText().toString();
                mPresenter.login(username, password);
                break;
            default:
                break;
        }
    }
}
