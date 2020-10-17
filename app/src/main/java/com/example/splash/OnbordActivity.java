package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class OnbordActivity extends AppCompatActivity {

    private ViewPager  mscreenpager;
    Onbordadapter introviewpageradapter;
    TabLayout tabindicater;
    Button btndone;
    Button btnstart;
    int position = 0;
    Animation btnanim;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onbord);


        if(restoreprefData()){
            Intent main = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(main);
            finish();
        }
        btndone = findViewById(R.id.btndone);
        btnstart = findViewById(R.id.btnstart);
        btnanim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.getstaredanim);


        tabindicater = findViewById(R.id.tabindicator);


        final List<Onborditems> mList = new ArrayList<>();
        mList.add(new Onborditems("Workers","You can find your nearest workers or contact us to get our professional workers like Mechanic, Electricians, Plumber, Carpenter, Welder.",R.drawable.workers));
        mList.add(new Onborditems("Emergency","You can find your nearest Ambulance, First-aid doctor console, police contact and much more, with few clicks to you get.",R.drawable.emergency));
        mList.add(new Onborditems("Contact - Us","You can directly contact our team to get your source for what you want?  Note: (we are provide this service for FREE)",R.drawable.contact));
        mList.add(new Onborditems("WELCOME","Thanks for choosing our application we are hearty providing you to get your nearest sources or contact our experts for free. you do not pay extra charge for our experts., ",R.drawable.welcome));

        mscreenpager = findViewById(R.id.screenviewr);
        introviewpageradapter = new Onbordadapter(this,mList);
        mscreenpager.setAdapter(introviewpageradapter);

        tabindicater.setupWithViewPager(mscreenpager);
        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position = mscreenpager.getCurrentItem();
                if (position<mList.size()){
                    position++;
                    mscreenpager.setCurrentItem(position);
                }
                if(position == mList.size()-1){
                    loadLastscreen();
                }

            }
        });
        tabindicater.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==mList.size()-1){
                    loadLastscreen();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(main);

                saveprefsData();
                finish();
            }
        });

    }

    private boolean restoreprefData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myprefs",MODE_PRIVATE);
        Boolean isOnbordActivityopenedBefore = pref.getBoolean("isOnbordOpened",false);
        return  isOnbordActivityopenedBefore;



    }

    private void saveprefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myprefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isOnbordOpened",true);
        editor.commit();
    }

    private void loadLastscreen() {

        btnstart.setVisibility(View.VISIBLE);
        btndone.setVisibility(View.INVISIBLE);
        tabindicater.setVisibility(View.INVISIBLE);

        btnstart.setAnimation(btnanim);

    }
}
