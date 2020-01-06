package com.example.receiptify;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import static android.graphics.Color.argb;

public class MainActivity extends AppCompatActivity{

    private Intent settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settings = new Intent(this, SettingsActivity.class);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);


        createFabMenu();



    }

    void createFabMenu(){

        FloatingActionButton takePhoto = new FloatingActionButton(getBaseContext());
        takePhoto.setColorNormal(argb(255,255,0,0));
        takePhoto.setTitle("take a photo");
        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "take a photo", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton loadPhoto = new FloatingActionButton(getBaseContext());
        loadPhoto.setColorNormal(argb(255,0,255,0));
        loadPhoto.setTitle("point app to an existing photo from the phone's storage");
        loadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "point app to an existing photo from the phone's storage", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton inputManually = new FloatingActionButton(getBaseContext());
        inputManually.setColorNormal(argb(255,0,0,255));
        inputManually.setTitle("Input data manually!");
        inputManually.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Input data manually!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        menuMultipleActions.addButton(takePhoto);
        menuMultipleActions.addButton(loadPhoto);
        menuMultipleActions.addButton(inputManually);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(settings);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
