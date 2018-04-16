package com.mrkj.mvptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mrkj.mvptest.entry.WeixinGetNavbarPathMessage;


public class MainActivity extends AppCompatActivity implements LoginInterFace.IUserLoginView {
    UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public String getUserName() {
        return "admin";
    }

    @Override
    public String getPassword() {
        return "123";
    }

    @Override
    public void clearUserName() {

    }

    @Override
    public void clearPassword() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMainActivity(WeixinGetNavbarPathMessage user) {
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {

    }

    public void go(View view) {
        Toast.makeText(this,"登录点击",Toast.LENGTH_SHORT).show();
        mUserLoginPresenter.login();
    }
}
