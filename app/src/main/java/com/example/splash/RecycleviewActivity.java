package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.splash.activities.Navigation;
import com.example.splash.emergency.PoliceActivity;
import com.example.splash.shops.FoodActivity;
import com.example.splash.workers.ElectriActivity;
import com.example.splash.activities.LoginActivity;
import com.example.splash.workers.MechanicActivity;
import com.example.splash.workers.PlumberActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RecycleviewActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    TextView mechanic,elec,plumber,carpenter,welder,police,firstaid,ambulance,contactus ,seeallworkers,seeallemer,foodactivity;
    FloatingActionButton login,navigation,mapmenu,addcontact;
    ImageView centerimage, workersintent,emergengyintent,fooddeliveryintent,helplineintent,policeintent;
    ImageSlider mainSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);

        final Loading loading = new Loading(RecycleviewActivity.this);

        loading.StartLoadingDialog();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                loading.dismissDialog();

            }
        },3000);

        //recycler view intent declaration

        mechanic = findViewById(R.id.expandmechanicall);
        elec = findViewById(R.id.expandelecall);
        plumber = findViewById(R.id.expandplumberall);
        carpenter = findViewById(R.id.expandcarpenterall);
        welder = findViewById(R.id.expandwelderall);
        police = findViewById(R.id.expandpoliceall);

        //Box grid view intent declaration

        workersintent = findViewById(R.id.workersintent);
        emergengyintent = findViewById(R.id.emergengyintent);
        fooddeliveryintent = findViewById(R.id.Fooddeliveryintent);
        helplineintent = findViewById(R.id.helplineintent);
        policeintent = findViewById(R.id.policeintent);


       // firstaid = findViewById(R.id.expandfirstaid);
       // ambulance = findViewById(R.id.expandambulance);
       // contactus = findViewById(R.id.expandcontactus);
       // login = findViewById(R.id.login);
        navigation = findViewById(R.id.navigattion);
        addcontact = findViewById(R.id.addcontact);
       // mapmenu = findViewById(R.id.mapmenu);
       // centerimage = findViewById(R.id.centerimage);
        foodactivity = findViewById(R.id.foodactivity);
        seeallworkers = findViewById(R.id.seeallworkers);
        seeallemer = findViewById(R.id.seeallemer);


        mainSlider = (ImageSlider) findViewById(R.id.imageslider);



        final List <SlideModel> remoteimages = new ArrayList<>();

        FirebaseDatabase.getInstance().getReference().child("slider")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data:snapshot.getChildren()){
                            remoteimages.add(new SlideModel(data.child("url").getValue().toString(),ScaleTypes.FIT));

                            mainSlider.setImageList(remoteimages,ScaleTypes.FIT);

                            mainSlider.setItemClickListener(new ItemClickListener() {
                                @Override
                                public void onItemSelected(int i) {
                                    Intent intent = new Intent(RecycleviewActivity.this,GridView.class);
                                    startActivity(intent);
                                }
                            });
                        }

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



        ConnectivityManager connectivityManager= (ConnectivityManager)

        getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo == null || !networkInfo.isConnected() || !networkInfo.isAvailable()){
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialogconnectionerror);

            dialog.setCanceledOnTouchOutside(false);

            dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT);

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            dialog.getWindow().getAttributes().windowAnimations =
                    android.R.style.Animation_Dialog;

            Button bttry = dialog.findViewById(R.id.bttryagain);
            bttry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recreate();
                }
            });
            dialog.show();
        }
        else {

           addcontact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RecycleviewActivity.this, LoginActivity.class);
                    startActivity(intent);

                }
            });

            navigation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RecycleviewActivity.this, Navigation.class);
                    startActivity(intent);
                }
            });


           /* login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RecycleviewActivity.this, Signupnext2Activity.class);
                    startActivity(intent);
                    onBackPressed();
                }
            }); */

            mechanic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RecycleviewActivity.this, MechanicActivity.class);
                    startActivity(intent);
                }
            });

            elec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RecycleviewActivity.this, ElectriActivity.class);
                    startActivity(intent);
                }
            });

            plumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RecycleviewActivity.this, PlumberActivity.class);
                    startActivity(intent);
                }
            });

            carpenter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RecycleviewActivity.this, MechanicActivity.class);
                    startActivity(intent);
                }
            });

            welder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RecycleviewActivity.this, MechanicActivity.class);
                    startActivity(intent);
                }
            });

            police.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RecycleviewActivity.this, PoliceActivity.class);
                    startActivity(intent);
                }
            });

            seeallworkers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RecycleviewActivity.this, GridView.class);
                    startActivity(intent);

                }
            });

            seeallemer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RecycleviewActivity.this, GridView.class);
                    startActivity(intent);

                }
            });

            foodactivity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(RecycleviewActivity.this, FoodActivity.class);
                    startActivity(intent);

                }
            });

            workersintent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(RecycleviewActivity.this, GridView.class);
                    startActivity(intent);

                }
            });
            emergengyintent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(RecycleviewActivity.this, GridView.class);
                    startActivity(intent);

                }
            });

            fooddeliveryintent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(RecycleviewActivity.this, FoodActivity.class);
                    startActivity(intent);

                }
            });
            policeintent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(RecycleviewActivity.this, PoliceActivity.class);
                    startActivity(intent);

                }
            });
        }
    }

    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;

        }else {
           backToast =  Toast.makeText(getBaseContext(),"Press again to exit", Toast.LENGTH_SHORT);
           backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }
}
