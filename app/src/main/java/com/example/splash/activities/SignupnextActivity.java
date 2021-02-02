package com.example.splash.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splash.R;

import java.util.Calendar;


public class SignupnextActivity extends AppCompatActivity {

    ImageView backbtn;
    Button next,login;
    TextView titletext;

    RadioGroup radioGroup;
    RadioButton selectage;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupnext);

        backbtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titletext = findViewById(R.id.signup_title_text);

        radioGroup = findViewById(R.id.signup_radiogroup);
        datePicker = findViewById(R.id.date_piger);
    }

    public void callNextSignupScreen(View view){

        if (!validategenter() | !validateage()){
            return ;
        }

        selectage = findViewById(radioGroup.getCheckedRadioButtonId());
        String gender = selectage.getText().toString();

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        String date = day+"/"+month+"/"+year;

        Intent intent = new Intent(getApplicationContext(), Signupnext2Activity.class);

        Pair[] pairs = new Pair[4];

        pairs[0] = new Pair<View, String>(backbtn,"trantion_back_arrow_btn");
        pairs[1] = new Pair<View, String>(next,"trantion_next_btn");
        pairs[2] = new Pair<View, String>(login,"trantion_login_btn");
        pairs[3] = new Pair<View, String>(titletext,"trantion_titletext");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignupnextActivity.this,pairs);
            startActivity(intent, options.toBundle());
        }
        else{
            startActivity(intent);
        }


    }

    private  boolean validategenter(){
        if (radioGroup.getCheckedRadioButtonId()==-1){
            Toast.makeText(this,"Please Select Gender",Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }

    private boolean validateage(){
        int currentyear = Calendar.getInstance().get(Calendar.YEAR);
        int userage = datePicker.getYear();
        int isagevalid = currentyear - userage;

        if (isagevalid< 5){
            Toast.makeText(this, "You are not eligible", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return  true;
        }
    }

}
