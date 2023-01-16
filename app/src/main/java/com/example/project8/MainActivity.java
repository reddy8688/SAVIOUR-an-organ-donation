package com.example.project8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
     FirebaseAuth mAuth;
    private Button button;
    private CardView bloodbank,transhosiptal,pledgeorgan,profile,eyebanks,skinbanks ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();


        bloodbank=(CardView) findViewById(R.id.bloodbank);
        transhosiptal=(CardView) findViewById(R.id.transhosiptal);
        pledgeorgan=(CardView) findViewById(R.id.pledgeorgan);
        eyebanks=(CardView) findViewById(R.id.eyebanks);
        profile=(CardView) findViewById(R.id.profile);
        skinbanks=(CardView) findViewById(R.id.skinbanks);


        bloodbank.setOnClickListener((View.OnClickListener)this);
        transhosiptal.setOnClickListener((View.OnClickListener)this);
        pledgeorgan.setOnClickListener((View.OnClickListener)this);
        eyebanks.setOnClickListener((View.OnClickListener)this);
        profile.setOnClickListener((View.OnClickListener)this);
        skinbanks.setOnClickListener((View.OnClickListener)this);




    }
    @Override
    public void onClick(View v) {
        Intent i ;
        switch ((v.getId())){
            case R.id.bloodbank: i = new Intent(this,bloodbank.class); startActivity(i);break;
            case R.id.transhosiptal: i = new Intent(this,transhosiptal.class); startActivity(i);break;
            case R.id.pledgeorgan: i = new Intent(this,pledgeorgan.class); startActivity(i);break;
            case R.id.eyebanks: i = new Intent(this,eyebanks.class); startActivity(i);break;
            case R.id.profile: i = new Intent(this,profile.class); startActivity(i);break;
            case R.id.skinbanks: i = new Intent(this,skinbanks.class); startActivity(i);break;


        }
    }
}