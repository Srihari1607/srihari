package com.example.nischethanasahayak;

import static com.example.nischethanasahayak.R.id.button;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AnesthesiaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    List<String> items;
    EditText weightEditText;
    Button calculateButton;
    TextView resultTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anesthesia);

        spinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.select_a_drug, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        weightEditText = findViewById(R.id.editTextWeight);
        calculateButton = findViewById(R.id.buttonCalculate);
        resultTextView = findViewById(R.id.textViewResult);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedDrug = spinner.getSelectedItem().toString();
                String weightStr = weightEditText.getText().toString();

                if (selectedDrug.isEmpty() || weightStr.isEmpty()) {
                    resultTextView.setText("Please select a drug and enter weight.");
                } else {
                    try {
                        float weight = Float.parseFloat(weightStr);
                        float dose = calculateDose(selectedDrug, weight);
                        resultTextView.setText(String.format("%.4f", dose));
                    } catch (NumberFormatException e) {
                        resultTextView.setText("Invalid weight value.");
                    }
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Handle item selection if needed
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Handle case where nothing is selected (if needed)
    }

    private float calculateDose(String drug, float weight) {
        switch (drug) {
            case "thiopentane":
                return 8.0f / weight;
            case "propofol induction":
                return 3.0f / weight;
            case "propofol induction infusion":
                return 0.2f / weight;
            case "ketamine":
                return 2.0f / weight;
            case "ketamine oral premedication":
                return 10.0f / weight;
            default:
                return 0.0f; // Handle invalid drug
        }
    }
}
