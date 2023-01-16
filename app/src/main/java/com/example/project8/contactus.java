package com.example.project8;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class contactus extends AppCompatActivity {
    //Initialize variable
    ImageView ivWhatsApp, ivFacebook, ivInstagram, ivTwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
    }
}

