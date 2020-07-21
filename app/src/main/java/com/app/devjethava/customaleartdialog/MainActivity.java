package com.app.devjethava.customaleartdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;

import com.app.devjethava.customdialog.CustomDialog;
import com.app.devjethava.customdialog.CustomProgressDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        CustomDialog customDialog = new CustomDialog(this);
        final CustomProgressDialog progressDialog = new CustomProgressDialog(this);
        if (view.getId() == btn1.getId()){
            customDialog.showDialog("My Title", "My Message");
        } else if (view.getId() == btn2.getId()){
            customDialog.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
            customDialog.setTitle("My Title");
            customDialog.setMessage("My Message");
            customDialog.setCancelable(true);
            customDialog.showDialog();
        } else if (view.getId() == btn3.getId()){
            customDialog.showDialog(R.string.title, R.string.message);
        } else if (view.getId() == btn4.getId()){
            customDialog.showDialog(R.string.title, R.string.message, true);
        } else if (view.getId() == btn5.getId()){
            customDialog.showDialog("My Title", "My Message", CustomDialog.FINISH);
        } else if (view.getId() == btn6.getId()){
            progressDialog.showProgressDialog("Wait");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressDialog.hideProgressDialog();
                }
            }, 10000);
        } else if (view.getId() == btn7.getId()){
            progressDialog.showProgressDialog("Hello ...", true);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressDialog.hideProgressDialog();
                }
            }, 10000);
        } else if (view.getId() == btn8.getId()){
            progressDialog.setMessage("Hello World");
            progressDialog.setCancelable(false);
            progressDialog.showProgressDialog();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressDialog.hideProgressDialog();
                }
            }, 10000);
        } else if (view.getId() == btn9.getId()){
            final CustomProgressDialog dialog = new CustomProgressDialog(this, "My Message");
            dialog.setCancelable(false);
            dialog.showProgressDialog();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    dialog.hideProgressDialog();
                }
            }, 10000);

        }
    }
}