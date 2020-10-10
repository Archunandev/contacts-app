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
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RecycleviewActivity extends AppCompatActivity {

    private long backPressedTime;

    Button mechanic,elec,plumber,carpenter,welder,police,firstaid,ambulance,contactus;
    ImageView login,navigation,mapmenu,centerimage;
    ImageSlider mainSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);

        mechanic = findViewById(R.id.expandmechanic);
        elec = findViewById(R.id.expandelec);
        plumber = findViewById(R.id.expandplumber);
        carpenter = findViewById(R.id.expandcarpenter);
        welder = findViewById(R.id.expandwelder);
        police = findViewById(R.id.expandpolice);
        firstaid = findViewById(R.id.expandfirstaid);
        ambulance = findViewById(R.id.expandambulance);
        contactus = findViewById(R.id.expandcontactus);
        login = findViewById(R.id.login);
        navigation = findViewById(R.id.navigattion);
        mapmenu = findViewById(R.id.mapmenu);
        centerimage = findViewById(R.id.centerimage);


        mainSlider = (ImageSlider) findViewById(R.id.imageslider);

        final List <SlideModel> remoteimages = new ArrayList<>();

        FirebaseDatabase.getInstance().getReference().child("slider")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data:snapshot.getChildren()){
                            remoteimages.add(new SlideModel(data.child("url").getValue().toString(),data.child("title").getValue().toString(), ScaleTypes.FIT));

                            mainSlider.setImageList(remoteimages,ScaleTypes.FIT);

                            mainSlider.setItemClickListener(new ItemClickListener() {
                                @Override
                                public void onItemSelected(int i) {
                                    Toast.makeText(getApplicationContext(),remoteimages.get(i).getTitle().toString(),Toast.LENGTH_SHORT).show();
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
            navigation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RecycleviewActivity.this, Navigation.class);
                    startActivity(intent);
                }
            });


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

            firstaid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RecycleviewActivity.this, MechanicActivity.class);
                    startActivity(intent);
                }
            });

            ambulance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RecycleviewActivity.this, MechanicActivity.class);
                    startActivity(intent);
                }
            });

            contactus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RecycleviewActivity.this, MechanicActivity.class);
                    startActivity(intent);
                }
            });

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RecycleviewActivity.this, Signupnext2Activity.class);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onBackPressed() {


        if (backPressedTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
            return;

        }else {
            Toast.makeText(getBaseContext(),"Press again to exit", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }
}
