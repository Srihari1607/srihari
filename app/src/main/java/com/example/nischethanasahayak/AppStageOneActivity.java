package com.example.nischethanasahayak;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.nischethanasahayak.databinding.ActivityAppStageOneBinding;

public class AppStageOneActivity extends AppCompatActivity {
    ActivityAppStageOneBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppStageOneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        binding.AnesthesiaBtw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Anesthesia_i = new Intent(AppStageOneActivity.this,AnesthesiaActivity.class);
                startActivity(Anesthesia_i);

            }
        });


        binding.VitalsBtw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Vitals_i = new Intent(AppStageOneActivity.this,VitalsActivity.class);
                startActivity(Vitals_i);

            }
        });

        binding.AirwayRelatedBtw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Airway_i = new Intent(AppStageOneActivity.this,AirwayActivity.class);
                startActivity(Airway_i);

            }
        });

        binding.FluidNBloodBtw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Fluid_i = new Intent(AppStageOneActivity.this,FluidActivity.class);
                startActivity(Fluid_i);

            }
        });

        binding.CrisisBtw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Crisis_i = new Intent(AppStageOneActivity.this,crisisActivity.class);
                startActivity(Crisis_i);

            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}