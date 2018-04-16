package com.mrkj.mvptest;

import com.mrkj.mvptest.entry.WeixinGetNavbarPathMessage;

/**
 * Created by admin on 2018/4/16.
 * Presenter的作用就是从View层获取用户的输入，传递到Model层进行处理，然后回调给View层，输出给用户！
 */

public class UserLoginPresenter {
    private final LoginInterFace.IUserLoginView userLoginView;
    private final LoginModel loginModel;

    public UserLoginPresenter(LoginInterFace.IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.loginModel = new LoginModel();
    }

    public void login() {
        userLoginView.showLoading();
        loginModel.login(userLoginView.getUserName(), userLoginView.getPassword(), new LoginInterFace.OnLoginListener() {
            @Override
            public void loginSuccess(final WeixinGetNavbarPathMessage user) {
                userLoginView.toMainActivity(user);
                userLoginView.hideLoading();
            }

            @Override
            public void loginFailed() {
                //需要在UI线程执行
                userLoginView.showFailedError();
                userLoginView.hideLoading();
            }
        });
    }

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
