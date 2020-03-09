package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Help_Interface extends AppCompatActivity {
    LinearLayout faq;
    LinearLayout email;
    LinearLayout call;
    LinearLayout privacy;
    LinearLayout term;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help__interface);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Help");
        faq = findViewById(R.id.faq_layout);
        email = findViewById(R.id.email_layout);
        call = findViewById(R.id.call_layout);
        privacy = findViewById(R.id.privacy_layout);
        term = findViewById(R.id.term_layout);
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Something will happen",Toast.LENGTH_LONG).show();
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Something will happen",Toast.LENGTH_LONG).show();
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Something will happen",Toast.LENGTH_LONG).show();
            }
        });
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Something will happen",Toast.LENGTH_LONG).show();
            }
        });
        term.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Something will happen",Toast.LENGTH_LONG).show();
            }
        });
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.nav_profile);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_tickets:
                        startActivity(new Intent(getApplicationContext(), Tickets_Interface.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_profile:
                        startActivity(new Intent(getApplicationContext(), Profile_Interface.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_events:
                        startActivity(new Intent(getApplicationContext(), MainInterface.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(getApplicationContext(),Profile_Interface.class));
        this.finish();
    }
}