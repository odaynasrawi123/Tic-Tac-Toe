package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private Button activity1BTN,textSharing,emailSharing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        activity1BTN = findViewById(R.id.button_Activity1);
        activity1BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });
        textSharing= findViewById(R.id.textSharing);
        textSharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtShare= "TicTacToe Game";
                String link="https://play.google.com/store/apps/details?id=com.eawedat.milon";

                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT,txtShare+"\n"+ link);
                startActivity(Intent.createChooser(share,"My share"));
            }
        });
        emailSharing = findViewById(R.id.emailSharing);
        emailSharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendemail= new Intent(Intent.ACTION_SEND);
                sendemail.setData(Uri.parse("mailto:"));
                sendemail.setType("message/rfc822");
                sendemail.putExtra(Intent.EXTRA_EMAIL,new String[]{
                        "oday-nasrawi@hotmail.com"
                });
                sendemail.putExtra(Intent.EXTRA_SUBJECT,"My App");
                sendemail.putExtra(Intent.EXTRA_TEXT,"Thank you for downloading my App");
                startActivity(sendemail);
            }
        });
    }

    public void openActivity1(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}

