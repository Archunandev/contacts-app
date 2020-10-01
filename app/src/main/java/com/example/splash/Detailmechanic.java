package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
public class Detailmechanic extends AppCompatActivity {


    private static final  int REQUEST_CALL = 1;

    private ImageView imageViewdetails;
    TextView textviewdetails1, textViewdetails2, textViewdetails3,textViewdetails4,textViewdetails5;
    Button callmechanic, callsms, callwhatsapp, map,chat;

    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailmechanic);

        imageViewdetails = findViewById(R.id.imageviewdetail);
        textviewdetails1 = findViewById(R.id.textviewdetail1);
        textViewdetails2 = findViewById(R.id.textviewdetail2);
        textViewdetails3 = findViewById(R.id.textviewdetail3);
        textViewdetails4 = findViewById(R.id.textviewdetail4);

        textViewdetails5 = findViewById(R.id.textviewdetail5);
        callmechanic = findViewById(R.id.callusmechanic);
        callsms = findViewById(R.id.sendsmsmechanic);
        callwhatsapp = findViewById(R.id.sendwhatsappmechanic);
        map = findViewById(R.id.map);
        chat = findViewById(R.id.startchat);


        ref = FirebaseDatabase.getInstance().getReference().child("car");

        String Carkey = getIntent().getStringExtra("CarKey");

        ref.child(Carkey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    String locationm = snapshot.child("locationm").getValue().toString();
                    String namem = snapshot.child("namem").getValue().toString();
                    String phonem = snapshot.child("phonem").getValue().toString();
                    String sendsmsm = snapshot.child("sendsmsm").getValue().toString();
                    String sendwhatsappm = snapshot.child("sendwhatsappm").getValue().toString();
                    String photom = snapshot.child("photom").getValue().toString();


                    Picasso.get().load(photom).into(imageViewdetails);
                    textviewdetails1.setText(locationm);
                    textViewdetails2.setText(namem);
                    textViewdetails3.setText(phonem);
                    textViewdetails4.setText(sendsmsm);
                    textViewdetails5.setText(sendwhatsappm);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        textViewdetails4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = " hello workers i want Mechanic here is my address...";
                String number = textViewdetails4.getText().toString();

                Uri uri = Uri.parse("smsto:" + number);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body",message);
                startActivity(intent);

            }
        });
        textViewdetails5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tonumber = textViewdetails5.getText().toString();
                Uri uri = Uri.parse("smsto:" + tonumber);
                Intent i =new Intent(Intent.ACTION_SENDTO,uri);
                i.setPackage("com.whatsapp");
                startActivity(Intent.createChooser(i, ""));

            }
        });




        callmechanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String number = textViewdetails3.getText().toString();
                intent.setData(Uri.parse("tel:" + number));
                if (ContextCompat.checkSelfPermission(Detailmechanic.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Detailmechanic.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);

                    return;
                }
                startActivity(intent);
            }
        });

        callsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = " hello workers i want Mechanic here is my address...";
                String number = textViewdetails4.getText().toString();

                Uri uri = Uri.parse("smsto:" + number);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body",message);
                startActivity(intent);

            }
        });

        callwhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tonumber = textViewdetails5.getText().toString();
                Uri uri = Uri.parse("smsto:" + tonumber);
                Intent i =new Intent(Intent.ACTION_SENDTO,uri);
                i.setPackage("com.whatsapp");
                startActivity(Intent.createChooser(i, ""));

            }
        });

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Detailmechanic.this, "Currently not available", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
