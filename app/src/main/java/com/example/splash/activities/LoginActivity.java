package com.example.splash.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.splash.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    ImageView backbtn;
    Button next,login;
    TextView titletext;

    TextInputLayout fullname, username, email,location, password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        backbtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titletext = findViewById(R.id.signup_title_text);

        fullname = findViewById(R.id.signup_fullname);
        username = findViewById(R.id.signup_username);
        email = findViewById(R.id.signup_email);
        location = findViewById(R.id.signup_location);
        password = findViewById(R.id.signup_password);



    }


    public void callNextSignupScreen(View view){

        if (!validatefullname() | !validateusername() | !validateemail() | !validatelocationname() | !validatepassword()){
            return;
        }



        Intent intent = new Intent(getApplicationContext(), SignupnextActivity.class);

        Pair[] pairs = new Pair[4];

        pairs[0] = new Pair<View, String>(backbtn,"trantion_back_arrow_btn");
        pairs[1] = new Pair<View, String>(next,"trantion_next_btn");
        pairs[2] = new Pair<View, String>(login,"trantion_login_btn");
        pairs[3] = new Pair<View, String>(titletext,"trantion_titletext");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this,pairs);
            startActivity(intent, options.toBundle());
        }
        else{
            startActivity(intent);
        }


    }


    private boolean validatefullname(){

        String val = fullname.getEditText().getText().toString().trim();

        if (val.isEmpty()){
            fullname.setError("Field can't be empty");
            return false;
        }
        else{
            fullname.setError(null);
            fullname.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validatelocationname(){

        String val = location.getEditText().getText().toString().trim();

        if (val.isEmpty()){
            location.setError("Field can't be empty");
            return false;
        }
        else{
            location.setError(null);
            location.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateusername(){

        String val = username.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,20}\\z";

        if (val.isEmpty()){
            username.setError("Field can't be empty!");
            return false;
        }
        else if (val.length()>20){
            username.setError("Username is too large!");
            return false;
        }else if (!val.matches(checkspaces)){
            username.setError("No white spaces are allowed!");
            return false;
        }


        else{
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateemail(){

        String val = email.getEditText().getText().toString().trim();
        String checkemail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()){
            email.setError("Field can't be empty!");
            return false;
        }

        else if (!val.matches(checkemail)){
            email.setError("Look like this is not email!");
            return false;
        }


        else{
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validatepassword(){

        String val = password.getEditText().getText().toString().trim();

        if (val.isEmpty()){
            password.setError("Field can't be empty!");
            return false;
        }

        else{
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }

    }

}
