package com.app.devjethava.customdialog;

import android.app.Activity;
import android.app.ProgressDialog;

public class CustomProgressDialog {

    private ProgressDialog progressDialog;

    private Activity activity;
    private String message;
    private boolean cancelable;

    public CustomProgressDialog(Activity activity) {
        this.activity = activity;
        progressDialog = new ProgressDialog(this.activity);
    }

    public CustomProgressDialog(Activity activity, String message) {
        this.activity = activity;
        this.message = message;
        progressDialog = new ProgressDialog(this.activity);
        progressDialog.setMessage(this.message);
    }

    public void setMessage(String message) {
        this.message = message;
        progressDialog.setMessage(this.message);
    }

    public void setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        progressDialog.setCancelable(this.cancelable);
    }

    public void showProgressDialog(String message) {
        progressDialog.setCancelable(false);
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    public void showProgressDialog(String message, boolean cancelable) {
        progressDialog.setCancelable(cancelable);
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    public void showProgressDialog(){
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void hideProgressDialog(){
        progressDialog.dismiss();
    }

    public void cancelProgressDialog(){
        progressDialog.cancel();
    }
}
