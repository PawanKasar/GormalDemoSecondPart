package com.example.gormaldemopartsecond.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import com.example.gormaldemopartsecond.R;
import com.example.gormaldemopartsecond.fragments.BooksFragment;

public class MainActivity extends AppCompatActivity {

    public static Toolbar toolbar;
    public static TextView titleMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        titleMain = (TextView) toolbar.findViewById(R.id.titleMain);
        openNewActivityOrFragment();
    }

    public void openNewActivityOrFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.mainContainer, new BooksFragment())
                .commit();
    }
}
