package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;

import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.myapplication.Fragment.CountriesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new CountriesFragment());
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.your_placeholder, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit(); // save the changes
    }
}

