package com.mrkj.mvptest;

import com.mrkj.mvptest.entry.WeixinGetNavbarPathMessage;

/**
 * Created by admin on 2018/4/16.
 */

public interface LoginInterFace {
    /*
    * 定义业务接口
    * */
    public interface LoginOnInterFace {
        public void login(String username, String password, OnLoginListener loginListener);
    }

    /*
  * 定义结果回调接口
  * */
    public interface OnLoginListener {
        void loginSuccess(WeixinGetNavbarPathMessage user);
        void loginFailed();
    }

    public interface IUserLoginView  {
        String getUserName();
        String getPassword();
        void clearUserName();
        void clearPassword();
        void showLoading();
        void hideLoading();
        void toMainActivity(WeixinGetNavbarPathMessage user);
        void showFailedError();
    }
}
