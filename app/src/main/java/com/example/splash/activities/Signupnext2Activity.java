package com.example.splash.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ScrollView;

import com.example.splash.R;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class Signupnext2Activity extends AppCompatActivity {

    ScrollView scrollView;
    TextInputLayout phone;
    CountryCodePicker countryCodePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupnext2);

        scrollView = findViewById(R.id.signupphone_scrollview);
        countryCodePicker = findViewById(R.id.country);
        phone = findViewById(R.id.signup_phone);


    }
    public void callverify(View view){
        String _fullname = getIntent().getStringExtra("fullname");
        String _username = getIntent().getStringExtra("username");
        String _email = getIntent().getStringExtra("email");
        String _password = getIntent().getStringExtra("password");
        String _gender = getIntent().getStringExtra("gender");
        String _date = getIntent().getStringExtra("date");

        String _getuserenterednumber = phone.getEditText().getText().toString().trim();
        String _phoneno = "+"+countryCodePicker.getFullNumber()+_getuserenterednumber;

        Intent intent = new Intent(getApplicationContext(), VerifyActivity.class);

        intent.putExtra("fullname",_fullname);
        intent.putExtra("username",_username);
        intent.putExtra("email",_email);
        intent.putExtra("password",_password);
        intent.putExtra("gender",_gender);
        intent.putExtra("date",_date);
        intent.putExtra("phone",_phoneno);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(scrollView,"transition_otp_screen");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Signupnext2Activity.this,pairs);
            startActivity(intent, options.toBundle());
        }
        else{
            startActivity(intent);
        }



    }
}
