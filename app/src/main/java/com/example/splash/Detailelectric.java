package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
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

public class Detailelectric extends AppCompatActivity {

    private static final  int REQUEST_CALL = 1;

    private ImageView imageViewdetailse;
    TextView textviewdetailse1, textViewdetailse2,textViewdetailse3,textViewdetailse4,textViewdetailse5;

    Button callelectri, callsmse, callwhatsappe, mape,chate;

    DatabaseReference refe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailelectric);

        imageViewdetailse = findViewById(R.id.imageviewdetaile);
        textviewdetailse1 = findViewById(R.id.textviewdetail1e);
        textViewdetailse2 = findViewById(R.id.textviewdetail2e);
        textViewdetailse3 = findViewById(R.id.textviewdetail3e);
        textViewdetailse4 = findViewById(R.id.textviewdetail4e);
        textViewdetailse5 = findViewById(R.id.textviewdetail5e);

        callelectri = findViewById(R.id.calluselectri);
        callsmse = findViewById(R.id.sendsmselectri);
        callwhatsappe = findViewById(R.id.sendwhatsappelectri);
        mape = findViewById(R.id.map);
        chate = findViewById(R.id.startchate);

        refe = FirebaseDatabase.getInstance().getReference().child("electri");

        String ElectriKey = getIntent().getStringExtra("ElectriKey");

        refe.child(ElectriKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    String locatione = snapshot.child("locatione").getValue().toString();
                    String namee = snapshot.child("namee").getValue().toString();
                    String phonee = snapshot.child("phonee").getValue().toString();
                    String sendsmse = snapshot.child("sendsmse").getValue().toString();
                    String sendwhatsappe = snapshot.child("sendwhatsappe").getValue().toString();
                    String photoe = snapshot.child("photoe").getValue().toString();

                    Picasso.get().load(photoe).into(imageViewdetailse);
                    textviewdetailse1.setText(locatione);
                    textViewdetailse2.setText(namee);
                    textViewdetailse3.setText(phonee);
                    textViewdetailse4.setText(sendsmse);
                    textViewdetailse5.setText(sendwhatsappe);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        textViewdetailse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "I want Mechanic here is my address...";
                String number = textViewdetailse4.getText().toString();

                Uri uri = Uri.parse("smsto:" + number);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body",message);
                startActivity(intent);

            }
        });
        textViewdetailse5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tonumber = textViewdetailse5.getText().toString();
                Uri uri = Uri.parse("smsto:" + tonumber);
                Intent i =new Intent(Intent.ACTION_SENDTO,uri);
                i.setPackage("com.whatsapp");
                startActivity(Intent.createChooser(i, ""));

            }
        });

        callelectri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:7708735468"));
                if (ContextCompat.checkSelfPermission(Detailelectric.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Detailelectric.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);

                    return;
                }
                startActivity(intent);
            }
        });

        callsmse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = " Hello vecties team, I want Mechanic here is my address...";
                String number = "7708735468";

                Uri uri = Uri.parse("smsto:" + number);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body",message);
                startActivity(intent);

            }
        });

        callwhatsappe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tonumber = "7708735468";
                String message = "hello vecties team, i want mechanic here is my location...";
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
        chate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Detailelectric.this, "Currently not available", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
