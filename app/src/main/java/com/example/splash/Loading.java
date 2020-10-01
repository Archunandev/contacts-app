package com.example.splash;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class Loading {
    private Activity activity;
    private AlertDialog dialog;

    Loading(Activity myActivity){
        activity = myActivity;


    }
    void StartLoadingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater= activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.connectiondialog,null));
        builder.setCancelable(true);
        dialog = builder.create();
        dialog.show();

    }
    void dismissDialog(){
        dialog.dismiss();;
    }
}
