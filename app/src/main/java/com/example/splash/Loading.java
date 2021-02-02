package com.example.splash;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class Loading {
    private Activity activity;
    private AlertDialog dialog;

    public Loading(Activity myActivity){
        activity = myActivity;


    }
    public void StartLoadingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater= activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.connectiondialog,null));
        builder.setCancelable(true);
        dialog = builder.create();
        dialog.show();

    }
    public void dismissDialog(){
        dialog.dismiss();;
    }
}
