package com.app.devjethava.customdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;

public class CustomDialog{

    private Activity activity;
    private String message;
    private String title;
    private int themeResId;
    private boolean cancelable = true;
    private Drawable icon;
    private int messageId;
    private int titleId;
    private int iconId;
    private int layoutResId;

    public static final int FINISH = 1;
    public static final int NO_FINISH = 0;

    private AlertDialog.Builder builder;

    public CustomDialog(Activity activity) {
        this.activity = activity;
        builder = new AlertDialog.Builder(this.activity);
    }

    public CustomDialog(Activity activity, int themeResId) {
        this.activity = activity;
        this.themeResId = themeResId;
        builder = new AlertDialog.Builder(this.activity, this.themeResId);
    }

    public void setMessage(String message) {
        this.message = message;
        builder.setMessage(this.message);
    }

    public void setTitle(String title) {
        this.title = title;
        builder.setTitle(this.title);
    }

    public void setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        builder.setCancelable(this.cancelable);
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
        builder.setIcon(this.icon);
    }

    public void setIcon(int iconId) {
        this.iconId = iconId;
        builder.setIcon(this.iconId);
    }

    public void setMessage(int messageId) {
        this.messageId = messageId;
        builder.setMessage(this.messageId);
    }

    public void setTitle(int titleId) {
        this.titleId = titleId;
        builder.setTitle(this.messageId);
    }

    public void setView(int layoutResId) {
        this.layoutResId = layoutResId;
        builder.setView(this.layoutResId);
    }

    public void showDialog(String title, String message){
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    public void showDialog(){
        builder.show();
    }

    public void showDialog(int resTitle, int resMessage){
        builder.setTitle(resTitle);
        builder.setMessage(resMessage);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    public void showDialog(int resTitle, int resMessage, boolean positiveButton){
        builder.setTitle(resTitle);
        builder.setMessage(resMessage);
        builder.setCancelable(false);
        if (positiveButton){
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
        builder.show();

    }

    public void showDialog(String title, String message, final int finishActivity){
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (finishActivity == FINISH){
                    dialogInterface.dismiss();
                    activity.finish();
                }
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

}
