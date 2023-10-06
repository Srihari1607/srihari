package com.example.nischethanasahayak;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.nischethanasahayak.databinding.ActivityVitalsBinding;

public class VitalsActivity extends AppCompatActivity {
    ActivityVitalsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVitalsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        binding.HeartRateBtw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VitalsActivity.this,HeartRateActivity.class);
                startActivity(i);
            }
        });
        binding.BPBtw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VitalsActivity.this,bloodPressureActivity.class);
                startActivity(i);
            }
        });
        binding.TemperatureBtw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VitalsActivity.this,TempActivity.class);
                startActivity(i);
            }
        });
        binding.RespiratoryBtw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VitalsActivity.this,ResRateActivity.class);
                startActivity(i);
            }
        });
        binding.ArterialBtw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VitalsActivity.this,ABSpoActivity.class);
                startActivity(i);
            }
        });



        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
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