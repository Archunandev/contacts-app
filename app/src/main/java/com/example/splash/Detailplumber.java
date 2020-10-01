package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
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


public class Detailplumber extends AppCompatActivity {

    private static final  int REQUEST_CALL = 1;

    private ImageView imageViewdetailpl;
    TextView textviewdetailpl1, textViewdetailpl2, textViewdetailpl3, textViewdetailpl4, textViewdetailpl5;
    Button callplumber, callsmsplumber, callwhatsappplumber, mapplumber,chatp;

    DatabaseReference ref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailplumber);

        imageViewdetailpl = findViewById(R.id.imageviewdetailplumber);
        textviewdetailpl1 = findViewById(R.id.textviewdetailpl1);
        textViewdetailpl2 = findViewById(R.id.textviewdetailpl2);
        textViewdetailpl3 = findViewById(R.id.textviewdetailpl3);
        textViewdetailpl4 = findViewById(R.id.textviewdetailpl4);
        textViewdetailpl5 = findViewById(R.id.textviewdetailpl5);
        callplumber =findViewById(R.id.callusplumber);
        callsmsplumber =findViewById(R.id.sendsmsplumber);
        callwhatsappplumber =findViewById(R.id.sendwhatsappplumber);
        mapplumber =findViewById(R.id.mapplumber);
        chatp = findViewById(R.id.startchatpl);


        ref = FirebaseDatabase.getInstance().getReference().child("plumber");

        String Carkey = getIntent().getStringExtra("CarKey");

        ref.child(Carkey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    String locationm = snapshot.child("locationm").getValue().toString();
                    String namem = snapshot.child("namem").getValue().toString();
                    String phonem = snapshot.child("phonem").getValue().toString();
                    String sendsmsm = snapshot.child("sendsmsm").getValue().toString();
                    String sendwhatsappm =snapshot.child("sendwhatsappm").getValue().toString();
                    String photom = snapshot.child("photom").getValue().toString();

                    Picasso.get().load(photom).into(imageViewdetailpl);
                    textviewdetailpl1.setText(locationm);
                    textViewdetailpl2.setText(namem);
                    textViewdetailpl3.setText(phonem);
                    textViewdetailpl4.setText(sendsmsm);
                    textViewdetailpl5.setText(sendwhatsappm);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        textViewdetailpl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "I want Mechanic here is my address...";
                String number = textViewdetailpl4.getText().toString();

                Uri uri = Uri.parse("smsto:" + number);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body",message);
                startActivity(intent);

            }
        });
        textViewdetailpl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tonumber = textViewdetailpl5.getText().toString();
                Uri uri = Uri.parse("smsto:" + tonumber);
                Intent i =new Intent(Intent.ACTION_SENDTO,uri);
                i.setPackage("com.whatsapp");
                startActivity(Intent.createChooser(i, ""));

            }
        });




        callplumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:7708735468"));
                if (ContextCompat.checkSelfPermission(Detailplumber.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Detailplumber.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);

                    return;
                }
                startActivity(intent);
            }
        });

        callsmsplumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "I want Mechanic here is my address...";
                String number = "7708735468";

                Uri uri = Uri.parse("smsto:" + number);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body",message);
                startActivity(intent);

            }
        });

        callwhatsappplumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tonumber = "7708735468";
                String message = "i want mechanic here is my location...";
                tonumber = tonumber.replace("+", "").replace(" ", "");

                Intent sendIntent = new Intent("android.intent.action.MAIN");
                sendIntent.putExtra("jid", tonumber + "@s.whatsapp.net");
                sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setPackage("com.whatsapp");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

            }
        });
        chatp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Detailplumber.this, "Currently not available", Toast.LENGTH_SHORT).show();
            }
        });



    }
}