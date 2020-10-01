package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class Navigation extends AppCompatActivity {

    TextView aboutnav, loginnav, jobnav, careernav, feedbacknav, helpnav,facebooknav,twitternav, webnav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        aboutnav = findViewById(R.id.aboutnav);
        loginnav = findViewById(R.id.loginnav);
        jobnav = findViewById(R.id.jobnav);
        careernav = findViewById(R.id.careernav);
        feedbacknav = findViewById(R.id.feedbacknav);
        helpnav = findViewById(R.id.helpnav);

        aboutnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Navigation.this,AboutActivity.class);
                startActivity(intent);
            }
        });

        loginnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Navigation.this,Signupnext2Activity.class);
                startActivity(intent);
            }
        });
        jobnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Navigation.this,AboutActivity.class);
                startActivity(intent);
            }
        });
        careernav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Navigation.this,AboutActivity.class);
                startActivity(intent);
            }
        });

    }
}
