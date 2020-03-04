package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SearchView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainInterface extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    private ArrayList<Post> posts;
    SearchView searchView;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_interface);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelected(false);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_profile:
                        startActivity(new Intent(getApplicationContext(), Profile_Interface.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_tickets:
                        startActivity(new Intent(getApplicationContext(), Tickets_Interface.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        recyclerView = findViewById(R.id.recycler);
        posts = new ArrayList<>();
        for(int i = 0; i < 11; i++){
            posts.add(new Post("Event "+i ,"Date "+i , "Price "+i ));
        }
        postAdapter = new PostAdapter(this,posts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postAdapter);
        searchView = findViewById(R.id.searchView);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setIconified(false);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                postAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }
    public void onBackPressed()
    {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        this.finish();
    }
}
