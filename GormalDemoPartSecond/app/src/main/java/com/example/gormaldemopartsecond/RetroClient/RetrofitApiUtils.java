package com.example.gormaldemopartsecond.RetroClient;

import android.app.ProgressDialog;
import android.content.Context;

import com.example.gormaldemopartsecond.BaseUrlClient.ApiClient;
import com.example.gormaldemopartsecond.Interfaces.SubApiInterface;
import com.example.gormaldemopartsecond.constants.Constant;


public class RetrofitApiUtils {
    public ProgressDialog pDialog;
    Context activity;

    public RetrofitApiUtils(Context activity) {
        this.activity = activity;
        this.pDialog = new ProgressDialog(activity);
    }

    public static SubApiInterface getAPIService() {
        return ApiClient.getClient(Constant.BASE_URL).create(SubApiInterface.class);

    }
}