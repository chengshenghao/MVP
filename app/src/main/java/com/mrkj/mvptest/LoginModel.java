package com.mrkj.mvptest;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.mrkj.mvptest.entry.WeixinGetNavbarPathMessage;
import com.mrkj.mvptest.util.Encrypt;
import com.mrkj.mvptest.util.GsonProvider;
import com.mrkj.mvptest.util.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by admin on 2018/4/16.
 */

public class LoginModel implements LoginInterFace.LoginOnInterFace {
    private LoginInterFace.OnLoginListener loginListener;

    @Override
    public void login(String username, String password, LoginInterFace.OnLoginListener loginListener) {
        this.loginListener = loginListener;
        final WeixinGetNavbarPathMessage request = new WeixinGetNavbarPathMessage();
        request.userName = Encrypt.getBase64(username);
        request.password = Encrypt.getBase64(password);
        Gson gson = GsonProvider.createNullStringAsEmptyGson();
        String param = gson.toJson(request);
        try {
            JSONObject json = new JSONObject(param);////    public static final String defValueIP = "http://115.28.191.62";
            JsonObjectRequest volleyRequest = new JsonObjectRequest(Request.Method.POST, "http://192.168.1.146:8080/ZCTJFirstCHospital/servlet/DevOpsService?cmd=APPLoginCmd"
                   , json, new NetWorkListener(), new NetWorkErrorListener());
            VolleySingleton.getInstance(ZiChanApplication.mApplication.getApplicationContext()).addToRequestQueue(volleyRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    class NetWorkListener implements Response.Listener<JSONObject> {

        @Override
        public void onResponse(JSONObject response) throws JSONException {
            Gson gson = GsonProvider.createNullStringAsEmptyGson();
            WeixinGetNavbarPathMessage persons = gson.fromJson(response.toString(), WeixinGetNavbarPathMessage.class);
            loginListener.loginSuccess(persons);
        }
    }

    class NetWorkErrorListener implements Response.ErrorListener {

        @Override
        public void onErrorResponse(VolleyError error) {
            loginListener.loginFailed();
        }
    }

}
